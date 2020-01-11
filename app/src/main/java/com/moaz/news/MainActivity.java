package com.moaz.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout myTabLayout;
    ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myTabLayout = findViewById(R.id.tab_layout);
        myViewPager = findViewById(R.id.view_pager);

        myTabLayout.setupWithViewPager(myViewPager);
        myViewPager.setAdapter(new AdapterTabs(getSupportFragmentManager()));
        myTabLayout.getTabAt(0).setIcon(R.drawable.ic_sports);
        myTabLayout.getTabAt(1).setIcon(R.drawable.ic_devices);
        myTabLayout.getTabAt(2).setIcon(R.drawable.ic_gif);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
