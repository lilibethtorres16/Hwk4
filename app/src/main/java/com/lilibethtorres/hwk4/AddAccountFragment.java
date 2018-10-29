package com.lilibethtorres.hwk4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AddAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        final View rootView;
        rootView = inflater.inflate(R.layout.fragment_addaccount, container, false);

        Button saveButton = (Button) rootView.findViewById(R.id.Savebutton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText saveName = (EditText) rootView.findViewById(R.id.accountNameeditText);
                EditText saveBalance = (EditText) rootView.findViewById(R.id.balanceeditText);

                CharSequence name_charSeq = saveName.getText();
                CharSequence balance_charSeq = saveBalance.getText();

                String account_name = String.valueOf(name_charSeq);
                double account_balance = Double.parseDouble(balance_charSeq.toString());

                //Adding new Data to put into the ArrayList
                BankAccountList.getInstance().m_AccountArrayList.add(new BankAccount(account_name,account_balance));

                //Returns to AccountListActivity
                getActivity().finish();
            }
        });

        return rootView;

    }

}
