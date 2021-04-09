package Accounts;

import java.util.Date;

public class LoanAccount extends Account{
    public double interestRate;
    public Date paymentDueDate;
    public Date paymentNotificationDate;
    public double paymentAmountDue;
    public String loanType;
    public boolean missedPayment;
    public Date lastPaymentDate;

    public LoanAccount(int customerId, double currentBalance, double interestRate, Date paymentDueDate,
                       Date paymentNotificationDate, double paymentAmountDue, String loanType, boolean missedPayment,
                       Date lastPaymentDate){
        this.customerId = customerId;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        this.paymentDueDate = paymentDueDate;
        this.paymentNotificationDate = paymentNotificationDate;
        this.paymentAmountDue = paymentAmountDue;
        this.loanType = loanType;
        this.missedPayment = missedPayment;
        this.lastPaymentDate = lastPaymentDate;
    }

}
