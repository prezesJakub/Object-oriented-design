package pl.edu.agh.internetshop.search;

import pl.edu.agh.internetshop.Order;

import java.math.BigDecimal;

public class PriceSearch implements SearchStrategy {
    private final BigDecimal expectedPrice;

    public PriceSearch(BigDecimal expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    @Override
    public boolean matches(Order order) {
        return order.getPrice().compareTo(expectedPrice) == 0;
    }
}
