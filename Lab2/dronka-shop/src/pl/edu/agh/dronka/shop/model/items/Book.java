package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.FilterSpecification;

import java.util.HashMap;
import java.util.Map;

public class Book extends Item {
    private int pages;
    private boolean hardcover;

    public Book(String name, Category category, int price, int quantity, int pages, boolean hardcover) {
        super(name, category, price, quantity);
        this.pages = pages;
        this.hardcover = hardcover;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public boolean isHardcover() {
        return hardcover;
    }
    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }

    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return new HashMap<String, Object>() {{
            put("Liczba stron", pages);
            put("Twarda oprawa", hardcover);
        }};
    }

    @Override
    public boolean hasAdditionalProperties(FilterSpecification filter) {
        return !filter.isHardcover() || isHardcover();
    }
}
