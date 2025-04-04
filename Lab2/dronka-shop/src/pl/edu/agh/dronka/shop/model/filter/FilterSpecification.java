package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Category;

public class FilterSpecification {
    private Category category;
    private boolean isPolish;
    private boolean isSecondhand;
    private boolean isHardcover;
    private boolean isMobile;
    private boolean isWarranty;
    private boolean isVideoAdded;

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public boolean isPolish() {
        return isPolish;
    }
    public void setPolish(boolean isPolish) {
        this.isPolish = isPolish;
    }
    public boolean isSecondhand() {
        return isSecondhand;
    }
    public void setSecondhand(boolean isSecondhand) {
        this.isSecondhand = isSecondhand;
    }
    public boolean isHardcover() {
        return isHardcover;
    }
    public void setHardcover(boolean isHardcover) {
        this.isHardcover = isHardcover;
    }
    public boolean isMobile() {
        return isMobile;
    }
    public void setMobile(boolean isMobile) {
        this.isMobile = isMobile;
    }
    public boolean isWarranty() {
        return isWarranty;
    }
    public void setWarranty(boolean isWarranty) {
        this.isWarranty = isWarranty;
    }
    public boolean isVideoAdded() {
        return isVideoAdded;
    }
    public void setVideoAdded(boolean isVideoAdded) {
        this.isVideoAdded = isVideoAdded;
    }
}
