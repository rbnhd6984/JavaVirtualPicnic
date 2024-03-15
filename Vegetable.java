package org.example.JavaVirtualPicnic;

class Vegetable extends FoodItem {
    public Vegetable(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "овощ";
    }
}
