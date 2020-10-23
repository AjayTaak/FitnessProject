package com.example.flexicfinal.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.flexicfinal.R;
import com.example.flexicfinal.adapter.SectionsPagerAdapter;
import com.example.flexicfinal.profile.profile_post_feed_fragment;
import com.example.flexicfinal.profile.profile_routine_feed_fragment;
import com.google.android.material.tabs.TabLayout;

public class ProfileFragment extends Fragment {

    //Log
    private static final String TAG = "ProfileFragment";

    //Global
    private Context mContext = getActivity();

    //Variables

    //Widgets
    private ViewPager mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        mView = view.findViewById(R.id.feed_container);

        setupViewPager(view);

        return view;
    }

    private void setupViewPager(View fragmentView) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new profile_post_feed_fragment());//FRAGMENT 0
        adapter.addFragment(new profile_routine_feed_fragment());//FRAGMENT 1
        mView.setAdapter(adapter);

        TabLayout tabLayout = fragmentView.findViewById(R.id.profileTabs);
        tabLayout.setupWithViewPager(mView);

        tabLayout.getTabAt(0).setText("Posts");
        tabLayout.getTabAt(1).setText("Routines");

    }
}
