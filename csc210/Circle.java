package csc210;


public class Circle {
    //member variables (attributes) that describes a circle
    private double radius;
    private int x;
    private int y;
//access modifier: private, public, protected, "package"

// member functions (behaviors, operations) that can operate on a circle
// <access modifiers> <return type> <funciton name>(argument list) [ <code body statements>; ]

    //construction
    //      same as name of class
    //      no return type
    //
    //  allocate memory in heap memory
    //  initialize the mrmber variables
    
    //should always proveide the default constructor (no arguments) even
    //if it has no code
    public Circle() {

    }

    // overload connstructors (with arguments) can be provided as necessary
    public Circle(int x, int y, double radius) throws IllegalArgumentException {
        if (radius < 0) {
            throw new IllegalArgumentException("negative radius");
        }
        // "this" is a self referene variable (jumps directly to class scope)
        this.x = x;
        this.y = y;
        this.radius = 1.0;
    }
    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = 1.0;
    }
    public Circle(double radius) {
        this.x = 0;
        this.y = 0;
        this.radius = radius;
    }

    // getter and setter functions to provide "controlled" access to member private variables
    public void setx(int x) {
        this.x = x;
    }
    public void sety(int y) {
        this.y = y;
    }
    public void setRadius(double radius) throws IllegalArgumentException {

    }



}
