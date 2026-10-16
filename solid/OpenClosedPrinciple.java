package solid;

import java.util.ArrayList;
import java.util.List;

//This class demonstrates the Open/Closed Principle
//OCP states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
//OCP helps in making the system more maintainable and scalable by allowing new functionality to be added without altering existing code.
//In this example, we define a Shape interface and implement different shapes like Rectangle and Circle.
//The AreaCalculator class can calculate the total area of a list of shapes without needing to know the details of each shape.
public class OpenClosedPrinciple {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Circle(2));
        shapes.add(new Square(5)); // new shape added without changing AreaCalculator

        AreaCalculator calculator = new AreaCalculator();
        double total = calculator.totalArea(shapes);

        System.out.printf("Total area of shapes: %.4f%n", total);
    }
}

// Abstraction that is closed for modification but open for extension
interface Shape {
    double area();
}

class Rectangle implements Shape {
    protected final double width;
    protected final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// We can add this new shape without modifying AreaCalculator or other existing classes.
class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

// Responsibility: calculate areas using the Shape abstraction
class AreaCalculator {
    public double totalArea(List<Shape> shapes) {
        double total = 0;
        for (Shape s : shapes) {
            total += s.area();
        }
        return total;
    }
}

