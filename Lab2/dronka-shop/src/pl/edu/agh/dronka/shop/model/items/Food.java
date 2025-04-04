package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.FilterSpecification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Food extends Item {
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private Date expirationDate;

    public Food(String name, Category category, int price, int quantity, String expirationDateString) {
        super(name, category, price, quantity);
        try {
            this.expirationDate = convertToDate(expirationDateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Bad data provided");
        }
    }
    private Date convertToDate(String string) throws ParseException {
        return formatter.parse(string);
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return new HashMap<String, Object>() {{
            put("Data przydatności do spożycia", expirationDate);
        }};
    }

    @Override
    public boolean hasAdditionalProperties(FilterSpecification filter) {
        return true;
    }
}
