package de.hawh.ld.complex;

public class Main {

    public static void main(String[] args) {

        Complex lol = new Complex(-1, -1);
        Complex a = new Complex(5.0 , 2.3240);
        Complex b = new Complex(3.0 , 4.0);
        Complex c = new Complex(0,0);
        Complex d = new Complex(0,0);
        Complex e = new Complex(1.0,2.0);
        Complex f = new Complex(3.0,1.0);
        System.out.println(ComplexUtil.trigoPolarForm(a));
        System.out.println(ComplexUtil.expoPolarForm(a));
    }
}
