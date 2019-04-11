package de.hawh.ld.fractals;

import de.hawh.ld.complex.Complex;
import de.hawh.ld.complex.ComplexImmutable;
import org.junit.Test;
import java.util.ArrayList;


import static org.junit.Assert.*;

public class FractalsTest {

    Complex testZ = new ComplexImmutable(0.3,0.01);
    Complex testC = new ComplexImmutable(0.4,-0.325);
    ArrayList<Complex> testList = (Fractals.juliaSet(testZ, testC, 1000));

    @Test
    public void testSortList() {
        boolean j = false;
        ArrayList<Double> testListSorted = Fractals.sortList(testList);

        for(int i = 0; i < testListSorted.size(); i++)
            if (testListSorted.get(i) < testListSorted.get(++i)) {
                j = true;}
        assertTrue(j);
    }

}