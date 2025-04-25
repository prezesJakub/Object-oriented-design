package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;


public class ProductTest {

	
    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);

	@Test
    public void testProductName() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPrice() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }

    @Test
    public void testProductPriceAfterDiscount() {
        //given
        Product product = new Product("Discounted", BigDecimal.valueOf(100));
        product.setDiscount(BigDecimal.valueOf(0.25));

        //when
        BigDecimal priceAfterDiscount = product.getPriceAfterDiscount();

        //then
        assertBigDecimalCompareValue(priceAfterDiscount, BigDecimal.valueOf(75.00));
    }
}