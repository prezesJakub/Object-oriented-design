package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.FilterSpecification;

import java.util.HashMap;
import java.util.Map;

public class Sport extends Item {

    public Sport(String name, Category category, int price, int quantity) {
        super(name, category, price, quantity);
    }

    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return new HashMap<String, Object>();
    }

    @Override
    public boolean hasAdditionalProperties(FilterSpecification filter) {
        return true;
    }
}
