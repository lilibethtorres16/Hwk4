package com.lilibethtorres.hwk4;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class AccountListActivity extends AppCompatActivity implements AccountListFragment.AccountSelectionCallback {

    private AccountDetailFragment detailFragment;
    //***************************************************
    // Containing Activity Implements Fragments Callback
    // Interface (also calls method on other fragment)
    //***************************************************
    public void accountSelected(BankAccount ba)
    {
        detailFragment.DisplayAccount(ba);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountlist);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        int Phone_orientation;
        Phone_orientation = AccountListActivity.this.getResources().getConfiguration().orientation;

        ft.add(R.id.accountlist_container, new AccountListFragment());

        if (Phone_orientation == Configuration.ORIENTATION_LANDSCAPE) {
            detailFragment = new AccountDetailFragment();
            ft.add(R.id.accountdetail_container, detailFragment);
        }
        ft.commit();
    }


}
