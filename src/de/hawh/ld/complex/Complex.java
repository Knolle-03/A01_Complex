package de.hawh.ld.complex;

import java.util.Objects;

final class Complex {

    private final double real;
    private final double imag;

    Complex () {
        this.real = 0.0D;
        this.imag = 0.0D;
    }

    Complex (double real) {
        this.real = real;
        this.imag = 0.0D;

    }

    Complex (double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    Complex (double abs, double rad, boolean PolarOrNot ) {
        if(PolarOrNot) {
            this.real = abs * Math.cos(rad);
            this.imag = abs * Math.sin(rad);
        } else {
            this.real = abs;
            this.imag = rad;
        }
    }

    double real() { return real; }

    double imag() { return imag; }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }

    @Override
    public String toString() {
        return String.format("(%f  %+fi)", real, imag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.real, real) == 0 &&
                Double.compare(complex.imag, imag) == 0;
    }

    /*private static int getDecimalPlaces(double num) {
        return String.valueOf(num).split("\\.")[1].length();
    }*/
}


