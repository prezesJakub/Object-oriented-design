package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.FilterSpecification;

import java.util.HashMap;
import java.util.Map;

public class Music extends Item {
    private MusicGenre genre;
    private boolean videoAdded;

    public Music(String name, Category category, int price, int quantity, MusicGenre genre, boolean videoAdded) {
        super(name, category, price, quantity);
        this.genre = genre;
        this.videoAdded = videoAdded;
    }
    public MusicGenre getGenre() {
        return genre;
    }
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }
    public boolean isVideoAdded() {
        return videoAdded;
    }
    public void setVideoAdded(boolean videoAdded) {
        this.videoAdded = videoAdded;
    }
    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return new HashMap<String, Object>() {{
            put("Gatunek muzyczny", genre);
            put("Dołączone wideo", videoAdded);
        }};
    }

    @Override
    public boolean hasAdditionalProperties(FilterSpecification filter) {
        return !filter.isVideoAdded() || isVideoAdded();
    }
}
