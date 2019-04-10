package de.hawh.ld.fractals;

import de.hawh.ld.complex.Complex;
import de.hawh.ld.complex.ComplexImmutable;
import de.hawh.ld.fractals.Fractals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

public class FractalsTest {

    Complex testZ = new ComplexImmutable(0.3,0.01);
    Complex testC = new ComplexImmutable(0.4,-0.325);
    ArrayList<Complex> testList = (Fractals.juliaSet(testZ, testC, 1000));


    @Test
    public void testSortList() {
        ArrayList<Double> lol = Fractals.sortList(testList);
        for(int i = 0; i < testList.size(); i++)
            (lol.get(i) > lol.get(++i));




    }

}