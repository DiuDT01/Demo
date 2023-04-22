package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.model.HorizontalFlipTransformation;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

public class MainTapLayout extends AppCompatActivity implements View.OnClickListener{
    //main nay chua View Pager, tapLayout, 2 nut
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button btPre, btNext;

    // sau đó gắn các đối tượng này vào
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tap_layout);
        //gắn các đối tượng bằng cách
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        btPre = findViewById(R.id.btPre);
        btNext = findViewById(R.id.btNext);
        btPre.setOnClickListener(this);
        btNext.setOnClickListener(this);
        //phải có fragment manager để quản lý
        FragmentManager manager = getSupportFragmentManager();
        FgAdapter adapter = new FgAdapter(manager, 3);// chứa manager, số pageNumber là 3 cái
        viewPager.setPageTransformer(true,new HorizontalFlipTransformation());

        viewPager.setAdapter(adapter); //gắn adapter vào viewPager
        tabLayout.setupWithViewPager(viewPager);//gắn viewPager vào tapLayout bằng lệnh setupWithViewPager
        setTabLayoutTitleColor();
        //tạo 1 cái title cho tap bằng 1 màu sắc, định dạng màu cho từng tap
        // trước đó bắt sự kiện cho tap nó new 1 ỉnterface là ONTAPSELECTEDLIS.., thì chỉ viết onTapSelected
        tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.setTabTextColors(Color.BLACK, getResources().getColor(R.color.colorPink));
                        btNext.setBackgroundColor(getResources().getColor(R.color.colorPink));
                        btPre.setBackgroundColor(getResources().getColor(R.color.colorPink));
                        break;
                    case 1:
                        tabLayout.setTabTextColors(Color.BLACK, getResources().getColor(R.color.colorGreen));
                        btNext.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                        btPre.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                        break;
                    case 2:
                        tabLayout.setTabTextColors(Color.BLACK, getResources().getColor(R.color.colorBlue));
                        btNext.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                        btPre.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btNext:
                if (viewPager.getCurrentItem() == 2) {
                    return;
                }else{
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    setTabLayoutTitleColor();
                }
                break;
            case R.id.btPre:
                if (viewPager.getCurrentItem() == 0) {
                    return;
                }else{
                    viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                    setTabLayoutTitleColor();
                }
                break;
        }
    }

    private void setTabLayoutTitleColor() {
        switch (viewPager.getCurrentItem()) {
            case 0:
                tabLayout.setTabTextColors(Color.BLACK, getResources().getColor(R.color.colorPink));
                break;
            case 1:
                tabLayout.setTabTextColors(Color.BLACK, getResources().getColor(R.color.colorGreen));
                break;
            case 2:
                tabLayout.setTabTextColors(Color.BLACK, getResources().getColor(R.color.colorBlue));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        }
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }
}