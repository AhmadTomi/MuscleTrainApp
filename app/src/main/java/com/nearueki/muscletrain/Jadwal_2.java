package com.nearueki.muscletrain;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jadwal_2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jadwal_2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_jadwal_2, container, false);

//        TextView tv = (TextView) v.findViewById(R.id.textView1);
//        tv.setText(getArguments().getString("msg"));
        return v;
    }

    public static Jadwal_2 newInstance(String text) {

        Jadwal_2 f = new Jadwal_2();
        Bundle b = new Bundle();
//        b.putString("msg", text);
//
//        f.setArguments(b);

        return f;
    }
}