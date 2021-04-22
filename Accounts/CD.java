package Accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CD extends Account {
    private int accountNumber;
    private Date dateOpened;
    private Date rolloverDate;

    public CD(int customerId, double currentBalance,
        double interestRate, Date dateOpened,
        Date rolloverDate, int accountNumber)
    {
        this.customerId = customerId;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        this.dateOpened=dateOpened;
        this.rolloverDate=rolloverDate;
        this.type="CD";
        this.accountNumber=accountNumber;

        setStatus(0);
    }

    @Override
    public String[] accountToArray()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return new String[]
                {
                        Integer.toString(customerId), Double.toString(currentBalance), Double.toString(interestRate),
                        formatter.format(dateOpened), formatter.format(rolloverDate), Integer.toString(accountNumber)
                };
    }
    public Date getRolloverDate(){
        return rolloverDate;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }
    public void setType(String type){
        this.type="Savings";
    }
    public void setrolloverDate(Date date) {
        this.rolloverDate = date;
    }
}
