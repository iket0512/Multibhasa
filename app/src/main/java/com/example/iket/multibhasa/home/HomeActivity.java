package com.example.iket.multibhasa.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.iket.multibhasa.R;
import com.example.iket.multibhasa.assignment.view.WelcomeActivity;

public class HomeActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(HomeActivity.this, WelcomeActivity.class);
                startActivity(in);
            }
        });
    }
}
