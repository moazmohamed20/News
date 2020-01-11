package com.moaz.news;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdapterTabs extends FragmentPagerAdapter {

    public AdapterTabs(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sports";
            case 1:
                return "Technology";
            case 2:
                return "Giphy";
            default:
                return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentSports();
            case 1:
                return new FragmentTechnology();
            case 2:
                return new FragmentGiphy();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
