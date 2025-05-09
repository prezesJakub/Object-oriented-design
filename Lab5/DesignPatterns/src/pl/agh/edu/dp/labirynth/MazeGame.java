package pl.agh.edu.dp.labirynth;

public class MazeGame {
    public Maze createMaze(MazeBuilder builder) {
        builder.startMaze();
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);
        return builder.getMaze();
    }

    public Maze createMaze(MazeFactory factory) {
        Maze maze = factory.makeMaze();

        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);
        factory.makeDoor(r1, r2, Direction.East);

        maze.addRoom(r1);
        maze.addRoom(r2);

        return maze;
    }
}
