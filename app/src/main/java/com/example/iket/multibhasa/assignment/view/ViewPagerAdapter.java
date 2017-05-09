package com.example.iket.multibhasa.assignment.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.iket.multibhasa.R;
import com.example.iket.multibhasa.assignment.model.data.ItemData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 10/5/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<ItemData>datas=new ArrayList<>();
    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        return new MusicPlay().newInstance(datas.get(position).getItemId(),datas.get(position).getAudio());
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    public void setData(List<ItemData> data) {
        this.datas = data;
    }
}
