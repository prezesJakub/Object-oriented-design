package pl.edu.agh.internetshop.search;

import pl.edu.agh.internetshop.Order;

public class CustomerLastNameSearch implements SearchStrategy {
    private final String expectedLastName;

    public CustomerLastNameSearch(String expectedLastName) {
        this.expectedLastName = expectedLastName;
    }

    @Override
    public boolean matches(Order order) {
        return order.getCustomer() != null &&
                expectedLastName.equalsIgnoreCase(order.getCustomer().getLastName());
    }
}
