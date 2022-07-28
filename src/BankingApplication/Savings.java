package BankingApplication;

public class Savings extends Account{
    // List properties specific to Savings
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize Savings account properties
    public Savings(String name,String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() -.25;
    }

    private void setSafetyDepositBox() {
//        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3)); //this random number method sometimes produces two digits
//        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
        safetyDepositBoxID = (int) generateRandom(3);
        safetyDepositBoxKey = (int) generateRandom(4);

    }
    // List any methods specific to Savings


    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Savings Account Features" +
                        "\n   Safety Deposit Box ID: " + safetyDepositBoxID +
                        "\n   Safety Deposit Key: " + safetyDepositBoxKey
        );

    }
}
