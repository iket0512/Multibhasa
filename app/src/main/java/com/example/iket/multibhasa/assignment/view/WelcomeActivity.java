package com.example.iket.multibhasa.assignment.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.iket.multibhasa.R;
import com.example.iket.multibhasa.assignment.model.RetrofitProvider;
import com.example.iket.multibhasa.assignment.model.data.ItemData;
import com.example.iket.multibhasa.assignment.presenter.PresenterInterface;
import com.example.iket.multibhasa.assignment.presenter.PresenterInterfaceImpl;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity implements ViewInterface {

    private List<ItemData> datas=new ArrayList<>();
    private ProgressBar progressBar;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    LinearLayoutManager linearLayoutManager;
    private PresenterInterface presenterInterface;
    private RelativeLayout welcome,container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initialize();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recycleAdapter);
        viewPager.setAdapter(viewPagerAdapter);
        presenterInterface.requestData();

    }

    private void initialize() {
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recycleAdapter=new RecycleAdapter(this);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        presenterInterface=new PresenterInterfaceImpl(this,new RetrofitProvider());
    }

    @Override
    public void addFragment(MusicPlay fragment, String song) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void showProgressBar(boolean flag) {
        if(flag)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setData(List<ItemData> dataList) {
        recycleAdapter.setData(dataList);
        viewPagerAdapter.setData(dataList);
        viewPagerAdapter.notifyDataSetChanged();
        recycleAdapter.notifyDataSetChanged();

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_LONG).show();
    }

}


