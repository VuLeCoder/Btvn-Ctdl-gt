package Bt3;

import java.util.ArrayList;

public class Paint {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        
        shapes.add(new Point(2, 3));
        shapes.add(new Circle(5, 5, 2));
        shapes.add(new Line(new Point(0, 0), new Point(4, 0)));
        shapes.add(new Rectangle(2, 2, 4, 6));

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.area());
            System.out.println("Perimeter: " + shape.perimeter());
            System.out.println("--------------------");
        }
        
        for (Shape shape : shapes) {
            shape.rotate(Math.PI);
        }
        
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.area());
            System.out.println("Perimeter: " + shape.perimeter());
            System.out.println("--------------------");
        }
        
    }
}

