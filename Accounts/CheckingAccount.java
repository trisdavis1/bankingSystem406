package Accounts;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckingAccount extends Account {
    private String accountType;
    private boolean isBackedUp;
    private int backupAccountNumber;
    private int overdrafts;
    private Date dateOpened;

    public CheckingAccount(int customerId, int accountNumber, String accountType, double currentBalance,
                           boolean backupAccount, int backupAccountNumber, int overDrafts, Date dateOpened
                          )
    {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.currentBalance = currentBalance;
        this.isBackedUp = backupAccount;
        this.backupAccountNumber = backupAccountNumber;
        this.overdrafts = overDrafts;
        this.dateOpened = dateOpened;

        setStatus(0);
    }

    public String[] accountToArray()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return new String[]
                            {
                                 Integer.toString(customerId), Integer.toString(accountNumber),
                                 accountType, Double.toString(currentBalance),
                                 Boolean.toString(isBackedUp), Integer.toString(backupAccountNumber),
                                 Integer.toString(overdrafts), formatter.format(dateOpened)
                            };

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean getisBackedUp() {
        return isBackedUp;
    }
    public void setisBackup(boolean isIt){
        isBackedUp=isIt;
    }

    public void setBackupAccount(int backupAccount) {
        this.backupAccountNumber = backupAccount;
    }

    public int getBackupAccountNumber() {
        return backupAccountNumber;
    }

    public void setBackupAccountNumber(int backupAccountNumber) {
        this.backupAccountNumber = backupAccountNumber;
    }

    public int getOverdrafts() {
        return overdrafts;
    }

    public void setOverdrafts(int overdrafts) {
        this.overdrafts = overdrafts;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }
    public String getType(){
        return accountType;
    }
    public double withdraw(double amount){
        //withdraw money
        double total=amount+.5;
        if(currentBalance>=total)
            currentBalance-=total;
        return currentBalance;
    }
    public double deposit(double amount){
        //give some coins to your witcher
        double total=amount;
        if(type.equals("TMB"));total=-0.5;
        currentBalance+=total;
        return currentBalance;
    }
    public double monthlyTransfer(double amount, Account account){
        //withdraw money
        double total=amount+.75;
        if(currentBalance>=total){
            currentBalance-=total;
            account.currentBalance+=amount;
        }
        return currentBalance;
    }
}
