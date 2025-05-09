package pl.agh.edu.dp.main;

import pl.agh.edu.dp.CountingMazeBuilder;
import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame();
        MazeBuilder builder = new StandardMazeBuilder();

        MazeFactory normalFactory = new MazeFactory();
        MazeFactory enchantedFactory = new EnchantedMazeFactory();
        MazeFactory bombedFactory = new BombedMazeFactory();

        Maze normalMaze = mazeGame.createMaze(normalFactory);
        Maze enchantedMaze = mazeGame.createMaze(enchantedFactory);
        Maze bombedMaze = mazeGame.createMaze(bombedFactory);

        Maze maze = mazeGame.createMaze(builder);

        System.out.println(maze.getRoomNumbers());

        System.out.println("Normal maze rooms: " + normalMaze.getRoomNumbers());
        System.out.println("Magic maze rooms: " + enchantedMaze.getRoomNumbers());
        System.out.println("Bombed maze rooms: " + bombedMaze.getRoomNumbers());

        CountingMazeBuilder countingBuilder = new CountingMazeBuilder();
        MazeGame game = new MazeGame();
        game.createMaze(countingBuilder);
        System.out.println(countingBuilder.getCounts());
    }
}



