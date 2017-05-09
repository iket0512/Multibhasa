package com.example.iket.multibhasa.assignment.view;

import android.app.Fragment;

import com.example.iket.multibhasa.assignment.model.data.ItemData;
import com.example.iket.multibhasa.assignment.model.data.ListData;

import java.util.List;

/**
 * Created by iket on 9/5/17.
 */

public interface ViewInterface {
    void showProgressBar(boolean flag);
    void setData(List<ItemData> dataList);
    void showMessage(String message);
    void addFragment(MusicPlay fragment, String song);
}
