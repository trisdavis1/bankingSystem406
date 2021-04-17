package Accounts;

public class Account {
    protected int customerId;
    protected double currentBalance;
    protected String status;
    protected double interestRate;
    protected String type;//subtypes; here so it can be compared
    protected int accountNumber;
    
    public void setStatus(int cOb){
        if(cOb==0) status = "current";
        if(cOb==1) status = "behind";
    }

    public String getStatus(){
        return status;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
    public double withdraw(double amount){
        //withdraw money
        if(currentBalance>=amount)
            currentBalance-=amount;
        return currentBalance;
    }
    public double deposit(double amount){
        //give some coins to your witcher
        currentBalance+=amount;
        return currentBalance;
    }
    public void setCurrentBalance(double newBalance) {
        this.currentBalance = newBalance;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String[] accountToArray() {
        return new String[0];
    }
    public void setType(int type){
        //0 my bank
        //1 gold
        this.type="";
    }
    public String getType(){
        return type;
    }
}
