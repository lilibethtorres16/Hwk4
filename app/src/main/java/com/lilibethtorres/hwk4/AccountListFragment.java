package com.lilibethtorres.hwk4;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AccountListFragment extends Fragment {

    private AccountSelectionCallback callBack;

    //In this fragment so i can use it in BOTH onCreate and onResume
    private ArrayAdapter<BankAccount> AccountArrayAdapter;
    private ListView AccountListView;
    private View rootView;
    //***************************************************************
    // The fragment that needs to send a message defines an
    // interface that can be implemented by the containing activity.
    //***************************************************************
    interface AccountSelectionCallback
    {
        void accountSelected(BankAccount ba);
    }

    //***************************************************************
    // This is so that the fragment is not dependent on where it gets
    // plugged into.
    //***************************************************************
    //Fragment Keeps Interface Reference to the Callback Activity
    public void onAttach(Context context)
    {
        super.onAttach(context);
        callBack =(AccountSelectionCallback) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        rootView = inflater.inflate(R.layout.fragment_accountlist, container, false);

        //Make Connections Here
        AccountListView = (ListView) rootView.findViewById(R.id.accountlist_listview);

        AccountArrayAdapter = new ArrayAdapter<BankAccount>
                (getContext(),R.layout.item_accountlist,BankAccountList.getInstance().m_AccountArrayList);

        AccountListView.setAdapter(AccountArrayAdapter);

        // Get the button instance
        Button AddAccountButton = (Button)rootView.findViewById(R.id.AddAccountbutton);
        // Set button event handler method for the add account button
        AddAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // Create the intent
                Intent I = new Intent(getActivity(), AddAccountActivity.class);
                // Execute
                startActivity(I);
            }
        });

        AccountListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int Phone_orientation = getResources().getConfiguration().orientation;

                if (Phone_orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    Intent I = new Intent(getActivity(), AccountDetailActivity.class);
                    I.putExtra("selectedAccount", AccountArrayAdapter.getItem(i).toString());
                    I.putExtra("selectedBalance", AccountArrayAdapter.getItem(i).getBalance());
                    startActivity(I);
                }
                else
                {
                    BankAccount ba = new BankAccount
                            (AccountArrayAdapter.getItem(i).toString(),
                                    AccountArrayAdapter.getItem(i).getBalance());
                    callBack.accountSelected(ba);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        //BankAccountList.m_AccountArrayList.clear();

        AccountArrayAdapter = new ArrayAdapter<BankAccount>
                (getContext(),R.layout.item_accountlist,BankAccountList.getInstance().m_AccountArrayList);

        AccountListView.setAdapter(AccountArrayAdapter);

    }

}
