package de.hawh.ld.complex;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lennart Draeger
 *
 * test class for ComplexImmutable
 * It tests for the correct implementation of hashCode, eqauls and toString
 */
public class ComplexImmutableTest {

    private Complex complex1 = new ComplexImmutable();
    private Complex complex2 = new ComplexImmutable(5);
    private Complex complex3 = new ComplexImmutable(5, 5);
    private Complex complex4 = new ComplexImmutable(0, 0 );
    private Complex complex5 = new ComplexImmutable(5,5, true);
    private Complex complex6 = new ComplexImmutable(5.0, 5.0);
    private Complex complex7 = new ComplexImmutable(0.0, 0.0);
    private Complex complex8 = new ComplexImmutable(5.126514651654654, 2.156516234541651);

    private Complex complex1_1 = new ComplexMutable();
    private Complex complex2_1 = new ComplexMutable(5);
    private Complex complex3_1 = new ComplexMutable(5, 5);
    private Complex complex4_1 = new ComplexMutable(0, 0 );
    private Complex complex5_1 = new ComplexMutable(5,5, true);
    private Complex complex6_1 = new ComplexMutable(5.0, 5.0);
    private Complex complex7_1 = new ComplexMutable(0.0, 0.0);


    @Test
    public void equals() {
        assertEquals(complex1, complex1); // reflexive
        assertEquals(complex1, complex4); // symmetrical & transitive
        assertEquals(complex4, complex1); // symmetrical
        assertEquals(complex4, complex7); // transitive
        assertEquals(complex1, complex7); // transitive
        assertNotEquals(complex1, complex1_1);
        assertNotEquals(complex2, complex2_1);
        assertNotEquals(complex3, complex3_1);
        assertNotEquals(complex4, complex4_1);
        assertNotEquals(complex5, complex5_1);
        assertNotEquals(complex6, complex6_1);
        assertNotEquals(complex7, complex7_1);
    }

    @Test
    public void testHashCode() {
        assertEquals(complex1.hashCode(), complex1.hashCode()); // reflexive
        assertEquals(complex1.hashCode(), complex4.hashCode()); // symmetrical & transitive
        assertEquals(complex4.hashCode(), complex1.hashCode()); // symmetrical
        assertEquals(complex4.hashCode(), complex7.hashCode()); // transitive
        assertEquals(complex1.hashCode(), complex7.hashCode()); // transitive
        assertNotEquals(complex1.hashCode(), complex1_1.hashCode());
        assertNotEquals(complex2.hashCode(), complex2_1.hashCode());
        assertNotEquals(complex3.hashCode(), complex3_1.hashCode());
        assertNotEquals(complex4.hashCode(), complex4_1.hashCode());
        assertNotEquals(complex5.hashCode(), complex5_1.hashCode());
        assertNotEquals(complex6.hashCode(), complex6_1.hashCode());
        assertNotEquals(complex7.hashCode(), complex7_1.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("(0,0 +0,0i)", complex1.toString());
        assertEquals("(0,0 +0,0i)", complex4.toString());
        assertEquals("(0,0 +0,0i)", complex7.toString());
        assertEquals("(5,0 +0,0i)", complex2.toString());
        assertEquals("(5,0 +5,0i)", complex3.toString());
        assertEquals("(5,0 +5,0i)", complex6.toString());
        assertEquals("(1,4183109273161312 -4,794621373315692i)", complex5.toString());
        assertEquals("(5,126514651654654 +2,156516234541651i)", complex8.toString());



    }
}
