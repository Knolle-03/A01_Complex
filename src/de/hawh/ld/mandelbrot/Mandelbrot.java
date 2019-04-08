package de.hawh.ld.mandelbrot;


import de.hawh.ld.complex.Complex;
import de.hawh.ld.complex.ComplexImmutable;
import de.hawh.ld.complex.MathUtils;

import java.util.ArrayList;


public class Mandelbrot {

    public static void main(String... args) {
        Complex b = new ComplexImmutable(0.1,0.1);
        Complex c = new ComplexImmutable(0.9,0.9);
        System.out.println(Mandelbrot.mandelbrotSet(b, 1));
        ArrayList<String> list =  (Mandelbrot.mandelbrotSet(c, 5));

        FileIO.fileWriter(list, "mandelbrotSet.txt");
    }


    private static ArrayList<String> mandelbrotSet(Complex num, int depth) {
        ArrayList<String> mandelbrotSet = new ArrayList<>();
        Complex z = new ComplexImmutable();

        for(int i = 0; i < depth; i++) {
            z = MathUtils.add(MathUtils.powerOfTwo(z), num);
            mandelbrotSet.add(z.toString());
        }
        return mandelbrotSet;
    }

    /*private static ArrayList<Complex> juliaSet(Complex num, int depth) {
        ArrayList<Complex> juliaSet = new ArrayList<>();


    }*/
}

