package pl.agh.edu.dp.labirynth;

public class BombedMazeFactory extends MazeFactory {
    @Override
    public Room makeRoom(int number) {
        return new BombedRoom(number);
    }

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }
}
