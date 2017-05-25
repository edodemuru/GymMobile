package com.example.edoardo.gymmobile;

/**
 * Created by Edoardo on 12/02/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapterAllen extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterAllen(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Giorno1Fragment tab1 = new Giorno1Fragment();
                return tab1;
            case 1:
                Giorno2Fragment tab2 = new Giorno2Fragment();
                return tab2;
            case 2:
                Giorno3Fragment tab3 = new Giorno3Fragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}