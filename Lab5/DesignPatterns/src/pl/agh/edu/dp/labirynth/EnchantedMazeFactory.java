package pl.agh.edu.dp.labirynth;

public class EnchantedMazeFactory extends MazeFactory {
    @Override
    public Room makeRoom(int number) {
        return new EnchantedRoom(number);
    }

    @Override
    public Wall makeWall() {
        return new EnchantedWall();
    }
}
