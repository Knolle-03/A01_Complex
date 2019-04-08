package de.hawh.ld.complex;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Lennart Draeger
 *
 * The MathUtils class which is used by ComplexMutable as well as ComplexImmutable.
 * The class provides basic arithmetic opterations and more complex operations like logarithm and exopnential functions.
 */
public class MathUtils {

    public static Complex add(Complex a, Complex b) {
        double realPart = real(a).add(real(b)).doubleValue();
        double imagPart = imag(a).add(imag(b)).doubleValue();

        return new ComplexImmutable(realPart, imagPart);
    }


    public static Complex sub(Complex a, Complex b) {
        double realPart = real(a).subtract(real(b)).doubleValue();
        double imagPart = imag(a).subtract(imag(b)).doubleValue();

        return new ComplexImmutable(realPart, imagPart);
    }


    public static Complex mul(Complex a, Complex b) {
        double realPart = real(a).multiply(real(b)).subtract(imag(a).multiply(imag(b))).doubleValue();
        double imagPart = real(a).multiply(imag(b)).add(imag(a).multiply(real(b))).doubleValue();

        return new ComplexImmutable(realPart, imagPart);
    }

    public static Complex div(Complex a, Complex b) {
        double realPart = (real(a).multiply(real(b)).add(imag(a).multiply(imag(b))).divide
                (real(b).multiply(real(b)).add(imag(b).multiply(imag(b))), 5, RoundingMode.UP)).doubleValue();

        double imagPart = (real(b).multiply(imag(a)).subtract(real(a).multiply(imag(b))).divide
                (real(b).multiply(real(b)).add(imag(b).multiply(imag(b))), 5, RoundingMode.UP)).doubleValue();

        return new ComplexImmutable(realPart, imagPart);
    }

    public static Complex exponentialFunction(Complex num) {
        double realP = Math.pow(Math.E, real(num).doubleValue()) * (Math.cos(imag(num).doubleValue()));
        double imagP = Math.pow(Math.E, real(num).doubleValue()) * (Math.sin(imag(num).doubleValue()));

        return new ComplexImmutable(realP, imagP);
    }

    public static  Complex logarithm(Complex num) {

        double realP = 0.5 * Math.log(Math.pow(real(num).doubleValue(), 2) + Math.pow(imag(num).doubleValue(), 2));
        double imagP = Math.atan2(imag(num).doubleValue(), real(num).doubleValue());

        return new ComplexImmutable(realP, imagP);
    }

    public static  Complex sine(Complex num) {
        double realP = Math.sin(real(num).doubleValue()) * Math.cosh(imag(num).doubleValue());
        double imagP = Math.cos(real(num).doubleValue()) * Math.sinh(imag(num).doubleValue());

        return new ComplexImmutable(realP, imagP);
    }

    public static  Complex cosine(Complex num) {
        double realP = Math.cos(real(num).doubleValue()) * Math.cosh(imag(num).doubleValue());
        double imagP = Math.sin(real(num).doubleValue()) * Math.sinh(imag(num).doubleValue()) * -1;

        return new ComplexImmutable(realP, imagP);
    }

    public static Complex tangent(Complex num) {
        double realP = Math.sin(2 * real(num).doubleValue()) / (Math.cos(2 * real(num).doubleValue()) + Math.cosh(2* imag(num).doubleValue()));
        double imagP = Math.sinh(2 * imag(num).doubleValue()) / (Math.cos(2 * real(num).doubleValue()) + Math.cosh(2* imag(num).doubleValue()));

        return new ComplexImmutable(realP, imagP);
    }

    public static Complex hyperbolicSine(Complex num) {
        double realP = Math.sinh(real(num).doubleValue()) * Math.cos(imag(num).doubleValue());
        double imagP = Math.cosh(real(num).doubleValue()) * Math.sin(imag(num).doubleValue());

        return new ComplexImmutable(realP, imagP);
    }

    public static Complex hyperbolicCosine(Complex num) {
        double realP = Math.cosh(real(num).doubleValue()) * Math.cos(imag(num).doubleValue());
        double imagP = Math.sinh(real(num).doubleValue()) * Math.sin(imag(num).doubleValue());

        return new ComplexImmutable(realP, imagP);
    }

    public static Complex hyperbolicTangent(Complex num) {
        Complex complex1 = hyperbolicSine(num);
        Complex complex2 = hyperbolicCosine(num);

        return MathUtils.div(complex1, complex2);
    }


    public static double getAbs(Complex num) {

        return Math.sqrt(real(num).multiply(real(num)).add(imag(num).multiply(imag(num))).doubleValue());
    }

    public static Double getPhase(Complex num) {
        double phase = Math.atan2(imag(num).doubleValue(), real(num).doubleValue());
        if (phase < 0) {

            return phase + 2 * Math.PI;
        } else {

            return phase;
        }
    }

    public static double getDegreeOfPhase(Complex num) {

        return Math.toDegrees(getPhase(num));
    }

    public static String trigonometricPolarForm(Complex num) {

        return String.format("(%f  {cos( %+f) +i*(sin( %+f)}",getAbs(num), getPhase(num),getPhase(num));
    }

    public static String expoPolarForm(Complex num) {

        return String.format("(%f * e^i*%+f)", getAbs(num), getPhase(num));
    }

    public static Complex complexConjugate(Complex number) {
        if(imag(number).compareTo(BigDecimal.ZERO) != 0) {

            return new ComplexImmutable(number.real(), (number.imag() * -1));
        } else {

            return new ComplexImmutable(number.real(), number.imag());
        }
    }

    public static Complex powerOfTwo(Complex num) {
        double realP = real(num).multiply(real(num)).subtract(imag(num).multiply(imag(num))).doubleValue();
        double imagP = real(num).multiply(imag(num).multiply(BigDecimal.valueOf(2))).doubleValue();

        return new ComplexImmutable(realP, imagP);
    }

    private static BigDecimal real(Complex number) {

        return BigDecimal.valueOf(number.real());
    }

    private static BigDecimal imag(Complex number) {

        return BigDecimal.valueOf(number.imag());
    }
}