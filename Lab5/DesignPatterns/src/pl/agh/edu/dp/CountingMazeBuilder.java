package pl.agh.edu.dp;

import pl.agh.edu.dp.labirynth.MazeBuilder;

public class CountingMazeBuilder extends MazeBuilder {
    private int rooms = 0;
    private int doors = 0;

    @Override
    public void buildRoom(int roomNumber) {
        rooms++;
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo) {
        doors++;
    }

    public String getCounts() {
        return "Rooms: " + rooms + ", Doors: " + doors;
    }
}
