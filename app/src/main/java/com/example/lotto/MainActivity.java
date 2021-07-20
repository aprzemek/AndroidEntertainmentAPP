package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button2 = (Button) this.findViewById(R.id.button2);
        this.button3 = (Button) this.findViewById(R.id.button3);
        this.button4 = (Button) this.findViewById(R.id.button4);
        this.button5 = (Button) this.findViewById(R.id.button5);
        button2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, MusicAvtivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        button3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, WalpaperAcvtivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        button4.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, VideoActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        button5.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, GameActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}