package pl.edu.agh.dronka.shop.model.provider.providers;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.Provider;
import pl.edu.agh.dronka.shop.model.items.Book;

public class BookProvider implements Provider {

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        int pages = Integer.parseInt(reader.getValue(dataLine, "Liczba stron"));
        boolean isHardcover = Boolean.parseBoolean(reader.getValue(
                dataLine, "Twarda oprawa"));
        return new Book(name, category, price, quantity, pages, isHardcover);
    }
}
