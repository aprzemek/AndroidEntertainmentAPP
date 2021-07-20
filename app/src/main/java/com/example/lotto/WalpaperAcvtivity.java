package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WalpaperAcvtivity extends AppCompatActivity {
    ImageView aImageView;


    ImageView bImageView;
    ImageView cImageView;
    ImageView dImageView;
private Button buttonBack3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        aImageView = findViewById(R.id.aImageView);


        this.buttonBack3 = (Button)this.findViewById(R.id.button_back3);

        this.buttonBack3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                WalpaperAcvtivity.this.finish();
            }
        });


    }}