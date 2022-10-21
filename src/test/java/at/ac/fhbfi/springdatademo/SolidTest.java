package at.ac.fhbfi.springdatademo;

import at.ac.fhbfi.springdatademo.util.MySubClassOne;
import at.ac.fhbfi.springdatademo.util.MySubClassTwo;
import at.ac.fhbfi.springdatademo.util.MySuperClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SolidTest {

    @Test
    void testTemplateMethod() {
        MySubClassOne a = new MySubClassOne();
        MySubClassTwo b = new MySubClassTwo();

        System.out.println("***** a");
        a.myMethod();
        System.out.println("***** b");
        b.myMethod();




    }

}
