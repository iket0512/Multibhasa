package com.example.iket.multibhasa.assignment.view;

import com.example.iket.multibhasa.assignment.model.data.ItemData;
import com.example.iket.multibhasa.assignment.model.data.ListData;

import java.util.List;

/**
 * Created by iket on 9/5/17.
 */

public interface Callback {

    void onSuccess(ListData listData);
    void onFailure();
}
