package academy.pocu.comp2500.lab2.app;

import academy.pocu.comp2500.lab2.ComplexNumber;

public class Program {
    private static final double DOUBLE_EPSILON = 0.00001;

    private static void print(ComplexNumber num) {
        System.out.printf("%s : %f\n", "Real", num.real);
        System.out.printf("%s : %f\n", "Imag", num.imaginary);
    }

    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber();
        ComplexNumber num2 = new ComplexNumber(10.0);
        ComplexNumber num3 = new ComplexNumber(2.5, -5.1);
        ComplexNumber num4 = new ComplexNumber(0.0, 0.0012);

        print(num1);

        print(num2.getConjugate());
    }
}
