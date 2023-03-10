package com.company;

public class BankTester {

    public static void main(String[] args) {
	CheckingAccount studentAcct = new CheckingAccount
            (9999,"Ralph" , 1000, 20);

    System.out.println(studentAcct.toString());

    studentAcct.deposit(50);

    System.out.println(studentAcct);

    studentAcct.deposit(15);

    System.out.println(studentAcct);





    }
}
