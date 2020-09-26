package com.example.epubreader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import io.karim.MaterialTabs;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ViewPager pagerAdapter = findViewById(R.id.pager);
        pagerAdapter.setAdapter(new ContentsAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        MaterialTabs materialTabs = findViewById(R.id.tabs);
        materialTabs.setViewPager(pagerAdapter);
  //      getSupportFragmentManager().beginTransaction()
    //            .add(R.id.main,SimpleContentFragment.newInstance("http://www.google.ro")).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case  R.id.help:
                startActivity(new Intent(this, SimpleContentActivity.class));
                break;
            case R.id.about:
                startActivity(new Intent(this, SimpleContentActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}