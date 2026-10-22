package org.baltimorecityschools.restaurantappproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button scMenuF, scMenuF2, orderB ;
    ImageView myMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Header Menu Button
         orderB = findViewById(R.id.orderBF );
         orderB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, orderBActivity.class);
                startActivity(intent);
            }
        });

        // 2. Browse Menu Button 1
        scMenuF = findViewById(R.id.scMenuF);
        scMenuF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, pizzaMenuActivity.class);
                startActivity(intent);
            }
        });

        // 3. Browse Menu Button 2
        scMenuF2 = findViewById(R.id.scMenuF2);
        scMenuF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, drinksMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
