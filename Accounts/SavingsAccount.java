package Accounts;

public class SavingsAccount extends Account {
    public SavingsAccount(int cI,double currentBalance,double interestRate,String dateOpened){
        this.customerId=cI;
        this.currentBalance=currentBalance;
        this.interestRate=interestRate;
        this.dateOpened=dateOpened;
        setStatus(0);
    }
}
