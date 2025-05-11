package pl.agh.edu.dp.labirynth;

public class CountingMazeBuilder extends MazeBuilder {
    private int rooms = 0;
    private int doors = 0;

    @Override
    public void buildRoom(int roomNumber) {
        rooms++;
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Direction direction) {
        doors++;
    }

    public String getCounts() {
        return "Rooms: " + rooms + ", Doors: " + doors;
    }
}
