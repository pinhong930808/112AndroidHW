package com.example.radiobutton0425;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//a111221042劉品宏
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup genderRadioGroup;
    RadioGroup ticketTypeRadioGroup;
    EditText quantityEditText;
    Button confirmButton;
    TextView purchaseInfoTextView;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Initialize views
            genderRadioGroup = findViewById(R.id.gender_radio_group);
            ticketTypeRadioGroup = findViewById(R.id.ticket_type_radio_group);
            quantityEditText = findViewById(R.id.quantity_edit_text);
            confirmButton = findViewById(R.id.confirm_button);
            purchaseInfoTextView = findViewById(R.id.purchase_info_text_view);

            // Button click listener
            confirmButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get selected gender
                    int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                    RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
                    String gender = selectedGenderRadioButton.getText().toString();

                    // Get selected ticket type
                    int selectedTicketTypeId = ticketTypeRadioGroup.getCheckedRadioButtonId();
                    RadioButton selectedTicketTypeRadioButton = findViewById(selectedTicketTypeId);
                    String ticketType = selectedTicketTypeRadioButton.getText().toString();

                    // Get quantity
                    int quantity = 0;
                    try {
                        quantity = Integer.parseInt(quantityEditText.getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Please enter a valid quantity", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Calculate total amount
                    int ticketPrice = 0;
                    switch (ticketType) {
                        case "學生票 ($200)":
                            ticketPrice = 200;
                            break;
                        case "孩童票 ($250)":
                            ticketPrice = 250;
                            break;
                        case "成人票 ($400)":
                            ticketPrice = 400;
                            break;
                    }

                int totalAmount = ticketPrice * quantity;

                // Display purchase information in TextView
                String purchaseInfo = "性別：" + selectedGenderRadioButton.getText().toString() + "\n" +
                        "票種：" + ticketType + "\n" +
                        "張數：" + quantity + "\n" +
                        "總金額：" + totalAmount;
                purchaseInfoTextView.setText(purchaseInfo);

                // Enable the confirm button again for next action
                confirmButton.setText("下一步");
                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Start SecondActivity and pass data
                        Intent intent = new Intent(MainActivity.this, secondactivity.class);
                        intent.putExtra("purchaseInfo", purchaseInfo);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
