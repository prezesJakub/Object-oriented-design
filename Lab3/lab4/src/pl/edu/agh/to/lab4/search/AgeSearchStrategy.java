package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.suspect.Suspect;

public class AgeSearchStrategy implements SearchStrategy {
    private final int minAge;

    public AgeSearchStrategy(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getAge() >= minAge;
    }
}
