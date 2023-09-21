package com.example.categorydetailexampleapp;

public class Food {
    private String name;

    private double price;

    private String desc;

    private int imageResourceID;

    // Code -> Generate -> Constructor
    public Food(String name, double price, String desc, int imageResourceID) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.imageResourceID = imageResourceID;
    }


    public static final Food[] myBreakfast = {
            new Food("Pizza", 13.99, "6 Slices, Cheese, Fresh Basil", R.drawable.pizza),
            new Food("Toast", 7.50, "2 Pieces, Golden Brown, Honey-Coated", R.drawable.toast),
            new Food("Bagel", 4.50, "1 Bagel, Cream Cheese", R.drawable.bagel),
            new Food("Pie", 5.50, "1 Slice, Apple Filling", R.drawable.bagel)

    };

    public static final Food[] myLunch = {
            new Food("Pizza", 13.99, "6 Slices, Cheese, Fresh Basil", R.drawable.pizza),
            new Food("Grilled Cheese", 7.99, "2 Pieces, Cheese, Toasted Bread", R.drawable.grilledcheese),
            new Food("Noodles", 8.50, "1 Bowl, Spicy", R.drawable.noodles)
    };

    public static final Food[] myDinner = {
            new Food("Soup", 13.99, "1 Bowl, Tomato, Croutons", R.drawable.soup),
            new Food("Pasta", 9.99, "1 Bowl, Cheese, Alfredo Sauce", R.drawable.pasta),
            new Food("Chicken Tenders", 8.50, "7 Pieces, Barbecue Sauce", R.drawable.chicken)
    };


    // get/set methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }
}
