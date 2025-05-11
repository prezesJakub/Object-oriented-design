package pl.agh.edu.dp.labirynth;

public class BombedMazeFactory extends MazeFactory {
    private static BombedMazeFactory instance;

    protected BombedMazeFactory() {
    }

    public static BombedMazeFactory getInstance() {
        if (instance == null) {
            instance = new BombedMazeFactory();
        }
        return instance;
    }

    @Override
    public Room makeRoom(int number) {
        BombedRoom room = new BombedRoom(number);
        room.setSide(Direction.South, makeWall());
        room.setSide(Direction.North, makeWall());
        room.setSide(Direction.East, makeWall());
        room.setSide(Direction.West, makeWall());
        return room;
    }

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }
}
