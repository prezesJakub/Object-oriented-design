package pl.agh.edu.dp.labirynth;

public class MazeFactory {
    private static MazeFactory instance;

    protected MazeFactory() {
    }

    public static MazeFactory getInstance() {
        if (instance == null) {
            instance = new MazeFactory();
        }
        return instance;
    }

    public Maze makeMaze() {
        return new Maze();
    }

    public Room makeRoom(int number) {
        Room room = new Room(number);
        room.setSide(Direction.South, makeWall());
        room.setSide(Direction.North, makeWall());
        room.setSide(Direction.East, makeWall());
        room.setSide(Direction.West, makeWall());
        return room;
    }

    public Wall makeWall() {
        return new Wall();
    }

    public Door makeDoor(Room r1, Room r2, Direction direction) {
        Door newDoor = new Door(r1, r2);
        r1.setSide(direction, newDoor);
        r2.setSide(direction.opposite(), newDoor);
        return newDoor;
    }
}
