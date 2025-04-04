package pl.edu.agh.dronka.shop.model.provider.providers;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.Food;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.Provider;

public class FoodProvider implements Provider {

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        String expirationDateString = reader.getValue(
                dataLine, "Data przydatności do spożycia");
        return new Food(name, category, price, quantity, expirationDateString);
    }
}
