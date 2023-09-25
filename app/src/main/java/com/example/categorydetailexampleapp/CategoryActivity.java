package com.example.categorydetailexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Intent intent = getIntent();
        // Gets the particular ArrayList that was passed in of the specific type.
        // In this case, of type Food.
        ArrayList<Food> dataToDisplay = intent.getParcelableArrayListExtra("Array Values");

        // The ArrayAdapter is what will take the data from the ArrayList and feed it to the ListView
        // You can create your own XML layout to describe how each row will look. This is the default layout,
        // calling the toString()
        ArrayAdapter<Food> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, dataToDisplay);
        // This finds the listView and then adds the adapter to bind the data to this view
        ListView listView = (ListView) findViewById(R.id.categoryOptions);
        listView.setAdapter(listAdapter);

        // Create listener to listen for when a Food from the specific Category list is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Creates an intent to go from the Specific Category to the specific Detail
                Intent intent = new Intent(CategoryActivity.this, DetailActivity.class);
                // Sends the specific object at index i to the Detail activity
                // In this case, it is sending the particular Food object
                intent.putExtra("Chosen Food", dataToDisplay.get(position));

                startActivity(intent);
            }
        });
    }

}