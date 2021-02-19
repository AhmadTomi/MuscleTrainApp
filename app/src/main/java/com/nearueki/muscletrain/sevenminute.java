package com.nearueki.muscletrain;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class sevenminute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sevenminute);


        final VideoView myVideoView = (VideoView)findViewById(R.id.vd7minute);
        myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vd7minute));
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(myVideoView);

        myVideoView.setMediaController(mediaController);


        myVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer arg0) {
                myVideoView.requestFocus();
                myVideoView.start();
            }
        });


    }



    public void link_close(View view){
        sevenminute.super.finish();
        overridePendingTransition(0, 0);
//        Intent mylntent = new Intent(getBaseContext(), FullBodyMenu.class); mylntent.putExtra("valuel", 6);
//        startActivity(mylntent);
    }
}