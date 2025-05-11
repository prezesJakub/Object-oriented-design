package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.CountingMazeBuilder;
import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) {
      //  test();
        playGame();
    }

    private static void test() {
        MazeGame mazeGame = new MazeGame();
        MazeBuilder builder = new StandardMazeBuilder();

        MazeFactory normalFactory = MazeFactory.getInstance();
        MazeFactory enchantedFactory = EnchantedMazeFactory.getInstance();
        MazeFactory bombedFactory = BombedMazeFactory.getInstance();

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

    private static void playGame() {
        StandardMazeBuilder builder = new StandardMazeBuilder();
        builder.startMaze();

        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildRoom(3);
        builder.buildBombedRoom(4);
        builder.buildDoor(1, 2, Direction.East);
        builder.buildDoor(2, 3, Direction.South);
        builder.buildDoor(3, 4, Direction.South);

        MazeGame game = new MazeGame();
        Maze maze = game.createMaze(builder);
        game.setMaze(maze);
        game.play();
    }
}