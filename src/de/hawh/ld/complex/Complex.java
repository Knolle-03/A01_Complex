package de.hawh.ld.complex;

import java.util.Objects;

class Complex {

    private double real;
    private double imag;

    Complex () {
        this.real = 0.0D;
        this.imag = 0.0D;
    }

    Complex (double real, double imag) {
        this.real = real;
        this.imag = imag;
    }



    double real() { return real; }

    double imag() { return imag; }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }

    @Override
    public String toString() {
        return String.format("(%."+ getDecimalPlaces(real) + "f  %+." + getDecimalPlaces(imag) + "f)",real, imag);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.real, real) == 0 &&
                Double.compare(complex.imag, imag) == 0;
    }
/*@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Complex other = (Complex)obj;
            if (Double.doubleToLongBits(this.imag) != Double.doubleToLongBits(other.imag)) {
                return false;
            } else {
                return Double.doubleToLongBits(this.real) == Double.doubleToLongBits(other.real);
            }
        }
    }*/

    private static int getDecimalPlaces(double num) {
        return String.valueOf(num).split("\\.")[1].length();
    }
}


