package com.nearueki.muscletrain;

import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class FullBodyMenu extends AppCompatActivity {

    DrawerLayout parent_view;
    ViewPager2 viewPager2;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_body_menu);
        viewPager2 = (ViewPager2)findViewById(R.id.view_pager2);
        parent_view = (DrawerLayout)findViewById(R.id.drawer_layout);

        viewPager2.setAdapter(new FullBodyMenuAdapter(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        final NavigationView menukiri = (NavigationView) findViewById(R.id.nvView);

        int halaman = getIntent().getIntExtra("FullBodyPass",0);
        viewPager2.setCurrentItem(halaman, true);

        menukiri.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.link_fullbody1:
                        viewPager2.setCurrentItem(0, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_fullbody2:
                        viewPager2.setCurrentItem(2, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_fullbody3:
                        viewPager2.setCurrentItem(4, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_fullbody4:
                        viewPager2.setCurrentItem(6, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_fullbody5:
                        viewPager2.setCurrentItem(9, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_fullbody6:
                        viewPager2.setCurrentItem(11, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_fullbody7:
                        viewPager2.setCurrentItem(13, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_fullbody8:
                        viewPager2.setCurrentItem(16, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_fullbody9:
                        viewPager2.setCurrentItem(18, false);
                        drawer.closeDrawer((int) GravityCompat.START);
                        return true;
                    case R.id.link_home:
                        FullBodyMenu.super.finish();
                        overridePendingTransition(0, 0);
                        return true;
//                    case R.id.link_daftar:
//                        viewPager2.setCurrentItem(0, false);
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


    }








//        viewPager2.registerOnPageChangeCallback(new OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(final int position, final float positionOffset,
//                    final int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                Snackbar.make(parent_view, "You have selected page: "+(position+1),Snackbar.LENGTH_SHORT).show();
//            }
//        });
    }