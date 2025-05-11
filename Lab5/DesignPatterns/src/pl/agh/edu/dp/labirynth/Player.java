package pl.agh.edu.dp.labirynth;

public class Player {
    private Room currentRoom;
    private int health = 3;

    public Player() {
        this(null);
    }

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public void moveTo(Room newRoom) {
        this.currentRoom = newRoom;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
