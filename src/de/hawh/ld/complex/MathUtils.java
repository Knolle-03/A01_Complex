package de.hawh.ld.complex;

import java.math.BigDecimal;

public class MathUtils {

    static Complex exponentialFunction(Complex num) {
        double realP = Math.pow(Math.E, real(num).doubleValue()) * (Math.cos(imag(num).doubleValue()));
        double imagP = Math.pow(Math.E, real(num).doubleValue()) * (Math.sin(imag(num).doubleValue()));

        return new Complex(realP, imagP);
    }

    static  Complex logarithm(Complex num) {

        double realP = 0.5 * Math.log(Math.pow(real(num).doubleValue(), 2) + Math.pow(imag(num).doubleValue(), 2));
        double imagP = Math.atan2(imag(num).doubleValue(), real(num).doubleValue());

        return new Complex(realP, imagP);
    }

    static  Complex sine(Complex num) {
        double realP = Math.sin(real(num).doubleValue()) * Math.cosh(imag(num).doubleValue());
        double imagP = Math.cos(real(num).doubleValue()) * Math.sinh(imag(num).doubleValue());

        return new Complex(realP, imagP);
    }

    static  Complex cosine(Complex num) {
        double realP = Math.cos(real(num).doubleValue()) * Math.cosh(imag(num).doubleValue());
        double imagP = Math.sin(real(num).doubleValue()) * Math.sinh(imag(num).doubleValue()) * -1;

        return new Complex(realP, imagP);
    }

    static Complex tangent(Complex num) {
        double realP = Math.sin(2 * real(num).doubleValue()) / (Math.cos(2 * real(num).doubleValue()) + Math.cosh(2* imag(num).doubleValue()));
        double imagP = Math.sinh(2 * imag(num).doubleValue()) / (Math.cos(2 * real(num).doubleValue()) + Math.cosh(2* imag(num).doubleValue()));

        return new Complex(realP, imagP);
    }

    static Complex hyperbolicSine(Complex num) {
        double realP = Math.sinh(real(num).doubleValue()) * Math.cos(imag(num).doubleValue());
        double imagP = Math.cosh(real(num).doubleValue()) * Math.sin(imag(num).doubleValue());

        return new Complex(realP, imagP);
    }

    static Complex hyperbolicCosine(Complex num) {
        double realP = Math.cosh(real(num).doubleValue()) * Math.cos(imag(num).doubleValue());
        double imagP = Math.sinh(real(num).doubleValue()) * Math.sin(imag(num).doubleValue());

        return new Complex(realP, imagP);
    }

    private static BigDecimal real(Complex number) {
        //return number.real();
        return BigDecimal.valueOf(number.real());
    }

    private static BigDecimal imag(Complex number) {
        //return number.imag();
        return BigDecimal.valueOf(number.imag());
    }
}
