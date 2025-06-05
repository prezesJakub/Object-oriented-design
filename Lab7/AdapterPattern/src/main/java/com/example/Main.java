package com.example;

public class Main {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);

        System.out.println(hole.fits(rpeg));

        SquarePeg smallSqPeg = new SquarePeg(5);
        SquarePeg largeSqPeg = new SquarePeg(10);


        SquarePegAdapter smallSqAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqAdapter = new SquarePegAdapter(largeSqPeg);

        System.out.println(hole.fits(smallSqAdapter));
        System.out.println(hole.fits(largeSqAdapter));
    }
}