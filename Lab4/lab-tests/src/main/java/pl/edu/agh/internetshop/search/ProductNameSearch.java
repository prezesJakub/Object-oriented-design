package pl.edu.agh.internetshop.search;

import pl.edu.agh.internetshop.Order;

public class ProductNameSearch implements SearchStrategy {
    private final String productName;

    public ProductNameSearch(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean matches(Order order) {
        return order.getProducts().stream()
                .anyMatch(p -> productName.equalsIgnoreCase(p.getName()));
    }
}
