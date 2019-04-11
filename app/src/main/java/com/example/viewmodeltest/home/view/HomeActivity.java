package com.example.viewmodeltest.home.view;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;

import com.example.viewmodeltest.R;
import com.example.viewmodeltest.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    private  DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateDrawer();
    }

    private void initiateDrawer(){
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    protected void performHomeClickAction() {
        if(drawerLayout.isDrawerOpen(Gravity.START))
            drawerLayout.closeDrawer(Gravity.START);
        else drawerLayout.openDrawer(Gravity.START);
    }
}
