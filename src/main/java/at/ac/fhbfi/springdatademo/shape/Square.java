package at.ac.fhbfi.springdatademo.shape;

import lombok.Builder;

@Builder
public class Square extends Shape {

    private double width;

    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getPerimeter() {
        return 4 * width;
    }

    @Override
    String getShapeName() {
        return "Quadrat";
    }
}
