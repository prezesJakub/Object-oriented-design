package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.search.SearchStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHistory {
    private final List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public List<Order> search(SearchStrategy strategy) {
        return orders.stream()
                .filter(strategy::matches)
                .collect(Collectors.toList());
    }
}
