package Accounts;

public class CheckingAccount extends Account {
    public int customerId;
    public int accountNumber;
    public String accountType;
    public double currentBalance;
    public int backupAccount;
    public String backNumber;
    public int overdrafts;
    public String dateOpened;

    public double interestRate;

    public CheckingAccount(int customerId,int accountNumber,
        String accountType, double currentBalance,
        int backupAccount, String backNumber,
        int overDrafts, String dateOpened){

        this.customerId = customerId;
        this.currentBalance = currentBalance;
        setStatus(0);
    }
}
