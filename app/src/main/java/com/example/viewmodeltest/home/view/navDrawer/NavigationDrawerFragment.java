package com.example.viewmodeltest.home.view.navDrawer;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.viewmodeltest.R;

public class NavigationDrawerFragment extends Fragment {
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    private ActionBarDrawerToggle mDrawerToggle;

    private LinearLayout mDrawerr;

    public NavigationDrawerFragment() {}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDrawerr = (LinearLayout) inflater.inflate(R.layout.nav_drawer, container, false);
            ((RecyclerView)mDrawerr.findViewById(R.id.nav_recycler)).setAdapter(new NavRecyclerAdapter(inflater));
        return mDrawerr;
    }


}
