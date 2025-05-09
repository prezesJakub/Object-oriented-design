package pl.agh.edu.dp.main;

import pl.agh.edu.dp.CountingMazeBuilder;
import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame();
        MazeBuilder builder = new StandardMazeBuilder();

        Maze maze = mazeGame.createMaze(builder);

        System.out.println(maze.getRoomNumbers());

        CountingMazeBuilder countingBuilder = new CountingMazeBuilder();
        MazeGame game = new MazeGame();
        game.createMaze(countingBuilder);
        System.out.println(countingBuilder.getCounts());
    }
}



