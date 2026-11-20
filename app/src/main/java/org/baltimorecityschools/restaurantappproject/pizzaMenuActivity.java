
package org.baltimorecityschools.restaurantappproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class pizzaMenuActivity extends AppCompatActivity {

    Button orderSc;
    ImageButton pepperoniButton, veggieButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_menu);

        orderSc = findViewById(R.id.orderB);
        pepperoniButton = findViewById(R.id.pepperoniButton);
        veggieButton = findViewById(R.id.veggieButton);


        pepperoniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        pizzaMenuActivity.this,
                        orderBActivity.class
                );

                intent.putExtra("pizzaName", "Pepperoni");

                startActivity(intent);
            }
        });


        veggieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        pizzaMenuActivity.this,
                        orderBActivity.class
                );

                intent.putExtra("pizzaName", "Veggie");

                startActivity(intent);
            }
        });

        orderSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        pizzaMenuActivity.this,
                        orderBActivity.class
                );

                intent.putExtra("pizzaName", "Pepperoni");

                startActivity(intent);
            }
        });
    }
}


