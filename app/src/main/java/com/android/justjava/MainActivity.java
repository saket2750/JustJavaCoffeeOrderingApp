/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.android.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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

        CheckBox cb = (CheckBox) findViewById(R.id.whipped_cream);
        boolean b = cb.isChecked();
        CheckBox cbc = (CheckBox) findViewById(R.id.chocolate);
        boolean bc = cbc.isChecked();
        EditText txt = (EditText) findViewById(R.id.plain_text_input);
        String name = txt.getText().toString();
        int basePrice = 5;
        if(b)
            basePrice+=1;
        if(bc)
            basePrice+=2;
        int price = basePrice*quantity;
        String prc = "Your total is : ₹ "+price+"\nThank you!";
        String str = "Hi "+name+"\nWhipped cream: "+b+"\nChocolate: "+bc+"\n"+prc;
       // displayMessage(str);
        String subject = "Order details for: "+name;
        String[] emailAr = {"saketsuman275@gmail.com"};

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, emailAr);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,str);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void increaseQuantity(View view){
        ++quantity;
        display(quantity);
       // displayPrice(quantity*5);
    }

    public void composeEmail(String[] addresses, String subject, String body){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void decreaseQuantity(View view){
        if(quantity>1) {
            --quantity;
        }
        display(quantity);
       // displayPrice(quantity*5);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

//    private void displayPrice(float number) {
//        TextView priceView = (TextView) findViewById(R.id.order_summary_text_view);
//        priceView.setText("₹ "+number);
//    }

//    private void displayMessage(String str)
//    {
//        TextView tv = (TextView) findViewById(R.id.order_summary_text_view);
//        tv.setText(str);
//    }
}