package de.hawh.ld.complex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathUtilsTest {

    private double DELTA = 0.00005;
    private Complex complex1 = new ComplexImmutable(2.00000,-6.000000);
    private Complex complex2 = new ComplexImmutable(-4.0000,3.0000000);
    private Complex complex3 = new ComplexImmutable(3.94800,9.0000000);
    private Complex complex4 = new ComplexImmutable(7.03900,-5.349000);
    private Complex complex5 = new ComplexImmutable(500.000,398.00000);
    private Complex complex6 = new ComplexImmutable(13.3039,93.320294);
    private Complex complex7 = new ComplexImmutable();

    private Complex polarComplex1 = new ComplexImmutable(6.3246,5.0341, true);
    private Complex polarComplex2 = new ComplexImmutable(5.0000,2.4981, true);
    private Complex polarComplex3 = new ComplexImmutable(9.8279,1.1574, true);
    private Complex polarComplex4 = new ComplexImmutable(8.8408,5.6334, true);
    private Complex polarComplex5 = new ComplexImmutable(639.06,0.6723, true);
    private Complex polarComplex6 = new ComplexImmutable(94.264,1.4292, true);
    private Complex polarComplex7 = new ComplexImmutable(0.0000,0.0000, true);


    @Test
    public void add() {
        assertEquals(new ComplexImmutable(-2.00000, -3.0000000), MathUtils.add(complex1, complex2));
        assertEquals(new ComplexImmutable(10.98700, 3.65100000), MathUtils.add(complex3, complex4));
        assertEquals(new ComplexImmutable(513.3039, 491.320294), MathUtils.add(complex5, complex6));
    }

    @Test
    public void sub() {
        assertEquals(new ComplexImmutable(6.000000, -9.0000000), MathUtils.sub(complex1, complex2));
        assertEquals(new ComplexImmutable(-3.09100, 14.3490000), MathUtils.sub(complex3, complex4));
        assertEquals(new ComplexImmutable(486.6961, 304.679706), MathUtils.sub(complex5, complex6));
    }

    @Test
    public void mul() {
        assertEquals(new ComplexImmutable(10.0000000000, 30.0000000), MathUtils.mul(complex1, complex2));
        assertEquals(new ComplexImmutable(75.9309720000, 42.2331480), MathUtils.mul(complex3, complex4));
        assertEquals(new ComplexImmutable(-30489.527012, 51955.0992), MathUtils.mul(complex5, complex6));
    }

    @Test
    public void div() {
        assertEquals(new ComplexImmutable(-1.0400000000, 0.7200000000).real(), MathUtils.div(complex1, complex2).real(), DELTA);
        assertEquals(new ComplexImmutable(-1.0400000000, 0.7200000000).imag(), MathUtils.div(complex1, complex2).imag(), DELTA);
        assertEquals(new ComplexImmutable(-0.2603787684, 1.0807265190).real(), MathUtils.div(complex3, complex4).real(), DELTA);
        assertEquals(new ComplexImmutable(-0.2603787684, 1.0807265190).imag(), MathUtils.div(complex3, complex4).imag(), DELTA);
        assertEquals(new ComplexImmutable(4.92854471800, -4.655269666).real(), MathUtils.div(complex5, complex6).real(), DELTA);
        assertEquals(new ComplexImmutable(4.92854471800, -4.655269666).imag(), MathUtils.div(complex5, complex6).imag(), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZero() {
        MathUtils.div(complex1, complex7);
    }

    @Test
    public void getAbs() {
        assertEquals(6.324555320, MathUtils.getAbs(complex1), DELTA);
        assertEquals(5.000000000, MathUtils.getAbs(complex2), DELTA);
        assertEquals(9.827853479, MathUtils.getAbs(complex3), DELTA);
        assertEquals(8.840776097, MathUtils.getAbs(complex4), DELTA);
        assertEquals(639.0649419, MathUtils.getAbs(complex5), DELTA);
        assertEquals(94.26383733, MathUtils.getAbs(complex6), DELTA);
    }

    @Test
    public void getPhase() {
        assertEquals(5.03413953, MathUtils.getPhase(complex1), DELTA);
        assertEquals(2.49809154, MathUtils.getPhase(complex2), DELTA);
        assertEquals(1.15740707, MathUtils.getPhase(complex3), DELTA);
        assertEquals(5.63337249, MathUtils.getPhase(complex4), DELTA);
        assertEquals(0.67229715, MathUtils.getPhase(complex5), DELTA);
        assertEquals(1.42918882, MathUtils.getPhase(complex6), DELTA);
        assertEquals(0.00000000, MathUtils.getPhase(complex7), DELTA);
    }

    @Test
    public void getDegreeOfPhase() {
        assertEquals(288.434949, MathUtils.getDegreeOfPhase(complex1), DELTA);
        assertEquals(143.130102, MathUtils.getDegreeOfPhase(complex2), DELTA);
        assertEquals(66.3145403, MathUtils.getDegreeOfPhase(complex3), DELTA);
        assertEquals(322.768468, MathUtils.getDegreeOfPhase(complex4), DELTA);
        assertEquals(38.5197895, MathUtils.getDegreeOfPhase(complex5), DELTA);
        assertEquals(81.8864873, MathUtils.getDegreeOfPhase(complex6), DELTA);
        assertEquals(0.00000000, MathUtils.getDegreeOfPhase(complex7), DELTA);
    }

    @Test
    public void complexConjugate() {
        assertEquals(new ComplexImmutable(2.00000, 6.00000000), MathUtils.complexConjugate(complex1));
        assertEquals(new ComplexImmutable(-4.0000, -3.0000000), MathUtils.complexConjugate(complex2));
        assertEquals(new ComplexImmutable(3.94800, -9.0000000), MathUtils.complexConjugate(complex3));
        assertEquals(new ComplexImmutable(7.03900, 5.34900000), MathUtils.complexConjugate(complex4));
        assertEquals(new ComplexImmutable(500.000, -398.00000), MathUtils.complexConjugate(complex5));
        assertEquals(new ComplexImmutable(13.3039, -93.320294), MathUtils.complexConjugate(complex6));
        assertEquals(new ComplexImmutable(0.00000, 0.00000000), MathUtils.complexConjugate(complex7));
    }

    @Test
    public void polarEqualsCartesian() {
        double delta = 0.05;
        assertEquals(complex1.real(), polarComplex1.real(), delta);
        assertEquals(complex1.imag(), polarComplex1.imag(), delta);
        assertEquals(complex2.real(), polarComplex2.real(), delta);
        assertEquals(complex2.imag(), polarComplex2.imag(), delta);
        assertEquals(complex3.real(), polarComplex3.real(), delta);
        assertEquals(complex3.imag(), polarComplex3.imag(), delta);
        assertEquals(complex4.real(), polarComplex4.real(), delta);
        assertEquals(complex4.imag(), polarComplex4.imag(), delta);
        assertEquals(complex5.real(), polarComplex5.real(), delta);
        assertEquals(complex5.imag(), polarComplex5.imag(), delta);
        assertEquals(complex6.real(), polarComplex6.real(), delta);
        assertEquals(complex6.imag(), polarComplex6.imag(), delta);
        assertEquals(complex7.real(), polarComplex7.real(), delta);
        assertEquals(complex7.imag(), polarComplex7.imag(), delta);
    }

    @Test
    public void exponentialFunction() {
        assertEquals(7.09475211300000000000, MathUtils.exponentialFunction(complex1).real(), DELTA);
        assertEquals(2.06461679100000000000, MathUtils.exponentialFunction(complex1).imag(), DELTA);
        assertEquals(-0.0181323400000000000, MathUtils.exponentialFunction(complex2).real(), DELTA);
        assertEquals(0.00258470300000000000, MathUtils.exponentialFunction(complex2).imag(), DELTA);
        assertEquals(-47.225339100000000000, MathUtils.exponentialFunction(complex3).real(), DELTA);
        assertEquals(21.3607604400000000000, MathUtils.exponentialFunction(complex3).imag(), DELTA);
        assertEquals(677.846762400000000000, MathUtils.exponentialFunction(complex4).real(), DELTA);
        assertEquals(916.889583100000000000, MathUtils.exponentialFunction(complex4).imag(), DELTA);
        assertEquals(-7.791879023921824E216, MathUtils.exponentialFunction(complex5).real(), DELTA);
        assertEquals(1.1674490681749730E217, MathUtils.exponentialFunction(complex5).imag(), DELTA);
        assertEquals(359626.212694931140000, MathUtils.exponentialFunction(complex6).real(), DELTA);
        assertEquals(-479691.85723286220000, MathUtils.exponentialFunction(complex6).imag(), DELTA);
        assertEquals(1.00000000000000000000, MathUtils.exponentialFunction(complex7).real(), DELTA);
        assertEquals(0.00000000000000000000, MathUtils.exponentialFunction(complex7).imag(), DELTA);
    }

    @Test
    public void logarithm() {
        assertEquals(1.8444397270569681, MathUtils.logarithm(complex1).real(), DELTA);
        assertEquals(-1.249045772398254, MathUtils.logarithm(complex1).imag(), DELTA);
        assertEquals(1.6094379124341003, MathUtils.logarithm(complex2).real(), DELTA);
        assertEquals(2.4980915447965090, MathUtils.logarithm(complex2).imag(), DELTA);
        assertEquals(2.2852205459968498, MathUtils.logarithm(complex3).real(), DELTA);
        assertEquals(1.1574070698770198, MathUtils.logarithm(complex3).imag(), DELTA);
        assertEquals(2.1793746665915430, MathUtils.logarithm(complex4).real(), DELTA);
        assertEquals(-0.649812813770130, MathUtils.logarithm(complex4).imag(), DELTA);
        assertEquals(6.4600060797719890, MathUtils.logarithm(complex5).real(), DELTA);
        assertEquals(0.6722971543220387, MathUtils.logarithm(complex5).imag(), DELTA);
        assertEquals(4.5460976306837120, MathUtils.logarithm(complex6).real(), DELTA);
        assertEquals(1.4291888156082426, MathUtils.logarithm(complex6).imag(), DELTA);
        assertEquals(Double.NEGATIVE_INFINITY, MathUtils.logarithm(complex7).real(), DELTA);
        assertEquals(Double.NEGATIVE_INFINITY, MathUtils.logarithm(complex7).real(), DELTA);

    }

    @Test
    public void sine() {
        assertEquals(183.4195088766546700000, MathUtils.sine(complex1).real(), DELTA);
        assertEquals(83.94229232957760000000, MathUtils.sine(complex1).imag(), DELTA);
        assertEquals(7.619231720321410000000, MathUtils.sine(complex2).real(), DELTA);
        assertEquals(-6.54812004091100250000, MathUtils.sine(complex2).imag(), DELTA);
        assertEquals(-2924.42481686705600000, MathUtils.sine(complex3).real(), DELTA);
        assertEquals(-2804.05631110142300000, MathUtils.sine(complex3).imag(), DELTA);
        assertEquals(72.15563474637752000000, MathUtils.sine(complex4).real(), DELTA);
        assertEquals(-76.5528760527054100000, MathUtils.sine(complex4).imag(), DELTA);
        assertEquals(-1.6527525779449942E172, MathUtils.sine(complex5).real(), DELTA);
        assertEquals(-3.1228563768858170E172, MathUtils.sine(complex5).imag(), DELTA);
        assertEquals(1.135340390832008500E40, MathUtils.sine(complex6).real(), DELTA);
        assertEquals(1.249591441733440600E40, MathUtils.sine(complex6).imag(), DELTA);
        assertEquals(0.000000000000000000000, MathUtils.sine(complex7).real(), DELTA);
        assertEquals(0.000000000000000000000, MathUtils.sine(complex7).imag(), DELTA);

    }

    @Test
    public void cosine() {
        assertEquals(-83.943323854454500000, MathUtils.cosine(complex1).real(), DELTA);
        assertEquals(183.417254953678680000, MathUtils.cosine(complex1).imag(), DELTA);
        assertEquals(-6.5806630405511570000, MathUtils.cosine(complex2).real(), DELTA);
        assertEquals(-7.5815527427465450000, MathUtils.cosine(complex2).imag(), DELTA);
        assertEquals(-2804.0563965128663000, MathUtils.cosine(complex3).real(), DELTA);
        assertEquals(2924.42472778919550000, MathUtils.cosine(complex3).imag(), DELTA);
        assertEquals(76.5563348009416300000, MathUtils.cosine(complex4).real(), DELTA);
        assertEquals(72.1523748179201000000, MathUtils.cosine(complex4).imag(), DELTA);
        assertEquals(-3.122856376885817E172, MathUtils.cosine(complex5).real(), DELTA);
        assertEquals(1.6527525779449942E172, MathUtils.cosine(complex5).imag(), DELTA);
        assertEquals(1.24959144173344060E40, MathUtils.cosine(complex6).real(), DELTA);
        assertEquals(-1.1353403908320085E40, MathUtils.cosine(complex6).imag(), DELTA);
        assertEquals(1.00000000000000000000, MathUtils.cosine(complex7).real(), DELTA);
        assertEquals(0.00000000000000000000, MathUtils.cosine(complex7).imag(), DELTA);
    }

    @Test
    public void tangent() {
        assertEquals(-0.000009299985180859964, MathUtils.tangent(complex1).real(), DELTA);
        assertEquals(-1.000008032239434000000, MathUtils.tangent(complex1).imag(), DELTA);
        assertEquals(-0.004908258067496060000, MathUtils.tangent(complex2).real(), DELTA);
        assertEquals(1.0007095360672330000000, MathUtils.tangent(complex2).imag(), DELTA);
        assertEquals(3.0433074298900100000E-8, MathUtils.tangent(complex3).real(), DELTA);
        assertEquals(1.0000000012795007000000, MathUtils.tangent(complex3).imag(), DELTA);
        assertEquals(0.0000451009666938016100, MathUtils.tangent(complex4).real(), DELTA);
        assertEquals(-0.999997327374890600000, MathUtils.tangent(complex4).imag(), DELTA);
        assertEquals(0.0000000000000000000000, MathUtils.tangent(complex5).real(), DELTA);
        assertEquals(Double.NaN, MathUtils.tangent(complex5).imag(), DELTA);
        assertEquals(1.746060059812855400E-81, MathUtils.tangent(complex6).real(), DELTA);
        assertEquals(1.0000000000000000000000, MathUtils.tangent(complex6).imag(), DELTA);
        assertEquals(0.0000000000000000000000, MathUtils.tangent(complex7).real(), DELTA);
        assertEquals(0.0000000000000000000000, MathUtils.tangent(complex7).imag(), DELTA);
    }

    @Test
    public void hyperbolicSine() {
        assertEquals(3.48240359744333600000, MathUtils.hyperbolicSine(complex1).real(), DELTA);
        assertEquals(1.05121578334598520000, MathUtils.hyperbolicSine(complex1).imag(), DELTA);
        assertEquals(27.0168132580039360000, MathUtils.hyperbolicSine(complex2).real(), DELTA);
        assertEquals(3.85373803791937770000, MathUtils.hyperbolicSine(complex2).imag(), DELTA);
        assertEquals(-23.603880264784355000, MathUtils.hyperbolicSine(complex3).real(), DELTA);
        assertEquals(10.6843557721989950000, MathUtils.hyperbolicSine(complex3).imag(), DELTA);
        assertEquals(338.923120554308350000, MathUtils.hyperbolicSine(complex4).real(), DELTA);
        assertEquals(458.445144167729000000, MathUtils.hyperbolicSine(complex4).imag(), DELTA);
        assertEquals(-3.895939511961015E216, MathUtils.hyperbolicSine(complex5).real(), DELTA);
        assertEquals(5.8372453408750190E216, MathUtils.hyperbolicSine(complex5).imag(), DELTA);
        assertEquals(179813.106346965420000, MathUtils.hyperbolicSine(complex6).real(), DELTA);
        assertEquals(-239845.92861709860000, MathUtils.hyperbolicSine(complex6).imag(), DELTA);
        assertEquals(0.00000000000000000000, MathUtils.hyperbolicSine(complex7).real(), DELTA);
        assertEquals(0.00000000000000000000, MathUtils.hyperbolicSine(complex7).imag(), DELTA);
    }

    @Test
    public void hyperbolicCosine() {
        assertEquals(3.61234851514254230000, MathUtils.hyperbolicCosine(complex1).real(), DELTA);
        assertEquals(1.01340100775653430000, MathUtils.hyperbolicCosine(complex1).imag(), DELTA);
        assertEquals(-27.034945603074227000, MathUtils.hyperbolicCosine(complex2).real(), DELTA);
        assertEquals(-3.8511533348117784000, MathUtils.hyperbolicCosine(complex2).imag(), DELTA);
        assertEquals(-23.621458928448906000, MathUtils.hyperbolicCosine(complex3).real(), DELTA);
        assertEquals(10.6764046673514600000, MathUtils.hyperbolicCosine(complex3).imag(), DELTA);
        assertEquals(338.923641909628770000, MathUtils.hyperbolicCosine(complex4).real(), DELTA);
        assertEquals(458.444438956331800000, MathUtils.hyperbolicCosine(complex4).imag(), DELTA);
        assertEquals(-3.895939511961015E216, MathUtils.hyperbolicCosine(complex5).real(), DELTA);
        assertEquals(5.8372453408750190E216, MathUtils.hyperbolicCosine(complex5).imag(), DELTA);
        assertEquals(179813.106347965950000, MathUtils.hyperbolicCosine(complex6).real(), DELTA);
        assertEquals(-239845.92861576402000, MathUtils.hyperbolicCosine(complex6).imag(), DELTA);
        assertEquals(1.00000000000000000000, MathUtils.hyperbolicCosine(complex7).real(), DELTA);
        assertEquals(0.00000000000000000000, MathUtils.hyperbolicCosine(complex7).imag(), DELTA);
    }

    @Test
    public void hyperbolicTangent() {
        assertEquals(0.96937457589175800000, MathUtils.hyperbolicTangent(complex1).real(), DELTA);
        assertEquals(0.01905979197607893000, MathUtils.hyperbolicTangent(complex1).imag(), DELTA);
        assertEquals(-0.9993559873814731000, MathUtils.hyperbolicTangent(complex2).real(), DELTA);
        assertEquals(-0.0001873462046294784, MathUtils.hyperbolicTangent(complex2).imag(), DELTA);
        assertEquals(0.99950838592967120000, MathUtils.hyperbolicTangent(complex3).real(), DELTA);
        assertEquals(-0.0005588044177336471, MathUtils.hyperbolicTangent(complex3).imag(), DELTA);
        assertEquals(1.00000045102250930000, MathUtils.hyperbolicTangent(complex4).real(), DELTA);
        assertEquals(0.00000147066351907421, MathUtils.hyperbolicTangent(complex4).imag(), DELTA);
        assertEquals(1.00000000000000000000, MathUtils.hyperbolicTangent(complex5).real(), DELTA);
        assertEquals(0.00000000000000000000, MathUtils.hyperbolicTangent(complex5).imag(), DELTA);
        assertEquals(1.00000000000156000000, MathUtils.hyperbolicTangent(complex6).real(), DELTA);
        assertEquals(-5.341114579485656E-12, MathUtils.hyperbolicTangent(complex6).imag(), DELTA);
        assertEquals(0.00000000000000000000, MathUtils.hyperbolicTangent(complex7).real(), DELTA);
        assertEquals(0.00000000000000000000, MathUtils.hyperbolicTangent(complex7).imag(), DELTA);
    }

}
