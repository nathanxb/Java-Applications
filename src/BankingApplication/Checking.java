package BankingApplication;

public class Checking extends Account{
    // List properties specific to Checking
    private long debitCardNumber;
    private int debitCardPIN;
    // Constructor to initialize Checking properties
    public Checking(String name,String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCardNumber();
    }

    @Override
    public void setRate() {
       rate = getBaseRate() * .15;
    }

    // List any methods specific to Checking

    private void setDebitCardNumber() {
        debitCardNumber = generateRandom(12);
        debitCardPIN = (int) generateRandom(4);
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Checking Account Features" +
                        "\n   Debit Card Number: " + debitCardNumber +
                        "\n   Debit Card PIN: " + debitCardPIN
        );
    }
}
