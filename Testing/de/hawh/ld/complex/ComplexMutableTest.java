package de.hawh.ld.complex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ComplexMutableTest {


    private Complex complex1 = new ComplexMutable();
    private Complex complex2 = new ComplexMutable(5);
    private Complex complex3 = new ComplexMutable(5, 5);
    private Complex complex4 = new ComplexMutable(0, 0 );
    private Complex complex5 = new ComplexMutable(5,5, true);
    private Complex complex6 = new ComplexMutable(5.0, 5.0);
    private Complex complex7 = new ComplexMutable(0.0, 0.0);
    private Complex complex8 = new ComplexMutable(5.1651654654, 2.156516541651);

    @Test
    public void equals() {
        assertEquals(complex1, complex1); // reflexive
        assertEquals(complex1, complex4); // symmetrical & transitive
        assertEquals(complex4, complex1); // symmetrical
        assertEquals(complex4, complex7); // transitive
        assertEquals(complex1, complex7); // transitive
        assertNotEquals(complex5, complex3);
    }

    @Test
    public void testHashCode() {
        assertEquals(complex1.hashCode(), complex1.hashCode()); // reflexive
        assertEquals(complex1.hashCode(), complex4.hashCode()); // symmetrical & transitive
        assertEquals(complex4.hashCode(), complex1.hashCode()); // symmetrical
        assertEquals(complex4.hashCode(), complex7.hashCode()); // transitive
        assertEquals(complex1.hashCode(), complex7.hashCode()); // transitive
    }

    @Test
    public void testToString() {
        assertEquals("(0,000000  +0,000000i)", complex1.toString());
        assertEquals("(0,000000  +0,000000i)", complex4.toString());
        assertEquals("(0,000000  +0,000000i)", complex7.toString());
        assertEquals("(5,000000  +0,000000i)", complex2.toString());
        assertEquals("(5,000000  +5,000000i)", complex3.toString());
        assertEquals("(1,418311  -4,794621i)", complex5.toString());
        assertEquals("(5,000000  +5,000000i)", complex6.toString());
        assertEquals("(5161651,165165  +2,156517i)", complex8.toString());

    }


}
