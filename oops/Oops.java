package oops;
public class Oops {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.write();

    }
}

//method overloading- compile time polymorphism
class Pen {
        public void write() {
            System.out.println("Writing");
        }

        public int write(String message) {
            return 1;
        }

        public boolean write(String message, int number) {
            return true;
        }
    }
