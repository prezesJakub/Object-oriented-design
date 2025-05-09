package pl.agh.edu.dp.labirynth;

public class StandardMazeBuilder extends MazeBuilder {
    private Maze currentMaze;

    @Override
    public void startMaze() {
        this.currentMaze = new Maze();
    }

    @Override
    public void buildRoom(int roomNumber) {
        if(currentMaze == null) return;
        Room room = new Room(roomNumber);
        currentMaze.addRoom(room);

        for(Direction dir : Direction.values()) {
            room.setSide(dir, new Wall());
        }
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo) {
        Room r1 = getRoom(roomFrom);
        Room r2 = getRoom(roomTo);
        if(r1 == null || r2 == null) return;

        Door door = new Door(r1, r2);
        Direction dirFromTo = commonWall(r1, r2);
        Direction dirToFrom = opposite(dirFromTo);

        r1.setSide(dirFromTo, door);
        r2.setSide(dirToFrom, door);
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

    private Direction commonWall(Room r1, Room r2) {
        if(r1.getRoomNumber() < r2.getRoomNumber()) {
            return Direction.East;
        } else {
            return Direction.West;
        }
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
}
