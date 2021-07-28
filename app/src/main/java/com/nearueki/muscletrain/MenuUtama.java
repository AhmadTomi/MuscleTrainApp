package com.nearueki.muscletrain;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MenuUtama extends AppCompatActivity {
    MediaPlayer mp;
    int state_musik=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        mp = MediaPlayer.create(this, R.raw.op);
        mp.start();
    }

    public void mulai_muscle(View view){

        startActivity(new Intent(getApplicationContext()
                , MuscleMenu.class));
        overridePendingTransition(0,0);
    }
    public void mulai_fullbody(View view){

        startActivity(new Intent(getApplicationContext()
                , FullBodyMenu.class));
        overridePendingTransition(0,0);
    }

    public void mulai_warming(View view){

        startActivity(new Intent(getApplicationContext()
                , warmingup.class));
        overridePendingTransition(0,0);
    }
    public void mulai_info(View view){

        startActivity(new Intent(getApplicationContext()
                , Info.class));
        overridePendingTransition(0,0);
    }

    public void mulai_jadwal(View view){

        startActivity(new Intent(getApplicationContext()
                , JadwalMenu.class));
        overridePendingTransition(0,0);
    }
    public void mulai_kuis(View view){

        startActivity(new Intent(getApplicationContext()
                , Kuis.class));
        overridePendingTransition(0,0);
    }
    public void keluar(View view){
        finishAffinity();
        System.exit(0);
    }
    public void onoff(View view){
        ImageView img = (ImageView) findViewById(R.id.bt_music);
//        MediaPlayer mp = MediaPlayer.create(getBaseContext(),R.raw.op);
//        final MediaPlayer mp = MediaPlayer.create(this, R.raw.op);
        if(state_musik==1){
            img.setImageResource(R.drawable.music_off);
            mp.pause();
            state_musik=0;
        } else {
            img.setImageResource(R.drawable.music_on);
            mp.start();
            mp.setLooping(true);
            state_musik=1;
        }
    }

}