package com.cookandroid.and0727_05_tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragementAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragList = new ArrayList<>();
    public FragementAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragList.add(new BankData());//0
        fragList.add(new BankInput());//1
        fragList.add(new BankOutput());//2
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);//position은 인덱스 번호
    }

    @Override
    public int getCount() {
        return fragList.size();//페이지 객수 return
    }
}
