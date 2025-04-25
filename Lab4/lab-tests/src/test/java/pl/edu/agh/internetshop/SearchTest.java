package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.search.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchTest {

    @Test
    public void testProductNameSearchShouldMatch() {
        //given
        Product product = mock(Product.class);
        when(product.getName()).thenReturn("Laptop");

        Order order = new Order(product);

        SearchStrategy strategy = new ProductNameSearch("Laptop");

        //when
        boolean result = strategy.matches(order);

        //then
        assertTrue(result);
    }

    @Test
    public void testProductNameSearchShouldNotMatch() {
        Product product = mock(Product.class);
        when(product.getName()).thenReturn("Mouse");

        Order order = new Order(product);

        SearchStrategy strategy = new ProductNameSearch("Keyboard");

        assertFalse(strategy.matches(order));
    }

    @Test
    public void testPriceSearchShouldMatch() {
        Product product = mock(Product.class);
        when(product.getPriceAfterDiscount()).thenReturn(new BigDecimal(1000));

        Order order = new Order(product);

        SearchStrategy strategy = new PriceSearch(BigDecimal.valueOf(1000));

        assertTrue(strategy.matches(order));
    }

    @Test
    public void testPriceSearchShouldNotMatch() {
        Product product = mock(Product.class);
        when(product.getPriceAfterDiscount()).thenReturn(new BigDecimal(800));

        Order order = new Order(product);

        SearchStrategy strategy = new PriceSearch(BigDecimal.valueOf(1000));

        assertFalse(strategy.matches(order));
    }

    @Test
    public void testCustomerLastNameSearchShouldMatch() {
        Order order = new Order(mock(Product.class));
        Customer customer = new Customer("Anna", "Kowalska");
        order.setCustomer(customer);

        SearchStrategy strategy = new CustomerLastNameSearch("Kowalska");

        assertTrue(strategy.matches(order));
    }

    @Test
    public void testCustomerLastNameSearchShouldNotMatch() {
        Order order = new Order(mock(Product.class));
        Customer customer = new Customer("Jan", "Nowak");
        order.setCustomer(customer);

        SearchStrategy strategy = new CustomerLastNameSearch("Kowalska");

        assertFalse(strategy.matches(order));
    }

    @Test
    public void testCombinedSearchShouldMatchAll() {
        Product product = mock(Product.class);
        when(product.getName()).thenReturn("Laptop");
        when(product.getPriceAfterDiscount()).thenReturn(new BigDecimal(2000));

        Order order = new Order(product);
        order.setCustomer(new Customer("Anna", "Kowalska"));

        SearchStrategy strategy = new CombinedSearch(List.of(
                new ProductNameSearch("Laptop"),
                new PriceSearch(BigDecimal.valueOf(2000)),
                new CustomerLastNameSearch("Kowalska")
        ));

        assertTrue(strategy.matches(order));
    }

    @Test
    public void testCombinedSearchShouldNotMatchAll() {
        Product product = mock(Product.class);
        when(product.getName()).thenReturn("Laptop");
        when(product.getPriceAfterDiscount()).thenReturn(new BigDecimal(2000));

        Order order = new Order(product);
        order.setCustomer(new Customer("Anna", "Nowak"));

        SearchStrategy strategy = new CombinedSearch(List.of(
                new ProductNameSearch("Laptop"),
                new PriceSearch(BigDecimal.valueOf(2000)),
                new CustomerLastNameSearch("Kowalska")
        ));

        assertFalse(strategy.matches(order));
    }
}
