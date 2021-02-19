package com.nearueki.muscletrain;

import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MuscleMenu extends AppCompatActivity {
    DrawerLayout parent_view;
    ViewPager2 viewPager2;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musclemenu);
        init();

    }

    private void init(){
        viewPager2 = (ViewPager2)findViewById(R.id.view_pager);
        parent_view = (DrawerLayout)findViewById(R.id.drawer_layout);

        viewPager2.setAdapter(new MuscleViewAdapter(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        final NavigationView menukiri = (NavigationView) findViewById(R.id.nvView);

        int halaman = getIntent().getIntExtra("MusclePass",0);
        viewPager2.setCurrentItem(halaman, true);


        menukiri.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.link_muscle1:
                        viewPager2.setCurrentItem(0,false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_muscle2:
                        viewPager2.setCurrentItem(2,false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_muscle3:
                        viewPager2.setCurrentItem(5,false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_muscle4:
                        viewPager2.setCurrentItem(8, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_muscle5:
                        viewPager2.setCurrentItem(11, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_muscle6:
                        viewPager2.setCurrentItem(14, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_home:
                        MuscleMenu.super.finish();
                        overridePendingTransition(0, 0);
                        return true;
//                    case R.id.link_daftar:
//                        viewPager.setCurrentItem(0, false);
//                        drawer.closeDrawer((int) GravityCompat.START);
//                        return true;
                    default:
                        return false;
                }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer((int) GravityCompat.START);
                menukiri.bringToFront();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();


            }
        });


//        viewPager2.registerOnPageChangeCallback(new OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(final int position, final float positionOffset,
//                    final int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                Snackbar.make(parent_view, "You have selected page: "+(position+1),Snackbar.LENGTH_SHORT).show();
//            }
//        });
    }
}