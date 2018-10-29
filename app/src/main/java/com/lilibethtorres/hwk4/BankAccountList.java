package com.lilibethtorres.hwk4;

import java.util.ArrayList;

/**
 * Singleton
 */

public class BankAccountList {

    private static volatile BankAccountList INSTANCE = null;

    protected static ArrayList<BankAccount> m_AccountArrayList;

    //presentation
    //protected static ArrayAdapter<BankAccount> m_AccountArrayAdapter;
    //protected static ListView m_AccountListView;

    public BankAccountList()
    {
        m_AccountArrayList = new ArrayList<BankAccount>();
        //Default ArrayData
        m_AccountArrayList.add(new BankAccount("Savings",1234.56));
        m_AccountArrayList.add(new BankAccount("Checking",789.10));
        m_AccountArrayList.add(new BankAccount("Retirement",11012.13));

        //Instances of other variables are defined & connected in AccountListFragment
    }

    //Method needed for singleton
    public static BankAccountList getInstance()
    {
        if (INSTANCE == null)
        {
            synchronized (BankAccountList.class)
            {
                INSTANCE = new BankAccountList();
            }
        }
        return INSTANCE;
    }

    public BankAccount GetAccountByName(String name)
    {
        for (int i = 0; i < m_AccountArrayList.size(); i++)
        {
            if (m_AccountArrayList.get(i).m_accountName == name)
            {
                return m_AccountArrayList.get(i);
            }
        }
        return null;
    }

    public static ArrayList<BankAccount> GetInternalList()
    {
        return m_AccountArrayList;
    }


}
