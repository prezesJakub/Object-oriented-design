package pl.agh.edu.dp.labirynth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StandardMazeBuilder extends MazeBuilder {
    private Maze currentMaze;
    private HashMap<Integer, Room> rooms = new HashMap<>();

    @Override
    public void startMaze() {
        this.currentMaze = new Maze(new ArrayList<>());
    }

    @Override
    public void buildRoom(int roomNumber) {
        if(currentMaze == null) return;
        Room room = new Room(roomNumber);
        currentMaze.addRoom(room);

        for(Direction dir : Direction.values()) {
            room.setSide(dir, new Wall());
        }
        rooms.put(roomNumber, room);
    }

    public void buildBombedRoom(int roomNumber) {
        if(currentMaze == null) return;
        BombedRoom room = new BombedRoom(roomNumber);
        currentMaze.addRoom(room);

        for(Direction dir : Direction.values()) {
            room.setSide(dir, new BombedWall());
        }
        rooms.put(roomNumber, room);
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Direction direction) {
        Room r1 = getRoom(roomFrom);
        Room r2 = getRoom(roomTo);
        if(r1 == null || r2 == null) return;

        if(!(r1.getSide(direction) instanceof Wall)) {
            throw new IllegalArgumentException("W tym miejscu istnieje już pokój " + roomFrom);
        }
        Direction oppositeDirection = opposite(direction);
        if(!(r2.getSide(oppositeDirection) instanceof Wall)) {
            throw new IllegalArgumentException("W tym miejscu istnieje już pokój " + roomTo);
        }

        Door door = new Door(r1, r2);

        r1.setSide(direction, door);
        r2.setSide(oppositeDirection, door);
    }

    @Override
    public Maze getMaze() {
        return currentMaze;
    }

    private Room getRoom(int roomNumber) {
        for(int i=0; i<currentMaze.getRoomNumbers(); i++) {
            Room r = currentMaze.getRooms().get(i);
            if(r.getRoomNumber() == roomNumber) {
                return r;
            }
        }
        return null;
    }

    private Direction opposite(Direction dir) {
        switch (dir) {
            case North: return Direction.South;
            case South: return Direction.North;
            case East: return Direction.West;
            case West: return Direction.East;
        }
        return null;
    }

    public Maze build() {
        return new Maze(new ArrayList<>(rooms.values()));
    }
}
