package at.ac.fhbfi.springdatademo.shape;

import lombok.Builder;

@Builder
public class Rectangle extends Shape {

    private double width;
    private double length;

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return width+width+length+length;
    }

    @Override
    String getShapeName() {
        return "Rechteck";
    }
}
