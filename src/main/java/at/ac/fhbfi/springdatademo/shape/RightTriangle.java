package at.ac.fhbfi.springdatademo.shape;

import lombok.Builder;

@Builder
public class RightTriangle extends Shape {

    private double a;
    private double b;

    @Override
    public double getArea() {
        return (a * b) / 2;
    }

    @Override
    public double getPerimeter() {
        return a + b + Math.sqrt(a*a + b*b);
    }

    @Override
    String getShapeName() {
        return "Dreieck";
    }
}
