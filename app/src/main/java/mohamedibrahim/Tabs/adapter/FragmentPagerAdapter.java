package mohamedibrahim.Tabs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import mohamedibrahim.Fragments.OtherRecentFragment;
import mohamedibrahim.Fragments.RecentFragment;

/**
 * Created by Mohamed on 4/1/2015.
 */
public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    private static final String[] fragments = {"RECENT", "ANOTHER RECENT"};
    private static final Fragment[] currentFragments = {RecentFragment.newInstance(), OtherRecentFragment.newInstance()};


    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        return currentFragments[i];

        //RecentFragment recentFragment = RecentFragment.newInstance();
        //return recentFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
