package Accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Check {
    protected int customerId;//cutomer ID
    protected int checkNumber;//check number
    protected Date inputDate;//date inputted into system
    protected Double amount;//check amount
    protected boolean honor;//if we will honor the check
    protected boolean payed;//have we deposited the money or transfered the funds yet
    protected boolean deposit;
    
    public Check(int customer, int checkNum,Double amount,boolean deposit, Date inputD,boolean honor, boolean payed){
        this.customerId=customer;
        this.checkNumber=checkNum;
        this.amount=amount;
        this.inputDate=inputD;
        this.honor=true;
        this.deposit=deposit;
        if(deposit)this.payed=true;
        else payed=false;
    }
    public String[] accountToArray()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return new String[]
                {
                        Integer.toString(customerId),Integer.toString(checkNumber), Double.toString(amount), Boolean.toString(deposit),
                        formatter.format(inputDate), Boolean.toString(honor),Boolean.toString(payed)
                };
    }
}
