package at.ac.fhbfi.springdatademo.shape;

public abstract class Shape {

    public abstract double getArea();
    public abstract double getPerimeter();
    abstract String getShapeName();

    public void print() {
        System.out.printf("%-10s Area: %.1f - Perimeter: %.1f\n",
                getShapeName(),
                getArea(),
                getPerimeter());
    }

}
