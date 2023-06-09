/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.android.justjava;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    static int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String prc = "Your total is : ₹ "+quantity*5+ "\n Thank you!";
        displayMessage(prc);
    }

    public void increaseQuantity(View view){
        ++quantity;
        display(quantity);
        displayPrice(quantity*5);
    }

    public void decreaseQuantity(View view){
        if(quantity>1) {
            --quantity;
        }
        display(quantity);
        displayPrice(quantity*5);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(float number) {
        TextView priceView = (TextView) findViewById(R.id.price_text_view);
        priceView.setText("₹ "+number);
    }

    private void displayMessage(String str)
    {
        TextView tv = (TextView) findViewById(R.id.price_text_view);
        tv.setText(str);
    }
}