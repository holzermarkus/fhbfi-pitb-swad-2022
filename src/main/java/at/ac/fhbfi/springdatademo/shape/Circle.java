package at.ac.fhbfi.springdatademo.shape;

import lombok.Builder;

@Builder
public class Circle extends Shape {

    private double radius;

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    String getShapeName() {
        return "Kreis";
    }
}
