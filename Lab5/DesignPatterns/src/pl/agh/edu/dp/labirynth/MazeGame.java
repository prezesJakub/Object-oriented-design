package pl.agh.edu.dp.labirynth;

public class MazeGame {
    public Maze createMaze(MazeBuilder builder) {
        builder.startMaze();
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);
        return builder.getMaze();
    }
}
