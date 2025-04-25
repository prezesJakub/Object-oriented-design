package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.search.CustomerLastNameSearch;
import pl.edu.agh.internetshop.search.SearchStrategy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderHistoryTest {

    @Test
    public void testSearchByLastName() {
        //given
        OrderHistory history = new OrderHistory();

        Product product = mock(Product.class);
        when(product.getName()).thenReturn("Book");

        Order order1 = new Order(product);
        order1.setCustomer(new Customer("Anna", "Kowalska"));

        Order order2 = new Order(product);
        order2.setCustomer(new Customer("Jan", "Nowak"));

        history.add(order1);
        history.add(order2);

        SearchStrategy strategy = new CustomerLastNameSearch("Kowalska");

        //when
        List<Order> results = history.search(strategy);

        //then
        assertEquals(1, results.size());
        assertEquals("Kowalska", results.get(0).getCustomer().getLastName());
    }
}
