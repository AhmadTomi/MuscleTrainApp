package com.nearueki.muscletrain;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class JadwalMenu extends AppCompatActivity {


    DrawerLayout drawer;
    private static final int NUM_PAGES = 4;
    //The pager widget, which handles animation and allows swiping horizontally to access previous and next wizard steps.
    public static ViewPager2 viewPager3;
    // The pager adapter, which provides the pages to the view pager widget.
    private FragmentStateAdapter pagerAdapter3;
    // Arrey of strings FOR TABS TITLES
    private String[] titles = new String[]{"Tab1", "Tab2", "Tab3"};
    // tab titles


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_menu);
        viewPager3 = findViewById(R.id.mypager3);
        pagerAdapter3 = new JadwalMenu.MyPagerAdapter(this);
        viewPager3.setAdapter(pagerAdapter3);

//        getSupportActionBar().hide();
        FloatingActionButton fab = findViewById(R.id.fab3);
        final NavigationView menukiri = (NavigationView) findViewById(R.id.nvView3);

        menukiri.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.link_jadwal1:
                        viewPager3.setCurrentItem(0, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_jadwal2:
                        viewPager3.setCurrentItem(1, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_jadwal3:
                        viewPager3.setCurrentItem(2, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_jadwal4:
                        viewPager3.setCurrentItem(3, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_home:
                        JadwalMenu.super.finish();
                        overridePendingTransition(0, 0);
                        return true;

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



//inflating tab layout
//        TabLayout tabLayout =( TabLayout) findViewById(R.id.tab_layout);
//displaying tabs
//        new TabLayoutMediator(tabLayout, viewPager3,(tab, position) -> tab.setText(titles[position])).attach();
    }

    private class MyPagerAdapter extends FragmentStateAdapter {

        public MyPagerAdapter(FragmentActivity fa) {
            super(fa);
        }


        @Override
        public Fragment createFragment(int pos) {


            switch (pos) {
                case 0: {
                    return Jadwal_1.newInstance("fragment 1");
                }
                case 1: {

                    return Jadwal_2.newInstance("fragment 2");
                }
                case 2: {

                    return Jadwal_3.newInstance("fragment 2");
                }
                case 3: {

                    return Jadwal_4.newInstance("fragment 2");
                }


                default:
                    return Jadwal_1.newInstance("fragment 1, Default");
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }


    @Override
    public void onBackPressed() {
        if (viewPager3.getCurrentItem() == 0) {
// If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.d
            super.onBackPressed();
        } else {
// Otherwise, select the previous step.
            viewPager3.setCurrentItem(viewPager3.getCurrentItem() - 1);
        }
    }

    //Menu Tabel Jadwal
    public void link_7minute(View view){

        startActivity(new Intent(getApplicationContext()
                , sevenminute.class));
        overridePendingTransition(0,0);
    }
    public void link_chest(View view){
        Intent i = new Intent(JadwalMenu.this, FullBodyMenu.class);
        i.putExtra("FullBodyPasst",0);
        startActivity(i);
    }
    public void link_shoulder(View view){
        Intent i = new Intent(JadwalMenu.this, MuscleMenu.class);
        i.putExtra("MusclePass",0);
        startActivity(i);
    }
    public void link_tricep(View view){
        Intent i = new Intent(JadwalMenu.this, MuscleMenu.class);
        i.putExtra("MusclePass",15);
        startActivity(i);
    }
    public void link_leg(View view){
        Intent i = new Intent(JadwalMenu.this, MuscleMenu.class);
        i.putExtra("MusclePass",22);
        startActivity(i);
    }
    public void link_abs(View view){
        Intent i = new Intent(JadwalMenu.this, MuscleMenu.class);
        i.putExtra("MusclePass",7);
        startActivity(i);
    }
    public void link_bicep(View view){
        Intent i = new Intent(JadwalMenu.this, MuscleMenu.class);
        i.putExtra("MusclePass",19);
        startActivity(i);
    }
    public void link_back(View view){
        Intent i = new Intent(JadwalMenu.this, MuscleMenu.class);
        i.putExtra("MusclePass",4);
        startActivity(i);
    }

}