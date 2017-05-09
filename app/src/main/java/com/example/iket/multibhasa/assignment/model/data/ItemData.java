package com.example.iket.multibhasa.assignment.model.data;

/**
 * Created by iket on 9/5/17.
 */

public class ItemData {
    String itemId,desc,audio;

    public ItemData(String itemId, String desc, String audio) {
        this.itemId = itemId;
        this.desc = desc;
        this.audio = audio;
    }

    public String getItemId() {
        return itemId;
    }

    public String getDesc() {
        return desc;
    }

    public String getAudio() {
        return audio;
    }
}
