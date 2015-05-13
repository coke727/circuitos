package es.uva.inf.kave.myapplication;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;

public class TabListener implements android.support.v7.app.ActionBar.TabListener {

    private Fragment fragment;

    // The contructor.
    public TabListener(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
        //fragmentTransaction.replace(R.id.pager, fragment);
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
        //fragmentTransaction.remove(fragment);
    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }
}

