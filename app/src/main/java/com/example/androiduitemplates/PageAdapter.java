package com.example.androiduitemplates;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    int noOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
              HomeFragment  homeFragment=new HomeFragment();
              return homeFragment;
            case 1:
              ServiceFragment  serviceFragment=new ServiceFragment();
              return serviceFragment;
            case 2:
             AboutFragment   fragment=new AboutFragment();
             return fragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
