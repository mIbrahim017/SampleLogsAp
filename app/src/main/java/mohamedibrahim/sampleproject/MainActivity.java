package mohamedibrahim.sampleproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import mohamedibrahim.Tabs.adapter.FragmentPagerAdapter;
import mohamedibrahim.Tabs.tabs.SlidingTabLayout;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabs();


    }

    private void initTabs() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPager = (ViewPager) findViewById(R.id.vpPager);
        mPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()));
        mTabs = (SlidingTabLayout) findViewById(R.id.stTabs);
        mTabs.setCustomTabView(R.layout.custom_tabs, R.id.tvCustomTab);
        //mTabs.setDistributeEvenly(true);
        mTabs.setSelectedIndicatorColors(Color.WHITE);


        mTabs.setViewPager(mPager);
    }


}
