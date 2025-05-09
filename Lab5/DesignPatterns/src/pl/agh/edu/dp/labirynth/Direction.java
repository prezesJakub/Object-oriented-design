package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public Direction opposite() {
        return switch(this) {
            case North -> South;
            case East -> West;
            case South -> North;
            case West -> East;
        };
    }
}