package com.nearueki.muscletrain;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Selesai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai);

        TextView score1 = (TextView)findViewById(R.id.nilaiakhir);
        Bundle extras = getIntent().getExtras();
        String nama = extras.getString("KEY_NAME");
        score1.setText(nama);

        ImageButton bt_ulang = (ImageButton)findViewById(R.id.btn_ulang);
        ImageButton bt_home = (ImageButton)findViewById(R.id.btn_home);
        bt_ulang.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(new Intent(getApplicationContext(),Kuis.class));
                Selesai.super.finish();
            }
        });

        bt_home.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
//                startActivity(new Intent(getApplicationContext()
//                        , MenuUtama.class));
                Selesai.super.finish();
            }
        });




    }
    @Override
    public void onBackPressed() {

    }
}