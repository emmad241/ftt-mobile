package com.example.investify;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.investify.Adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    ImageView logo;
    Button menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.investify.R.layout.activity_home);

        logo = findViewById(R.id.imageView2);
        menuBtn = findViewById(R.id.menuBtn);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(HomeActivity.this, menuBtn);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
                popup.show();
                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().equals("My Assets")){
                            startActivity(new Intent(HomeActivity.this, MyAssetActivity.class));
                        }
                        else if (item.getTitle().equals("Buy Assets")){
                            startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                        }
                        else if (item.getTitle().equals("Support")){
                            startActivity(new Intent(HomeActivity.this, AccountTypeActivity.class));
                        }
                        else if (item.getTitle().equals("Reviews")){
                            startActivity(new Intent(HomeActivity.this, ReviewActivity.class));
                        }
                        else{
                            throw new IllegalStateException("Unexpected value: " + item.getTitle());
                        }
                        Toast.makeText(HomeActivity.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        ViewPagerAdapter sa = new ViewPagerAdapter(fm, getLifecycle());
        final ViewPager2 pa = findViewById(R.id.my_viewpager);
        pa.setAdapter(sa);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        Glide.with(this)
                .load(R.drawable._logo)
                .fitCenter()
                .into(logo);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pa.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pa.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}