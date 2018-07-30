package com.mostafa.root.retrofittesting.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mostafa.root.retrofittesting.Fragments.PopularMovieFragment;
import com.mostafa.root.retrofittesting.Fragments.TopRatedFragment;
import com.mostafa.root.retrofittesting.Fragments.UpcomingFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public TabPagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    PopularMovieFragment populate = new PopularMovieFragment();
                    return populate;
                case 1:
                    TopRatedFragment top = new TopRatedFragment();
                    return top;
                case 2:
                    UpcomingFragment upcoming = new UpcomingFragment();
                    return upcoming;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
}
