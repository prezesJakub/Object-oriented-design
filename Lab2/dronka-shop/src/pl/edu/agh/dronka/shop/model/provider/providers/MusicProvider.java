package pl.edu.agh.dronka.shop.model.provider.providers;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.Music;
import pl.edu.agh.dronka.shop.model.items.MusicGenre;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.Provider;

public class MusicProvider implements Provider {
    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        MusicGenre genre = MusicGenre.valueOf(reader.getValue(dataLine, "Gatunek muzyczny"));
        boolean videoAdded = Boolean.parseBoolean(reader.getValue(dataLine, "Dołączone wideo"));
        return new Music(name, category, price, quantity, genre, videoAdded);
    }
}
