package pl.edu.agh.dronka.shop.model.provider.providers;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.Electronics;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.Provider;

public class ElectronicsProvider implements Provider {

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        boolean isMobile = Boolean.parseBoolean(reader.getValue(
                dataLine, "Mobilny"));
        boolean warranty = Boolean.parseBoolean(reader.getValue(
                dataLine, "Gwarancja"));
        return new Electronics(name, category, price, quantity, isMobile, warranty);
    }
}
