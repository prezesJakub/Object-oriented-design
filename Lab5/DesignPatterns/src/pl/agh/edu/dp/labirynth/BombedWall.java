package pl.agh.edu.dp.labirynth;

public class BombedWall extends Wall {
    private boolean damaged;

    public BombedWall() {
        this.damaged = true;
    }

    public boolean isDamaged() {
        return damaged;
    }
}
