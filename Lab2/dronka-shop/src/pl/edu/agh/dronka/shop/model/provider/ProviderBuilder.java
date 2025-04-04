package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.provider.providers.*;

public class ProviderBuilder {
    public static Provider getProvider(Category category) {
        switch(category) {
            case BOOKS: {
                return new BookProvider();
            }
            case ELECTRONICS: {
                return new ElectronicsProvider();
            }
            case FOOD: {
                return new FoodProvider();
            }
            case MUSIC: {
                return new MusicProvider();
            }
            case SPORT: {
                return new SportProvider();
            }
            default: {
                throw new IllegalArgumentException("Invalid category");
            }
        }
    }
}
