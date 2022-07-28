package BankingApplication;

import java.util.LinkedList;
import java.util.List;

public class BankAppMain {

    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();


        // Read CSV file then create new accounts based on that data
        String file = "/Users/nburchiel/IdeaProjects/JavaPracticeApps/src/NewBankAccounts.csv";
        List<String[]> newAccountHolders = Utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            //System.out.println("NEW ACCOUNT");
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
           // System.out.println(name + " " + sSN + " " + accountType + " $" + initDeposit);

            if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            } else if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));

            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }

        }

         // Accessing a specific element in a List
        //accounts.get(1).showInfo();

        // Iterating through all elements to call a method
        for (Account acc : accounts) {
            System.out.println("\n==========================================\n");
            acc.showInfo();
        }

        // Hard code for testing methods
//        Checking chkacc1 = new Checking("Jimmy Neutron","123456789", 1500);
//
//        Savings savacc1 = new Savings("Carl Weezer", "432122345", 2500);
//
//        chkacc1.showInfo();
//        System.out.println("**********************");
//        savacc1.showInfo();
//
//        savacc1.compoundInterest();
//        savacc1.deposit(5000);
//        savacc1.withdraw(500);
//        savacc1.transfer("Venmo", 1000);



    }

}
