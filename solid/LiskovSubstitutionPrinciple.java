package solid;

/**
 * Demonstrates Liskov Substitution Principle (LSP).
 * - Broken example: Square extends a mutable Rectangle and overrides setters -> violates LSP.
 * - Correct example: use a Shape abstraction (area only) or keep Square separate from Rectangle.
 */

//LSP is about ensuring that subclasses can stand in for their base classes without altering the correctness of the program.
//In simple terms, if class B is a subclass of class A, then we should be able to replace A with B without affecting the functionality of the program.
public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        System.out.println("== Broken example (violates LSP) ==");
        RectangleMutable r = new RectangleMutable();
        r.setWidth(5);
        r.setHeight(10);
        System.out.println("RectangleMutable area (expected 50): " + r.getArea());

        RectangleMutable sqAsRect = new SquareMutable();
        sqAsRect.setWidth(5);
        sqAsRect.setHeight(10);
        // Client expects 5 * 10 = 50, but SquareMutable mutates differently -> unexpected result
        System.out.println("SquareMutable as RectangleMutable area (unexpected): " + sqAsRect.getArea());

        System.out.println("\n== Correct example (adheres to LSP) ==");
        Shape rect = new RectangleImmutable(5, 10);
        Shape square = new Square(7);
        System.out.println("RectangleImmutable area: " + rect.area());
        System.out.println("Square area: " + square.area());
    }

    // Broken, mutable Rectangle
    static class RectangleMutable {
        protected int width;
        protected int height;

        public void setWidth(int w) { this.width = w; }
        public void setHeight(int h) { this.height = h; }
        public int getArea() { return width * height; }
    }

    // SquareMutable overrides setters to keep invariant (width == height) -> breaks substitution
    static class SquareMutable extends RectangleMutable {
        @Override
        public void setWidth(int w) {
            this.width = w;
            this.height = w;
        }

        @Override
        public void setHeight(int h) {
            this.height = h;
            this.width = h;
        }
    }

    // Correct approach: Shape abstraction exposes behavior (area) and immutable implementations
    interface Shape {
        int area();
    }

    static class RectangleImmutable implements Shape {
        private final int width;
        private final int height;
        public RectangleImmutable(int width, int height) {
            this.width = width; this.height = height;
        }
        @Override public int area() { return width * height; }
    }

    static class Square implements Shape {
        private final int side;
        public Square(int side) { this.side = side; }
        @Override public int area() { return side * side; }
    }
}