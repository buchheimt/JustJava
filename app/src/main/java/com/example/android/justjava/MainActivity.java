/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_check_box);
        EditText nameView = (EditText) findViewById(R.id.name_view);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();
        String name = nameView.getText().toString();
        String priceMessage = createOrderMessage(price, hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Creates a text summary of the order
     * @param price of the order
     * @param hasWhippedCream is whether or not the user selects whipped cream topping
     * @param hasChocolate is whether or not the user selects chocolate topping
     * @param name of the user
     * @return text summary of order
     */
    private String createOrderMessage(int price, boolean hasWhippedCream, boolean hasChocolate,
                                      String name) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + hasWhippedCream;
        priceMessage += "\nAdd chocolate? " + hasChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}