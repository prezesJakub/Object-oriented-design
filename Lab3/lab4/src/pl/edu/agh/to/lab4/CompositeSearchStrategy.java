package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy {
    private final List<SearchStrategy> strategies = new ArrayList<>();

    public void addStrategy(SearchStrategy strategy) {
        strategies.add(strategy);
    }

    @Override
    public boolean filter(Suspect suspect) {
        for (SearchStrategy strategy : strategies) {
            if (!strategy.filter(suspect)) {
                return false;
            }
        }
        return true;
    }
}
