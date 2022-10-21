package at.ac.fhbfi.springdatademo.util;

public abstract class MySuperClass {

    public final void myMethod() {
        System.out.println("output mySuperClass");
        myTemplateMethod();
    }

    abstract void myTemplateMethod();

}
