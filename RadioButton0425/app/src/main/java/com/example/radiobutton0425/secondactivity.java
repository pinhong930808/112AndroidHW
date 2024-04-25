package com.example.radiobutton0425;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
//A111221036

import androidx.appcompat.app.AppCompatActivity;

public class secondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity_main);

        // Receive intent
        Intent intent = getIntent();
        String purchaseInfo = intent.getStringExtra("purchaseInfo");

        // Display purchase information
        TextView purchaseInfoTextView = findViewById(R.id.purchase_info_text_view);
        purchaseInfoTextView.setText(purchaseInfo);
    }
}