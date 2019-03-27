package de.hawh.ld.complex;

public class Main {

    public static void main(String[] args) {

        Complex lol = new Complex(-1, -1);
        Complex a = new Complex(-4 , 3);
        Complex b = new Complex(3.0 , 4.0);
        Complex c = new Complex(0,0);
        Complex d = new Complex(0,0);
        Complex e = new Complex(1.0,2.0);
        Complex f = new Complex(3.0,1.0);
        System.out.println(ComplexUtil.trigoPolarForm(a));
        System.out.println(ComplexUtil.expoPolarForm(a));
        System.out.println(ComplexUtil.getPhase(a));
        System.out.println(MathUtils.exponentialFunction(a));
        System.out.println(MathUtils.hyperbolicSine(a));
        System.out.println(MathUtils.hyperbolicCosine(a));
        System.out.println("sine:" + MathUtils.sine(a));
        System.out.println("cosine:" +  MathUtils.cosine(a));
        System.out.println("tangent:" + MathUtils.tangent(a));
        System.out.println("ln:" + MathUtils.logarithm(a));
    }
}
