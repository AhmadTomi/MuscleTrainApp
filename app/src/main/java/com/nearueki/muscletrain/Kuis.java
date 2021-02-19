package com.nearueki.muscletrain;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

public class Kuis extends AppCompatActivity {

    int poin = 0;

    int posisi = 0;

    int x;

    boolean beda;

    String paket[][] = {
            {"which of the following Exercises to train shoulder?", "Dumbbell Lateral Raisel",
                    "Crunch with crossed arms", "Russian twist", "Plank", "Dumbbell Lateral Raise"},
            {"To train legs we can use the following exercises, Except?", "Forward Lunges", "Wall Sit",
                    "Single Leg Bridge", "Russian Twist", "Russian Twist"},
            {"Pull Up is the one exercise that train...?", "Shoulder", "Legs", "Back", "Abs", "Back"},
            {"If you use SPLIT Push Pull Legs 6 days schedule, what the exercise you do in Tuesday?", "Back + Biceps",
                    "Chest + Shoulder + Tricep", "Legs + Abs", "break", "Legs + Abs"},
            {"Which of the following exercise is'nt include in SPLIT Push Pull Legs 6 Day Schedule?", "Chest", "Back",
                    "Plank", "Biceps", "Plank"},
            {"Which the day that we do exercise in Cardio & HIIT 3 Day Scedule?", "Monday", "Wednesday", "Friday",
                    "Saturday", "Saturday"},
            {"in 7 minute workout we do some simple exercise, which the exercise not include in 7 minute Workout?",
                    "Jumping Jack", "Wall sit", "Push Up", "Crunch", "Crunch"},
            {"which of the following Exercises to train Biceps?", "Crunch with crossed arms", "Concentration Curl",
                    "Plank", "Dumbbell Lateral Raise", "Concentration Curl"},
            {"which the exercise that not train Abs?", "Cruch with Crossed Arm", "Foot to Foot Crunch",
                    "Scissors side Cruch", "Dumbell Lateral Cruch", "Dumbell Lateral Cruch"},
            {"In Upper Lower, 4 Days Schedule, what is exercise we do at friday?", "Lower Body", "Lower Body + Abs",
                    "Upper Body", "Upper Body + Abs", "Upper Body"},
            {"look this image, what is the name of this exercise?", "Tricep Bench Dips", "Plank", "Pull Up",
                    "Concentration Curl", "Tricep Bench Dips"},
            {"what the name of exercise in the image?", "Chair Workout", "Concentration Curl", "Wall Sit", "Fake Sit",
                    "Wall Sit"},
            {"what the name of exercise in the Picture?", "Plank", "Sit Up", "Flip Back", "Side Plank", "Plank"},
            {"what the name of exercise in the Picture?", "Plank", "Sit Up", "Concentration Curl", "Push Up",
                    "Push Up"},
            {"what the name of exercise in the Picture?", "Russian Twist", "Push Up", "Pull Up", "Side Plank",
                    "Push Up"},
    };

    int acak[] = new int[10];

    int paket_gambar[] = new int[]{
            R.drawable.kosong, R.drawable.kosong, R.drawable.kosong, R.drawable.kosong, R.drawable.kosong,
            R.drawable.kosong, R.drawable.kosong, R.drawable.kosong, R.drawable.kosong, R.drawable.kosong,
            R.drawable.s_img1, R.drawable.s_img2, R.drawable.s_img3, R.drawable.s_img4, R.drawable.s_img5
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);
        acak_angka();
        setsoal(posisi);
        Button bt_a = (Button) findViewById(R.id.btn_a);
        Button bt_b = (Button) findViewById(R.id.btn_b);
        Button bt_c = (Button) findViewById(R.id.btn_c);
        Button bt_d = (Button) findViewById(R.id.btn_d);

        bt_a.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                penilaian(1);
            }
        });

        bt_b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                penilaian(2);
            }
        });
        bt_c.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                penilaian(3);
            }
        });

        bt_d.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                penilaian(4);
            }
        });

    }

    public void setsoal(int pos) {
        TextView nomer = (TextView) findViewById(R.id.id_no);
        TextView soal = (TextView) findViewById(R.id.id_soal);
        ImageView gambar = (ImageView) findViewById(R.id.id_gambar);
        Button bt_a = (Button) findViewById(R.id.btn_a);
        Button bt_b = (Button) findViewById(R.id.btn_b);
        Button bt_c = (Button) findViewById(R.id.btn_c);
        Button bt_d = (Button) findViewById(R.id.btn_d);
        nomer.setText(Integer.toString(posisi + 1) + ". ");
        soal.setText(paket[acak[pos]][0]);
        if (paket_gambar[acak[pos]] == R.drawable.kosong) {
            gambar.setVisibility(View.INVISIBLE);
        } else {
            gambar.setVisibility(View.VISIBLE);
            gambar.setImageResource(paket_gambar[acak[pos]]);
        }

        bt_a.setText(paket[acak[pos]][1]);
        bt_b.setText(paket[acak[pos]][2]);
        bt_c.setText(paket[acak[pos]][3]);
        bt_d.setText(paket[acak[pos]][4]);
    }

    public void penilaian(int tombol) {

        if (paket[acak[posisi]][tombol] == paket[acak[posisi]][5]) {
            poin = poin + 10;
        }

        if (posisi < 9) {
            posisi = posisi + 1;
            setsoal(posisi);
        } else {
            Intent i = new Intent(Kuis.this, Selesai.class);
            i.putExtra("KEY_NAME", Integer.toString(poin));
            startActivity(i);
            Kuis.super.finish();
        }
    }


    public void acak_angka() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            x = random.nextInt(14);
            if (i == 0) {
                acak[i] = x;
            } else {
                beda = true;
                for (int j = 0; j <= i; j++) {
                    if (acak[j] == x) {
                        beda = false;
                    }
                }
                if (beda == true) {
                    acak[i] = x;
                } else
                    i--;
            }
        }
    }
}
