package com.example.categorydetailexampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
    public FoodAdapter(Context context, ArrayList<Food> foodList) {
        super(context, 0, foodList);
    }
    // this method will tell us how to set up ONE row of ListView
    public View getView(int position, View convertView, ViewGroup parent) {
        Food myFood = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_food_row_layout, parent, false);
        }
        // Step 1: Connect XML references for YOUR custom view

        TextView name = convertView.findViewById(R.id.foodName);
        TextView description = convertView.findViewById(R.id.foodDescription);
        TextView price = convertView.findViewById(R.id.foodPrice);


        // Step 2: Populate the specific row data into the variables you made in step 1

        name.setText(myFood.getName());
        description.setText(myFood.getDesc());
        price.setText("$" + myFood.getPrice());


        // Step 3: Return the completed view to render on screen
        return convertView;
    }
}

