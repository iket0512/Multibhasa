package com.example.iket.multibhasa.assignment.model.data;

import java.util.List;

/**
 * Created by iket on 9/5/17.
 */

public class ListData {
    private List<ItemData> data;

    public ListData(List<ItemData> data) {
        this.data = data;
    }

    public List<ItemData> getData() {
        return data;
    }
}
