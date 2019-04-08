package de.hawh.ld.fractals;


import de.hawh.ld.complex.Complex;
import de.hawh.ld.complex.ComplexImmutable;
import de.hawh.ld.complex.MathUtils;
import java.util.ArrayList;

import static java.util.Comparator.naturalOrder;


public class Fractals {

    public static void main(String... args) {
        // generate complex numbers
        Complex a = new ComplexImmutable(0.1,0.1);
        Complex z = new ComplexImmutable(0.3,0.01);
        Complex c = new ComplexImmutable(0.4,-0.325);

        // use Complex a for mandelbrotSet
        ArrayList<String> list1  = (Fractals.mandelbrotSet(a, 1000));
        // use Complex z and c for juliaSet
        ArrayList<String> list2  = (Fractals.juliaSet(z, c, 999));

        // write both to files
        FileIO.fileWriter(list1, "mandelbrotSet(0.1 +0.1i).txt");
        FileIO.fileWriter(list2, "juliaSet z = (0.3 +0.01i) c = (0.4 -0.325i).txt");

        // read mandelbrotSet from file
        ArrayList<String> mandel = FileIO.fileReader("mandelbrotSet(0.1 +0.1i).txt");
        // generate ArrayList of Complex object from the same set
        ArrayList<Complex> mandelObjs = new ArrayList<>(Fractals.generateSet(mandel));

        // read juliaSet from file
        ArrayList<String> julia = FileIO.fileReader("juliaSet z = (0.3 +0.01i) c = (0.4 -0.325i).txt");
        // generate ArrayList of Complex object from the same set
        ArrayList<Complex> juliaObjs = new ArrayList<>(Fractals.generateSet(julia));

        // print object and string lists
        System.out.println(mandel);
        System.out.println(mandelObjs);

        // print object and string lists
        System.out.println(julia);
        System.out.println(juliaObjs);

        System.out.println("-------------------------------------------------");

        ArrayList<String> sortedList = Fractals.sortList(juliaObjs);
        System.out.println(sortedList);
        FileIO.fileWriter(sortedList, "sortedJuliaList.txt");

    }


    private static ArrayList<String> mandelbrotSet(Complex num, int depth) {
        Complex z = new ComplexImmutable();

        return new ArrayList<>(Fractals.calcSet(z,num,depth));
    }


    private static ArrayList<String> juliaSet(Complex z, Complex c, int depth) {
        ArrayList<String> juliaSet = new ArrayList<>();
        juliaSet.add(z.toString());
        juliaSet.addAll(Fractals.calcSet(z,c,depth));

        return juliaSet;
    }

    private static ArrayList<String> calcSet(Complex z, Complex c, int depth) {
        ArrayList<String> set = new ArrayList<>();

        for(int i = 0; i < depth; i++) {
            z = MathUtils.add(MathUtils.powerOfTwo(z), c);
            set.add(z.toString());
        }

        return set;
    }

    private static ArrayList<String> sortList(ArrayList<Complex> list) {
        ArrayList<Double> absList = new ArrayList<>();
        ArrayList<String> absListString = new ArrayList<>();

        for(Complex obj: list) {
            absList.add(MathUtils.getAbs(obj));
        }
        absList.sort(naturalOrder());

        for(Double abs: absList) {
            absListString.add(Double.toString(abs));
        }

        return absListString;
    }

    private static ArrayList<Complex> generateSet(ArrayList<String> list ) {
        ArrayList<Complex> set = new ArrayList<>();

        for(String str: list) {
            String newStr = str.replaceAll(",",".");
            String[] parts = newStr.split(" ");
            String part1 = parts[0].replaceAll("\\(", "");
            String part2 = parts[1].replaceAll("[)i]", "");

            Double realP = Double.parseDouble(part1);
            Double imagP = Double.parseDouble(part2);
            Complex complex = new ComplexImmutable(realP, imagP);

            set.add(complex);
        }

        return set;
    }
}

