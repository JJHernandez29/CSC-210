package csc210.ComplexNumber;
public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber() {
        this.real = 0;
        this.imag = 0;
    }

    public ComplexNumber(double _r, double _i) {
        this.real = _r;
        this.imag = _i;
    }

    public ComplexNumber(ComplexNumber rhs) {
        this.real = rhs.real;
        this.imag = rhs.imag;
    }

    public void setReal(double r) {
        this.real = r;
    }

    public void setImag(double i) {
        this.imag = i;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    @Override
    public String toString() {
        if (imag < 0) {
            return real + " - " + (-imag) + "i";
        } else {
            return real + " + " + imag + "i";
        }
    }

    public ComplexNumber add(ComplexNumber rhs) {
        return new ComplexNumber(this.real + rhs.real, this.imag + rhs.imag);
    }

    public ComplexNumber sub(ComplexNumber rhs) {
        return new ComplexNumber(this.real - rhs.real, this.imag - rhs.imag);
    }

    public ComplexNumber mult(ComplexNumber rhs) {
        double newReal = (this.real * rhs.real) - (this.imag * rhs.imag);
        double newImag = (this.real * rhs.imag) + (this.imag * rhs.real);
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber div(ComplexNumber rhs) throws ArithmeticException {
        double denominator = rhs.real * rhs.real + rhs.imag * rhs.imag;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double newReal = (this.real * rhs.real + this.imag * rhs.imag) / denominator;
        double newImag = (this.imag * rhs.real - this.real * rhs.imag) / denominator;
        return new ComplexNumber(newReal, newImag);
    }

    public double mag() {
        return Math.sqrt(real * real + imag * imag);
    }

    public ComplexNumber conj() {
        return new ComplexNumber(real, -imag);
    }

    public ComplexNumber sqrt() {
        if (imag != 0) {
            double magnitude = Math.sqrt(real * real + imag * imag);
            double newReal = Math.sqrt((real + magnitude) / 2);
            double newImag = Math.signum(imag) * Math.sqrt((-real + magnitude) / 2);
            return new ComplexNumber(newReal, newImag);
        } else {
            if (real >= 0) {
                return new ComplexNumber(Math.sqrt(real), 0);
            } else {
                return new ComplexNumber(0, Math.sqrt(-real));
            }
        }
    }

    public boolean equals(ComplexNumber rhs) {
        return this.real == rhs.real && this.imag == rhs.imag;
    }
}
