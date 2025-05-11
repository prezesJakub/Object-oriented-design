package pl.agh.edu.dp.labirynth;

public abstract class MazeBuilder {
    public void startMaze() {}
    public void buildRoom(int roomNumber) {}
    public void buildDoor(int roomFrom, int roomTo, Direction direction) {}
    public Maze build() {
        return null;
    }
    public Maze getMaze() {
        return null;
    }
}
