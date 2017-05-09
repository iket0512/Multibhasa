package com.example.iket.multibhasa.assignment.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iket.multibhasa.R;
import com.example.iket.multibhasa.assignment.model.data.ItemData;
import com.example.iket.multibhasa.assignment.model.data.ListData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 9/5/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private List<ItemData> data=new ArrayList<>();
    private LayoutInflater layoutInflater;
    Context context;

    public RecycleAdapter(Context context1) {
        context=context1;
        layoutInflater=LayoutInflater.from(context1);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.item_recycler,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemData listData =data.get(position);
        holder.textView.setText(listData.getDesc());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<ItemData> data) {
        this.data = data;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.song_name);
        }
    }
}
