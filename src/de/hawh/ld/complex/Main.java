package de.hawh.ld.complex;

public class Main {

    public static void main(String[] args) {

        Complex complex = new ComplexImmutable(5.126514651654654, 2.156516234541651);
        System.out.println(complex.real());
        System.out.println(complex.imag());
        System.out.println(complex.toString());

    }
}
