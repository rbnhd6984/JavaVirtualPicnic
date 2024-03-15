package org.example.JavaVirtualPicnic;

abstract class FoodItem {
    private String name;

    public FoodItem(String name) {
        this.name = name;
    }

    public abstract String getCategory();

    public String getName() {
        return name;
    }
}
