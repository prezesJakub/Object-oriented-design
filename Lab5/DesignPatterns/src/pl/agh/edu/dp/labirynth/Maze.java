package pl.agh.edu.dp.labirynth;

import java.util.List;
import java.util.Vector;

public class Maze {
    private List<Room> rooms;

    public Maze(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers() {
        return rooms.size();
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
