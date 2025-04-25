package pl.edu.agh.internetshop.search;

import pl.edu.agh.internetshop.Order;

import java.util.List;

public class CombinedSearch implements SearchStrategy {
    private final List<SearchStrategy> strategies;

    public CombinedSearch(List<SearchStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean matches(Order order) {
        return strategies.stream().allMatch(strategy -> strategy.matches(order));
    }
}
