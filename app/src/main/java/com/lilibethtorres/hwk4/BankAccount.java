package com.lilibethtorres.hwk4;

public class BankAccount {

    //Private member variables
    protected CharSequence m_accountName;
    protected double m_accountBalance;

    //Used for the ArrayList
    public BankAccount(String n, double b)
    {
        m_accountName=n;
        m_accountBalance=b;
    }

    //GET & SET METHODS

    public CharSequence getAccount()
    {
        return m_accountName;
    }

    public double getBalance()
    {
        return m_accountBalance;
    }

    public void setAccount(String a)
    {
        m_accountName=a;
    }

    public void setBalance(double b)
    {
        m_accountBalance=b;
    }

    @Override
    public String toString() {
        super.toString();
        //So that the names appear in the ListView
        String name = String.valueOf(m_accountName);
        return name;
    }

}
