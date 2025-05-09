package pl.agh.edu.dp.labirynth;

public class EnchantedMazeFactory extends MazeFactory {
    private static EnchantedMazeFactory instance;

    private EnchantedMazeFactory() {
    }

    public static EnchantedMazeFactory getInstance() {
        if (instance == null) {
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }

    @Override
    public Room makeRoom(int number) {
        EnchantedRoom room = new EnchantedRoom(number);
        room.setSide(Direction.South, makeWall());
        room.setSide(Direction.North, makeWall());
        room.setSide(Direction.East, makeWall());
        room.setSide(Direction.West, makeWall());
        return room;
    }

    @Override
    public Wall makeWall() {
        return new EnchantedWall();
    }
}
