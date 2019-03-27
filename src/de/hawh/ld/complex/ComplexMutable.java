package de.hawh.ld.complex;

import java.util.Objects;

public class ComplexMutable {

    private double real;
    private double imag;

    ComplexMutable () {
        this.real = 0.0D;
        this.imag = 0.0D;
    }

    ComplexMutable (double real) {
        this.real = real;
        this.imag = 0.0D;

    }

    ComplexMutable (double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    ComplexMutable (double abs, double rad, boolean PolarOrNot ) {
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

    public void setReal(double real) {
        this.real = real;
    }

    public double imag() {
        return imag;
    }

    public void setImag(double imag) {
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
        return Objects.hash(real, imag);
    }

    @Override
    public String toString() {
        return String.format("(%f  %+fi)", real, imag);
    }


    /*private static int getDecimalPlaces(double num) {
        return String.valueOf(num).split("\\.")[1].length();
    }*/
}
