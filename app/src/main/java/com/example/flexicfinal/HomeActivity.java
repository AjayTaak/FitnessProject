package com.example.flexicfinal.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flexicfinal.activity.ActivityActivity;
import com.example.flexicfinal.adapter.SectionsPagerAdapter;
import com.example.flexicfinal.R;
import com.example.flexicfinal.message.MessageActivity;
import com.example.flexicfinal.notifications.NotificationActivity;
import com.google.android.material.tabs.TabLayout;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.xw.repo.BubbleSeekBar;

import maes.tech.intentanim.CustomIntent;

public class HomeActivity extends AppCompatActivity {

    //Log
    private static final String TAG = "HomeActivity";

    //Global
    private Context mContext = HomeActivity.this;
    private static final int HOME_FRAGMENT = 1;

    //Variables

    //Widgets
    private ViewPager mView;

    //test
    Button btnDay, btnNight;
    BubbleSeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_tab);

        mView = findViewById(R.id.viewpager_container);
        bottomNav(savedInstanceState);
        setupViewPager();

//        btnDay = findViewById(R.id.btnDay);
//        btnNight = findViewById(R.id.btnNight);
//
//        btnDay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//                finish();
//            }
//        });
//
//        btnNight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//                finish();
//            }
//        });

//        seekBar = findViewById(R.id.seekBar);
//
//        seekBar.getConfigBuilder()
//                .min(0)
//                .max(5)
//                .progress(0)
//                .sectionCount(5)
//                .showSectionMark()
//                .seekBySection()
//                .autoAdjustSectionMark()
//                .build();
//
//
//        seekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
//            @Override
//            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
//                Log.d(TAG, "onCreate: ekfjowf: "+seekBar.getProgress());
//            }
//
//            @Override
//            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
//
//            }
//
//            @Override
//            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
//
//            }
//        });

    }

    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ExploreFragment());//FRAGMENT 0
        adapter.addFragment(new HomeFragment());//FRAGMENT 1
        adapter.addFragment(new ProfileFragment());//FRAGMENT 2
        mView.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mView);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_close_foreground);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_close_foreground);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_close_foreground);

    }

    private void bottomNav(Bundle savedInstanceState){
        SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.navBar);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.ic_close_foreground));
        spaceNavigationView.addSpaceItem(new SpaceItem("ACTIVITY", R.drawable.ic_close_foreground));
        spaceNavigationView.addSpaceItem(new SpaceItem("MESSAGES", R.drawable.ic_close_foreground));
        spaceNavigationView.addSpaceItem(new SpaceItem("NOTIFICATIONS", R.drawable.ic_close_foreground));
        spaceNavigationView.showIconOnly();

        spaceNavigationView.changeCurrentItem(0);

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(mContext,"ShareButton", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(mContext, itemIndex + " HomePage " + itemName, Toast.LENGTH_SHORT).show();

                if (itemIndex == 0 && itemName.equals("HOME")){
                    Intent intent0 = new Intent(mContext, HomeActivity.class);
                    mContext.startActivity(intent0);
                    CustomIntent.customType(mContext, "fadein-to-fadeout");
                }  else if (itemIndex == 1 && itemName.equals("ACTIVITY")){
                    Intent intent1 = new Intent(mContext, ActivityActivity.class);
                    mContext.startActivity(intent1);
                    CustomIntent.customType(mContext, "fadein-to-fadeout");
                }  else if (itemIndex == 2 && itemName.equals("MESSAGES")){
                    Intent intent2 = new Intent(mContext, MessageActivity.class);
                    mContext.startActivity(intent2);
                    CustomIntent.customType(mContext, "fadein-to-fadeout");
                }  else if (itemIndex == 3 && itemName.equals("NOTIFICATIONS")){
                    Intent intent3 = new Intent(mContext, NotificationActivity.class);
                    mContext.startActivity(intent3);
                    CustomIntent.customType(mContext, "fadein-to-fadeout");
                }  else {
                    Toast.makeText(mContext, "Oops, Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                //Toast.makeText(mContext, itemIndex + " ActivityPage " + itemName, Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onStart() {
        super.onStart();

        mView.setCurrentItem(HOME_FRAGMENT);

    }


}
