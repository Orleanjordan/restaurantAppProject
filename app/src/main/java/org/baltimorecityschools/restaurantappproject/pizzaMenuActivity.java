package org.baltimorecityschools.restaurantappproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class pizzaMenuActivity extends AppCompatActivity {

    Button orderSc;
    boolean pizzTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_menu);


        ImageButton myImageButton = findViewById(R.id.veggiePizza);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pizzaMenuActivity.this, orderBActivity.class);
                startActivity(intent);
            }
        });

        orderSc = findViewById(R.id.orderB);
        orderSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pizzaMenuActivity.this, orderBActivity.class);
                startActivity(intent);
            }
        });
    }  
}
