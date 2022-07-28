package BankingApplication;

import java.util.Random;

public abstract class Account implements IBaseRate {
    // List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;
    // Constructor to set base properties and initialize account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;

        //Set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();
    public void compoundInterest() {
        double annualAccruedInterest = balance * (rate/100);
        balance += annualAccruedInterest;
        System.out.println("Accrued Interest : $" + annualAccruedInterest);
        printBalance();

    }
    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
        int uniqueID = index;
//        int randomNumber = (int) (Math.random() * Math.pow(10,3)); //this random number method sometimes produces two digits
        int randomNumber = (int) generateRandom(3);
        return lastTwoOfSSN + uniqueID + randomNumber;
    }


    // List common methods
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("You have deposited $" + amount);
        printBalance();
    }
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("You have withdrawn $" + amount);
        printBalance();
    }
    public void transfer(String toAccount, double amount) {
        balance -= amount;
        System.out.println("Transfering " + amount + " to " + toAccount );
        printBalance();
    }
    public void printBalance() {
        System.out.println("    Your balance is now $" + balance);
    }
    public void showInfo() {
        System.out.println(
                "NAME : " + name +
                "\nACCOUNT NUMBER : " + accountNumber +
                "\nBALANCE : $"+ balance +
                "\nINTEREST RATE : " + rate + "%"
        );
    }
    public long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }
}
