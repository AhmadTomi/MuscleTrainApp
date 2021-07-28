package com.nearueki.muscletrain;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }


    public void link_close(View view){
        Info.super.finish();
        overridePendingTransition(0, 0);
//        Intent mylntent = new Intent(getBaseContext(), FullBodyMenu.class); mylntent.putExtra("valuel", 6);
//        startActivity(mylntent);
    }
}