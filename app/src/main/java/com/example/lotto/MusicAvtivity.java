package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MusicAvtivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    private Button buttonBack2;


    public void play(View view){
        mediaPlayer.start();
    }

    public void pause(View view){ mediaPlayer.pause(); }

    public void stop(View view){
        mediaPlayer.stop();
    }

    public void play2(View view){
        mediaPlayer2.start();
    }

    public void pause2(View view){ mediaPlayer2.pause(); }

    public void stop2(View view){
        mediaPlayer2.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);



        mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.sound2);

        this.buttonBack2 = (Button)this.findViewById(R.id.button_back2);

        this.buttonBack2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Back to previous Activity.
                MusicAvtivity.this.finish();
            }
        });




    }


}


