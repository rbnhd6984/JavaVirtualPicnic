package org.example.JavaVirtualPicnic;

class Fruit extends FoodItem {
    public Fruit(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "фрукт";
    }
}
