package Accounts;

public class Account {
    public int customerId;
    public double currentBalance;
    public String status;
    public String dateOpened;
    public double interestRate;
    
    public void setStatus(int cOb){
        if(cOb==0)status="current";
        if(cOb==1)status="behind";
    }
    public String getStatus(){
        return status;
    }
}
