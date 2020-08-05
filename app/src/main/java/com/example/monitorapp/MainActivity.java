package com.example.monitorapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class MainActivity extends AppCompatActivity {

    private Button mBtnThing;
    private Button mBtnMe;
    private Button mBtnPeople;
    private DrawerLayout mDrawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        mBtnThing = findViewById(R.id.btn_textview);
        mBtnThing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到设备界面
                Intent intent = new Intent(MainActivity.this, ThingViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnMe = findViewById(R.id.btn_me);
        mBtnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人界面
                Intent intent = new Intent(MainActivity.this, MeViewActivity.class);
                startActivity(intent);
            }
        });


        mBtnMe = findViewById(R.id.btn_people);
        mBtnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到人员界面
                Intent intent = new Intent(MainActivity.this, PeopleViewActivity.class);
                startActivity(intent);
            }
        });
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

}
