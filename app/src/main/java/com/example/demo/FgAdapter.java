package com.example.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.demo.model.FrFood;
import com.example.demo.model.FrMovie;
import com.example.demo.model.FrTravel;

public class FgAdapter extends FragmentPagerAdapter {//contructer thì chọn cái thứ 2
    private int pageNumber;//khai báo số lượng frangment có bao  nhiêu trang

    public FgAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber = behavior;//số lượng thổi vào behavior: ví dụ có 3 trang food, movie, travel
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {// viết cho nó trả về"getItem"
        //trả về cái fragment thứ position trả vè
        switch (position) {
            case 0:
                FrFood food = new FrFood();// tạo 1 cái fragment
                return food;// sau đó trả về cái fragmet đó
            case 1:
                FrMovie movie = new FrMovie();
                return movie;
            case 2:
                FrTravel travel = new FrTravel();
                return travel;
        }
        return null;
    }
    @Override
    public int getCount() {
        return pageNumber;//trả về số trang

    }
    // vấn đề riêng của bài này là: có title đặt lên taplayout cho các fragment
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {//phương thức đó là: getPageTitle
        switch (position) {
            case 0: return "FOOD";
            case 1: return "MOVIE";
            case 2: return "TRAVEL";
        }
        return null;
    }
}
