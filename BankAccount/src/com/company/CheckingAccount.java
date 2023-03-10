package com.company;

import java.text.NumberFormat;

public class CheckingAccount extends BankAccount{


    private double transactionFee;

    /*constructors that call the superclass (BankAccount) constructors
     */
    public CheckingAccount() {

    }

    /**
     *constructs a checking account bank account with an initial balance,
     * an account number , an owner and a fee!
     * @param acctNum  account number
     * @param name     name of account holder
     * @param balance   balance in the account
     * @param fee       fee charged with deposit and withdraws
     */
    public CheckingAccount(int acctNum, String name, double balance, double fee) {
        super(acctNum, name, balance);
        this.transactionFee = fee;
        //TODO
    }

    /**
     * the accessor method for transactionFe
     * @return transactionFee
     */
    public double getTransactionFee(){

        return transactionFee;
    }

    /**
     * sets the transactionFee
     * @param fee  the transaction Fee
     */

    public void setTransactionFee(double fee) {

        transactionFee = fee;
    }


    /**
     * This is overridden method
     * @param amount to be deposited
     *
     */
    public void deposit(double amount)
    {
        super.deposit(amount - transactionFee);
    }

    /**
     * This is overridden method
     * @param amount to be withdrawn
     */
    public void withdraw(double amount) {

        super.withdraw(amount - transactionFee);
    }

    /**
     * @return String representation of CheckingAccount object
     */
    public String toString( )
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        //TODO
        return super.toString() + " Transaction fee: " + this.transactionFee;
    }

} //end of Checking Account Class definition
