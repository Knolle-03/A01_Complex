package de.hawh.ld.complex;

import java.util.Objects;

/**
 * @author Lennart Draeger
 *
 * derived class from the abstract class Complex. Can construct object in mutiple ways
 * equals and hashCode is overridden, so that only ComplexMutable objects can be
 * compared in terms of attributes.
 */

public class ComplexMutable extends Complex {

    private double real;
    private double imag;

    public ComplexMutable () {
        this.real = 0.0D;
        this.imag = 0.0D;
    }

    public ComplexMutable (double real) {
        this.real = real;
        this.imag = 0.0D;

    }

    public ComplexMutable (double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexMutable (double abs, double rad, boolean PolarOrNot ) {
        if(PolarOrNot) {
            this.real = abs * Math.cos(rad);
            this.imag = abs * Math.sin(rad);
        } else {
            this.real = abs;
            this.imag = rad;
        }
    }

    public double real() {
        return real;
    }

    void setReal(double real) {
        this.real = real;
    }

    public double imag() {
        return imag;
    }

    void setImag(double imag) {
        this.imag = imag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexMutable that = (ComplexMutable) o;
        return Double.compare(that.real, real) == 0 &&
                Double.compare(that.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        return 13 * Objects.hash(real, imag);
    }

    @Override
    public String toString() {
        return String.format("(%." + getDecimalPlaces(real) + "f  %+." + getDecimalPlaces(imag) + "fi)", real, imag);
    }

    private long getDecimalPlaces(double num) {
        return String.valueOf(num).split("\\.")[1].length();

    }

}
