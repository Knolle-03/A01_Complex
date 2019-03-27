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
        Complex g = new Complex(5,2.49, true);
        System.out.println(MathUtils.add(b, c));
        System.out.println(MathUtils.sub(d, f));
        System.out.println(MathUtils.mul(e, lol));
        System.out.println(MathUtils.trigonometricPolarForm(a));
        System.out.println(MathUtils.expoPolarForm(a));
        System.out.println(MathUtils.exponentialFunction(a));
        System.out.println(MathUtils.hyperbolicSine(a));
        System.out.println(MathUtils.hyperbolicCosine(a));
        System.out.println(MathUtils.sine(a));
        System.out.println(MathUtils.cosine(a));
        System.out.println(MathUtils.tangent(a));
        System.out.println(MathUtils.hyperbolicTangent(a));
        System.out.println(MathUtils.logarithm(a));
        System.out.println(MathUtils.getPhase(a));
        System.out.println(MathUtils.getDegreeOfPhase(a));
    }
}
