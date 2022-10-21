package at.ac.fhbfi.springdatademo;

import at.ac.fhbfi.springdatademo.shape.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ShapeTest {

    @Test
    void testShapes() {
        Collection<Shape> shapes = new ArrayList<>();
        shapes.add(Square.builder().width(5).build());
        shapes.add(Rectangle.builder().width(5).length(7).build());
        shapes.add(Circle.builder().radius(2).build());
        shapes.add(RightTriangle.builder().a(3).b(4).build());

        shapes.forEach(shape -> shape.print());
    }

}
