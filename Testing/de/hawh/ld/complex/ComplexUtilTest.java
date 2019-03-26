package de.hawh.ld.complex;
//lol
import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexUtilTest {

    private double DELTA = 0.00009;
    private Complex complex1 = new Complex(2,-6);
    private Complex complex2 = new Complex(-4,3);
    private Complex complex3 = new Complex(3.948,9);
    private Complex complex4 = new Complex(7.039,-5.349);
    private Complex complex5 = new Complex(500,398);
    private Complex complex6 = new Complex(13.3039,93.320294);
    private Complex complex7 = new Complex();


    @Test
    public void add() {
        assertEquals(new Complex(-2, -3 ), ComplexUtil.add(complex1, complex2));
        assertEquals(new Complex(10.987, 3.651 ), ComplexUtil.add(complex3, complex4));
        assertEquals(new Complex(513.3039, 491.320294 ), ComplexUtil.add(complex5, complex6));
    }

    @Test
    public void sub() {
        assertEquals(new Complex(6, -9 ), ComplexUtil.sub(complex1, complex2));
        assertEquals(new Complex(-3.091, 14.349 ), ComplexUtil.sub(complex3, complex4));
        assertEquals(new Complex(486.6961, 304.679706), ComplexUtil.sub(complex5, complex6));
    }

    @Test
    public void mul() {
        assertEquals(new Complex(10, 30 ), ComplexUtil.mul(complex1, complex2));
        assertEquals(new Complex(75.930972, 42.233148 ), ComplexUtil.mul(complex3, complex4));
        assertEquals(new Complex(-30489.527012, 51955.0992), ComplexUtil.mul(complex5, complex6));
    }

    @Test
    public void div() {

        assertEquals(new Complex(-1.04, 0.72 ), ComplexUtil.div(complex1, complex2));
        assertEquals(new Complex(-0.2603787684, 1.080726519).real(), ComplexUtil.div(complex3, complex4).real(), DELTA);
        assertEquals(new Complex(-0.2603787684, 1.080726519).imag(), ComplexUtil.div(complex3, complex4).imag(), DELTA);
        assertEquals(new Complex(4.928544718, -4.655269666).real(), ComplexUtil.div(complex5, complex6).real(), DELTA);
        assertEquals(new Complex(4.928544718, -4.655269666).imag(), ComplexUtil.div(complex5, complex6).imag(), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
        ComplexUtil.div(complex1, complex7);
    }

    @Test
    public void getAbs() {
        assertEquals(6.32455532, ComplexUtil.getAbs(complex1), DELTA);
        assertEquals(5, ComplexUtil.getAbs(complex2), DELTA);
        assertEquals(9.827853479, ComplexUtil.getAbs(complex3), DELTA);
        assertEquals(8.840776097, ComplexUtil.getAbs(complex4), DELTA);
        assertEquals(639.0649419, ComplexUtil.getAbs(complex5), DELTA);
        assertEquals(94.26383733, ComplexUtil.getAbs(complex6), DELTA);
    }

    @Test
    public void radiantAngle() {
    }

    @Test
    public void degreeAngle() {
    }

    @Test
    public void exponent() {
    }

    @Test
    public void polarForm() {
    }

    @Test
    public void complexConjugate() {
        assertEquals(new Complex(2, 6 ), ComplexUtil.complexConjugate(complex1));
        assertEquals(new Complex(-4, -3 ), ComplexUtil.complexConjugate(complex2));
        assertEquals(new Complex(3.948, -9), ComplexUtil.complexConjugate(complex3));
        assertEquals(new Complex(7.039, 5.349 ), ComplexUtil.complexConjugate(complex4));
        assertEquals(new Complex(500, -398 ), ComplexUtil.complexConjugate(complex5));
        assertEquals(new Complex(13.3039,-93.320294), ComplexUtil.complexConjugate(complex6));
        assertEquals(new Complex(0,0), ComplexUtil.complexConjugate(complex7));
    }
}