package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    public final double real;
    public final double imaginary;

    public ComplexNumber() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }
    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0.0;
    }
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public boolean isReal() {
        return this.imaginary == 0.0;
    }

    public boolean isImaginary() {
        return this.real == 0.0;
    }

    public ComplexNumber getConjugate() {
        return this.imaginary == 0 ? new ComplexNumber(this.real, this.imaginary)
                : new ComplexNumber(this.real, -this.imaginary);
    }

    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber((this.real + num.real), (this.imaginary + num.imaginary));
    }
    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber((this.real - num.real), (this.imaginary - num.imaginary));
    }
    public ComplexNumber multiply(ComplexNumber num) {
        return new ComplexNumber((this.real * num.real) - (this.imaginary * num.imaginary),
                (this.real * num.imaginary) + (num.real * this.imaginary));
    }
    public ComplexNumber divide(ComplexNumber num) {
        double denominator = num.real * num.real + num.imaginary * num.imaginary;
        assert (denominator != 0) : "denominator is 0";
        double realNum = this.real * num.real + this.imaginary * num.imaginary;
        double imaginaryNum = this.imaginary * num.real - this.real * num.imaginary;
        return new ComplexNumber(realNum / denominator, imaginaryNum / denominator);
    }
}
