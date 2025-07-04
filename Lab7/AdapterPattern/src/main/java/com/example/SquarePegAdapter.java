package com.example;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        super(0);
        this.peg = peg;
    }

    @Override
    public int getRadius() {
        return (int)(peg.getWidth() * Math.sqrt(2) / 2);
    }
}
