package com.example.categorydetailexampleapp;
import android.os.Parcel;
import android.os.Parcelable;

/*
Here is a cheat sheet to make an object Parcelable - or able to be sent through an intent
1. implements Parcelable on class header
2. default constructor (one without any params)
3. constructor that tells Java how to read a Parcel to create object
4. writeToParcel method tells Java how to send the Parcel
5. Creator method - simply replace Food with the name of your class
6. need the describeContents method which we aren't modifying
 */

public class Food implements Parcelable {
    private String name;
    private double price;
    private String desc;
    private int imageResourceID;

    public static final Food[] myBreakfast = {
            new Food("Toast", 7.50, "2 Pieces, Golden Brown, Honey-Coated", R.drawable.toast),
            new Food("Bagel", 4.50, "1 Bagel, Cream Cheese", R.drawable.bagel),
            new Food("Pie", 5.50, "1 Slice, Apple Filling", R.drawable.pie)

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

    public Food(String name, double price, String desc, int imageResourceID) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.imageResourceID = imageResourceID;
    }

    public Food(String name, double price, int imageResourceID) {
        this.name = name;
        this.price = price;
        this.imageResourceID = imageResourceID;
        desc = "";
    }

    // A default constructor is required for the Parceable interface to work
    // if you forget this default constructor, your object will NOT be able to be
    // used in the way we intend. EVEN IF you never call this constructor
    // you MUST have it

    public Food() {
        name = "";
        price = 0;
        desc = "";
        imageResourceID = 0;
    }


    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Food object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * if the instance variables were objects themselves you would need to do more complex * code.  We need to read in the String, double, and int data.
     *
     * The order of these read methods matters. Whatever order we use, we need to
     * be consistent with
     *
     * @param parcel    the parcel that is received from the intent
     */

    public Food(Parcel parcel) {
        name = parcel.readString();
        price = parcel.readDouble();
        desc = parcel.readString();
        imageResourceID = parcel.readInt();
    }



    /**
     * This is what is used when we send the Food object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Food constructor that accepts a Parcel reference can "unpack it"
     *
     * The order that each var is packed (with write method) MUST be the same
     * as the order that it is unpacked (with read method) in the constructor
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeString(desc);
        dest.writeInt(imageResourceID);
    }


    // this code is needed for the Food class to work with Parcelable
    // this code needs NO changes, other than replacing the word Food for a different
    // class if you were to implement Parceable in another class.
    public static final Parcelable.Creator<Food> CREATOR = new
            Parcelable.Creator<Food>() {

                @Override
                public Food createFromParcel(Parcel parcel) {
                    return new Food(parcel);
                }

                @Override
                public Food[] newArray(int size) {
                    return new Food[0];
                }
            };


    /**
     * This method is required for the Parceable interface.  As of now, this method * is in the default state and doesn't really do anything.
     *
     * If your Parcelable class will have child classes, you'll need to
     * take some extra care with the describeContents() method. This would
     * let you identify the specific child class that should be created by
     * the Parcelable.Creator. You can read more about how this works on
     *  Stack Overflow with this link.
     *           https://stackoverflow.com/questions/4778834/purpose-of-describecontents-of-parcelable-interface
     * @return
     */

    @Override
    public int describeContents() {
        return 0;
    }

    public String toString() { return name;}

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
