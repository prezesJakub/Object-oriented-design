package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.FilterSpecification;

import java.util.HashMap;
import java.util.Map;

public class Electronics extends Item {
    private boolean isMobile;
    private boolean warranty;

    public Electronics(String name, Category category, int price, int quantity, boolean isMobile, boolean warranty) {
        super(name, category, price, quantity);
        this.isMobile = isMobile;
        this.warranty = warranty;
    }
    public boolean isMobile() {
        return isMobile;
    }
    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }
    public boolean isWarranty() {
        return warranty;
    }
    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return new HashMap<String, Object>() {{
            put("Mobilny", isMobile);
            put("Gwarancja", warranty);
        }};
    }

    @Override
    public boolean hasAdditionalProperties(FilterSpecification filter) {
        if(filter.isMobile() && !isMobile) {
            return false;
        }
        if(filter.isWarranty() && !warranty) {
            return false;
        }
        return true;
    }
}
