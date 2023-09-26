package com.example.categorydetailexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        try {
            // This gets the particular Detailed object we are displaying
            // In this case, it is a Food object.
            Food myFood = intent.getParcelableExtra("Chosen Food");
            // This page will display the specific Detailed data for what your app is showing.
            // Get references to the xml views for name, price, desc, and photo
            TextView nameTV = findViewById(R.id.nameTextView);
            TextView priceTV = findViewById(R.id.priceTextView);
            TextView descTV = findViewById(R.id.descriptionTextView);
            ImageView image = findViewById(R.id.imageView);
            // set values on the screen based on the object that was passed to this Detail activity
            nameTV.setText(myFood.getName());
            priceTV.setText("$" + myFood.getPrice());
            descTV.setText(myFood.getDesc());


            if (myFood.getImageResourceID() == 0) {
                // set a default pic or decide what to do in this case.
            }
            else {
                image.setImageResource(myFood.getImageResourceID());
            }
        }
        catch (Exception e) {
            Log.i("Denna", "Food app not working!");
        }
    }

}