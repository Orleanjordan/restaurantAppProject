
package org.baltimorecityschools.restaurantappproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class orderBActivity extends AppCompatActivity {

    ImageView pizzaImage;

    TextView pizzaNameText, receiptText;

    RadioGroup sizeGroup, crustGroup;

    EditText quantityInput;

    Button placeOrderButton;
    String pizzaName;

    double basePrice;

    double subtotal;
    double tax;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_bactivity);



        pizzaImage = findViewById(R.id.pizzaImage);
        pizzaNameText = findViewById(R.id.pizzaNameText);
        receiptText = findViewById(R.id.receiptText);
        sizeGroup = findViewById(R.id.sizeGroup);
        crustGroup = findViewById(R.id.crustGroup);
        quantityInput = findViewById(R.id.quantityInput);
        placeOrderButton = findViewById(R.id.placeOrderButton);



        pizzaName = getIntent().getStringExtra("pizzaName");

        if (pizzaName == null) {
            pizzaName = "Pepperoni";
        }

        pizzaNameText.setText(pizzaName);

        if (pizzaName.equals("Pepperoni")) {

            pizzaImage.setImageResource(R.drawable.pepperonipizza);
            basePrice = 10.00;

        } else {

            pizzaImage.setImageResource(R.drawable.images1212);
            basePrice = 9.00;
        }

        sizeGroup.check(R.id.smallPizza);
        crustGroup.check(R.id.regularCrust);


        placeOrderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String quantityString =
                        quantityInput.getText().toString();

                if (quantityString.isEmpty()) {

                    Toast.makeText(orderBActivity.this,
                            "Please enter a quantity",
                            Toast.LENGTH_SHORT).show();

                    return;
                }

                int quantity = Integer.parseInt(quantityString);

                if (quantity <= 0) {

                    Toast.makeText(orderBActivity.this,
                            "Enter a quantity greater than zero",
                            Toast.LENGTH_SHORT).show();

                    return;
                }



                int selectedSize = sizeGroup.getCheckedRadioButtonId();

                double sizePrice = 0.00;
                String size = "";

                if (selectedSize == R.id.smallPizza) {

                    size = "Small";
                    sizePrice = 0.00;

                } else if (selectedSize == R.id.mediumPizza) {

                    size = "Medium";
                    sizePrice = 2.00;

                } else {

                    size = "Large";
                    sizePrice = 4.00;
                }



                int selectedCrust = crustGroup.getCheckedRadioButtonId();

                double crustPrice = 0.00;
                String crust = "";

                if (selectedCrust == R.id.regularCrust) {

                    crust = "Regular";
                    crustPrice = 0.00;

                } else {

                    crust = "Stuffed";
                    crustPrice = 1.50;
                }



                subtotal = (basePrice + sizePrice + crustPrice)
                        * quantity;



                tax = subtotal * 0.06;



                total = subtotal + tax;



                String receipt =

                        "       PIZZA RESTAURANT\n" +
                                "--------------------------------\n" +
                                "Order Receipt\n\n" +

                                "Pizza: " + pizzaName + "\n" +

                                "Size: " + size + "\n" +

                                "Crust: " + crust + "\n" +

                                "Quantity: " + quantity + "\n\n" +

                                "Base Price: $" +
                                String.format(Locale.US, "%.2f", basePrice) + "\n" +

                                "Size Price: $" +
                                String.format(Locale.US, "%.2f", sizePrice) + "\n" +

                                "Crust Price: $" +
                                String.format(Locale.US, "%.2f", crustPrice) + "\n" +

                                "--------------------------------\n" +

                                "Subtotal: $" +
                                String.format(Locale.US, "%.2f", subtotal) + "\n" +

                                "Tax (6%): $" +
                                String.format(Locale.US, "%.2f", tax) + "\n" +

                                "--------------------------------\n" +

                                "TOTAL: $" +
                                String.format(Locale.US, "%.2f", total) + "\n\n" +

                                "Thank you for your order!";

                receiptText.setText(receipt);

                Toast.makeText(orderBActivity.this,
                        "Order placed successfully!",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}



