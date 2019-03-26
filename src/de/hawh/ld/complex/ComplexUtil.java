package de.hawh.ld.complex;

import java.math.*;

class ComplexUtil {

    static Complex add(Complex a, Complex b) {
        double realPart = real(a).add(real(b)).doubleValue();
        double imagPart = imag(a).add(imag(b)).doubleValue();

        return new Complex(realPart, imagPart);
    }

    static Complex sub(Complex a, Complex b) {
        double realPart = real(a).subtract(real(b)).doubleValue();
        double imagPart = imag(a).subtract(imag(b)).doubleValue();

        return new Complex(realPart, imagPart);
    }

    static Complex mul(Complex a, Complex b) {

        double realPart = real(a).multiply(real(b)).subtract(imag(a).multiply(imag(b))).doubleValue();
        double imagPart = real(a).multiply(imag(b)).add(imag(a).multiply(real(b))).doubleValue();

        return new Complex(realPart, imagPart);
    }

    static Complex div(Complex a, Complex b) {
/*
        Complex res = new Complex(0, 0);

        try {*/
            double realPart = (real(a).multiply(real(b)).add(imag(a).multiply(imag(b))).divide
                    (real(b).multiply(real(b)).add(imag(b).multiply(imag(b))), 5, RoundingMode.UP)).doubleValue();

            double imagPart = (real(b).multiply(imag(a)).subtract(real(a).multiply(imag(b))).divide
                    (real(b).multiply(real(b)).add(imag(b).multiply(imag(b))), 5, RoundingMode.UP)).doubleValue();

            return new Complex(realPart, imagPart);
       /* }
        catch (ArithmeticException ex) {
            System.out.println("NaN");
            return res;
        }*/
    }

    static double getAbs(Complex num) {
          return Math.sqrt(real(num).multiply(real(num)).add(imag(num).multiply(imag(num))).doubleValue());
        }

    static Double getPhase(Complex num) {
        //TODO: fix phase for negative real parts.
        double phase = 0.0D;
        if (real(num) < 0)
        return Math.atan2(imag(num).doubleValue(), real(num).doubleValue());
    }

    static double getDegreeOfPhase(Complex num) {
        return Math.toDegrees(getPhase(num));
    }

    static double exponent(Complex num) {
        return Math.pow(Math.E, getPhase(num));
    }

    static String trigoPolarForm(Complex num) {
        return String.format("(%."+ getDecimalPlaces(getAbs(num)) +
                "f  {cos( %+." + getDecimalPlaces(getPhase(num)) + "f) +i*(sin( %+." + getDecimalPlaces(getPhase(num)) + "f)}"
                ,getAbs(num), getPhase(num),getPhase(num));
    }

    static String expoPolarForm(Complex num) {
        return String.format("(%."+ getDecimalPlaces(getAbs(num)) + "f * e^i*" + getPhase(num) + ")"
                , getAbs(num), getPhase(num));
    }

    private static BigDecimal real(Complex number) {
        //return number.real();
        return BigDecimal.valueOf(number.real());
    }

    private static BigDecimal imag(Complex number) {
        //return number.imag();
        return BigDecimal.valueOf(number.imag());
    }

    static Complex complexConjugate(Complex number) {
        if(imag(number).compareTo(BigDecimal.ZERO) != 0) {

            return new Complex(number.real(), (number.imag() * -1));
        } else {

            return new Complex(number.real(), number.imag());
        }
    }

    private static int getDecimalPlaces(double num) {
        return String.valueOf(num).split("\\.")[1].length();
    }
}
