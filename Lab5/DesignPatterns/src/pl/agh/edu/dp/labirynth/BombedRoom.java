package pl.agh.edu.dp.labirynth;

public class BombedRoom extends Room {
    private boolean hasBomb;

    public BombedRoom(int number) {
        super(number);
        this.hasBomb = true;
    }

    public boolean hasBomb() {
        return hasBomb;
    }
}
