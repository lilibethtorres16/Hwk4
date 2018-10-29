package com.lilibethtorres.hwk4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class AccountDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View rootView;

        rootView = inflater.inflate(R.layout.fragment_accountdetail, container, false);

        Intent intent = getActivity().getIntent();

        EditText AccountName = (EditText) rootView.findViewById(R.id.AccountDetailNameeditText);

        String account_name = intent.getStringExtra("selectedAccount");
        AccountName.setText(account_name);

        EditText Balance = (EditText) rootView.findViewById(R.id.BalanceDetaileditText);

        double balance = intent.getDoubleExtra("selectedBalance",0);
        Balance.setText(Double.toString(balance));

        return rootView;

    }

    public void DisplayAccount(BankAccount ba)
    {
        EditText AccountName = (EditText) getView().findViewById(R.id.AccountDetailNameeditText);

        String account_name = ba.toString();
        AccountName.setText(account_name);

        EditText Balance = (EditText) getView().findViewById(R.id.BalanceDetaileditText);

        double balance = ba.getBalance();
        Balance.setText(Double.toString(balance));
    }

    @Override
    public void onPause()
    {
        //Using on Pause to prevent Overlapping Data
        super.onPause();

        EditText AccountName = (EditText) getView().findViewById(R.id.AccountDetailNameeditText);
        AccountName.getText().clear();

        EditText Balance = (EditText) getView().findViewById(R.id.BalanceDetaileditText);
        Balance.getText().clear();

    }
}
