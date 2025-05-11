package pl.agh.edu.dp.labirynth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeGame {
    private Player player;
    private Maze maze;

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public Maze createMaze(MazeBuilder builder) {
        maze = builder.build();
        return maze;
    }

    public Maze createMaze(MazeFactory factory) {
        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);
        factory.makeDoor(r1, r2, Direction.East);

        List<Room> rooms = new ArrayList<>(Arrays.asList(r1, r2));
        maze = new Maze(rooms);

        return maze;
    }

    public void play() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        player = new Player(maze.getRooms().get(0));

        System.out.println("Witaj w labiryncie!");
        System.out.println("Twoje zdrowie: " + player.getHealth());
        System.out.println();

        while(player.isAlive()) {
            Direction moveDirection = null;
            while(moveDirection == null) {
                System.out.print("Wybierz kierunek: ");
                try {
                    moveDirection = DirectionParser.parse(consoleReader.readLine());
                } catch (IOException e) {
                    System.out.println("IOException: " + e.getMessage());
                }
                if(moveDirection == null) {
                    System.out.println("Użyj jednego z kierunków: 'N', 'S', 'E', 'W'.");
                }
            }

            MapSite siteAtDirection = player.getCurrentRoom().getSide(moveDirection);
            if(siteAtDirection instanceof Wall) {
                System.out.println("Nie możesz się ruszyć w tym kierunku");
            }
            if(siteAtDirection instanceof BombedWall) {
                System.out.println("Wszedłeś w bombę");
                player.decreaseHealth(1);
                if(!player.isAlive()) {
                    break;
                }
            }
            if(siteAtDirection instanceof Door) {
                Room newRoom = ((Door) siteAtDirection).getAnotherRoom(player.getCurrentRoom());
                player.moveTo(newRoom);
                System.out.println("Przemieściłeś się do sąsiedniego pokoju");

                if(newRoom instanceof BombedRoom) {
                    System.out.println("Wszedłeś do bombowego pokoju");
                    player.decreaseHealth(1);
                    if(!player.isAlive()) {
                        break;
                    }
                }
            }
            System.out.println();
        }
        System.out.println("Koniec gry");
    }
}
