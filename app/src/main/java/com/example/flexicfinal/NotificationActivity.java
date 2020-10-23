package com.example.flexicfinal.notifications;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flexicfinal.R;
import com.example.flexicfinal.activity.ActivityActivity;
import com.example.flexicfinal.home.HomeActivity;
import com.example.flexicfinal.message.MessageActivity;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import maes.tech.intentanim.CustomIntent;

public class NotificationActivity extends AppCompatActivity {

    //Global
    private Context mContext = NotificationActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifcation_tab);

        bottomNav(savedInstanceState);



    }

    private void bottomNav(Bundle savedInstanceState){
        SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.navBar);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.ic_close_foreground));
        spaceNavigationView.addSpaceItem(new SpaceItem("ACTIVITY", R.drawable.ic_close_foreground));
        spaceNavigationView.addSpaceItem(new SpaceItem("MESSAGES", R.drawable.ic_close_foreground));
        spaceNavigationView.addSpaceItem(new SpaceItem("NOTIFICATIONS", R.drawable.ic_close_foreground));
        spaceNavigationView.showIconOnly();

        spaceNavigationView.changeCurrentItem(3);

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
}
