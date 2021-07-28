package com.nearueki.muscletrain;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class warmingup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warmingup);


        final VideoView myVideoView = (VideoView)findViewById(R.id.vdwarming);
        myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.warmingup));
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
        warmingup.super.finish();
        overridePendingTransition(0, 0);
//        Intent mylntent = new Intent(getBaseContext(), FullBodyMenu.class); mylntent.putExtra("valuel", 6);
//        startActivity(mylntent);
    }
}