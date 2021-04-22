package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import Accounts.Account;
import Accounts.CD;
import Accounts.CheckingAccount;
import Accounts.LoanAccount;
import Accounts.SavingsAccount;
import MainProgram.StartProgram;
public class accountView implements Action {
    List<Account> accountList;
    JButton doneButton = new JButton("Done");// creating instance of JButton
    JButton updateButton = new JButton("Update");// creating instance of JButton
    JFrame accountFrame = new JFrame();// creating instance of JFrame
    Account account=new Account();
    JLabel cdDateLabel=new JLabel("Date of Rollover");//label
    JTextField cddateTextBox=new JTextField();//date when it rollsover
    
    JLabel dueDateLabel=new JLabel("Next Due Date");//label
    JTextField duedateTextBox=new JTextField();//date when payment due

    JLabel noteDateLabel=new JLabel("Notify Date");//label
    JTextField notedateTextBox=new JTextField();//date when notify

    JLabel amountDueLabel=new JLabel("Amount Due");//label
    JTextField amountDueTextField=new JTextField();//date when notify

    JTextField accountNumberTextBox=new JTextField();//this account number
    
    String[] accountTypes=StartProgram.getAccountTypes();//types of accounts
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes);//type of account

    JTextField ssTextBox=new JTextField();//ss input

    JTextField interestRateTextBox=new JTextField();//interest rate

    JCheckBox isBackup=new JCheckBox("Backup");
    JLabel backupLabel=new JLabel("Backup Account"); 
    JTextField backupTextField=new JTextField();//interest rate
    
    JTextField dateTextBox=new JTextField();//date opened
    JTextField amountTextBox=new JTextField();  
    
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public void open(Account acc,Boolean editable) {
        account=acc;
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// end program on exit

        JLabel Title = new JLabel("Account View");// Title
        Title.setBounds(130, 1, 100, 60);// x axis, y axis, width, height
        accountFrame.add(Title);// adding button in JFrame

        int sectionTop = 60;// where main section starts
        JLabel ssLabel = new JLabel("User SS");
        ssLabel.setBounds(30, sectionTop, 100, 40);// x axis, y axis, width, height
        accountFrame.add(ssLabel);// adding button in JFrame

        ssTextBox.setText(Integer.toString(account.getCustomerId()));
        ssTextBox.setBounds(130, sectionTop, 100, 40);// x axis, y axis, width, height
        accountFrame.add(ssTextBox);// adding button in JFrame

        JLabel accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setBounds(30, sectionTop + 50, 100, 40);// x axis, y axis, width, height
        accountFrame.add(accountTypeLabel);// adding button in JFrame
        
        accountTypeDrop.setSelectedIndex(StartProgram.convertToIndex(account.getType()));
        accountTypeDrop.setBounds(130, sectionTop+50, 100, 40);// x axis, y axis, width, height
        accountFrame.add(accountTypeDrop);// adding button in JFrame

        JLabel amountLabel=new JLabel("Balance");  
        amountLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountFrame.add(amountLabel);//adding button in JFrame

        //amount
        amountTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        amountTextBox.setText(Double.toString(account.getCurrentBalance()));
        accountFrame.add(amountTextBox);//adding button in JFrame 
        if(account.getType().equals("TMB")||account.getType().equals("Gold/Diamond")){
        isBackup.setSelected(
            ((CheckingAccount)account).getisBackedUp());
        }
        isBackup.setBounds(280,sectionTop+45,100, 40);
        accountFrame.add(isBackup);//add in JFrame
        isBackup.setVisible(false);

        //backup account label
        backupLabel.setBounds(280,sectionTop+70,100, 40);//x axis, y axis, width, height 
        accountFrame.add(backupLabel);//adding in JFrame
        backupLabel.setVisible(false);

        //backup account input
        backupTextField.setBounds(280,sectionTop+100,100, 40);
        accountFrame.add(backupTextField);
        backupTextField.setVisible(false);

        //cd rollover date label
        cdDateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountFrame.add(cdDateLabel);//adding button in JFrame
        cdDateLabel.setVisible(false);

        //cd rollover date text box
        cddateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountFrame.add(cddateTextBox);//adding button in JFrame 
        cddateTextBox.setVisible(false);
        
        //note date label
        noteDateLabel.setBounds(280,sectionTop+70,100, 40);//x axis, y axis, width, height 
        accountFrame.add(noteDateLabel);//adding button in JFrame
        noteDateLabel.setVisible(false);

        //note date text box
        notedateTextBox.setBounds(280,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountFrame.add(notedateTextBox);//adding button in JFrame 
        notedateTextBox.setVisible(false);

        //note date label
        amountDueLabel.setBounds(280,sectionTop+130,100, 40);//x axis, y axis, width, height 
        accountFrame.add(amountDueLabel);//adding button in JFrame
        amountDueLabel.setVisible(false);

        //note date label
        amountDueTextField.setBounds(280,sectionTop+160,100, 40);//x axis, y axis, width, height 
        accountFrame.add(amountDueTextField);//adding button in JFrame
        amountDueTextField.setVisible(false);

        //due date label
        dueDateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountFrame.add(dueDateLabel);//adding button in JFrame
        dueDateLabel.setVisible(false);

        //due date text box
        duedateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height
        if(account.getType().equals("Short Term")||account.getType().equals("Long Term")||account.getType().equals("Credit Card"))duedateTextBox.setText(formatter.format(((LoanAccount)account).getPaymentDueDate())); 
        accountFrame.add(duedateTextBox);//adding button in JFrame 
        duedateTextBox.setVisible(false);

        JLabel accountNumberLabel=new JLabel("Account #");  
        accountNumberLabel.setBounds(30,sectionTop+200,100, 40);//x axis, y axis, width, height 
        accountFrame.add(accountNumberLabel);//adding button in JFrame

        accountNumberTextBox.setText(Integer.toString(account.getAccountNumber()));
        accountNumberTextBox.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height 
        accountFrame.add(accountNumberTextBox);//adding button in JFrame

        JLabel interestRateLabel=new JLabel("interest Rate");  
        interestRateLabel.setBounds(30,sectionTop+250,100, 40);//x axis, y axis, width, height 
        accountFrame.add(interestRateLabel);//adding button in JFrame

        interestRateTextBox.setText(Double.toString(account.getInterestRate()));;
        interestRateTextBox.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height 
        accountFrame.add(interestRateTextBox);//adding button in JFrame

        JLabel dateLabel=new JLabel("Date Opened");  
        dateLabel.setBounds(30,sectionTop+300,100, 40);//x axis, y axis, width, height 
        accountFrame.add(dateLabel);//adding button in JFrame

        try {
            dateTextBox.setText(formatter.format(account.getDateOpened()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dateTextBox.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height 
        accountFrame.add(dateTextBox);//adding button in JFrame

        //button to submit
        doneButton.setBounds(130,sectionTop+350,100, 40);//x axis, y axis, width, height  
        accountFrame.add(doneButton);//adding button in JFrame
        doneButton.addActionListener(this);

        updateButton.setBounds(130,sectionTop+400,100, 40);//x axis, y axis, width, height  
        accountFrame.add(updateButton);//adding button in JFrame
        updateButton.addActionListener(this);

        if(account.getType().equals("CD")){
            cddateTextBox.setText(formatter.format(((CD)account).getRolloverDate()));
            cddateTextBox.setVisible(true);
            cdDateLabel.setVisible(true);
        }
        else if(account.getType().equals("TMB")||account.getType().equals("Gold/Diamond")){
            accountNumberLabel.setVisible(true);
            backupTextField.setVisible(true);
            backupLabel.setVisible(true);
            isBackup.setVisible(true);
        }
        else if(account.getType().equals("Short Term")||account.getType().equals("Long Term")||account.getType().equals("Credit Card")){
            dueDateLabel.setVisible(true);
            duedateTextBox.setVisible(true);
            noteDateLabel.setVisible(true);
            notedateTextBox.setVisible(true);
            amountDueLabel.setVisible(true);
            amountDueTextField.setVisible(true);
        }
        //deactivate for users
        if(!editable){
            duedateTextBox.setEnabled(false);
            isBackup.setEnabled(false);
            notedateTextBox.setEnabled(false);
            backupTextField.setEnabled(false);
            ssTextBox.setEnabled(false);
            accountTypeDrop.setEnabled(false);
            amountTextBox.setEnabled(false);
            cddateTextBox.setEnabled(false);
            interestRateTextBox.setEnabled(false);
            dateTextBox.setEnabled(false);
            accountNumberTextBox.setEnabled(false);
            updateButton.setVisible(false);
            amountDueTextField.setEnabled(false);
        }

        accountFrame.setSize(400,500);//400 width and 500 height  
        accountFrame.setLayout(null);//using no layout managers  
        accountFrame.setVisible(true);//making the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame errorFrame=new JFrame();//creating instance of JFrame
        if (updateButton.hasFocus()) {
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,"Updating Account Info");
            List<Account>overallAccounts=StartProgram.getAccountList();
            boolean inList=false;
            boolean isCD = accountTypeDrop.getSelectedItem().equals("CD");
            boolean isChecking = accountTypeDrop.getSelectedItem().equals("TMB")||accountTypeDrop.getSelectedItem().equals("Gold/Diamond");
            boolean isloan=accountTypeDrop.getSelectedItem().equals("Short Term")||accountTypeDrop.getSelectedItem().equals("Long Term")||accountTypeDrop.getSelectedItem().equals("Credit Card");           
            try {
                for (Account account : overallAccounts) {
                    if(account.getCustomerId()==Integer.parseInt(ssTextBox.getText())){
                        account.setCurrentBalance(Double.parseDouble(amountTextBox.getText()));
                        account.setInterestRate(Double.parseDouble(interestRateTextBox.getText()));
                        if(accountTypeDrop.getSelectedItem().equals("Savings")){
                            try {
                                    SavingsAccount save = (SavingsAccount)account;
                                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                    save.setAccountNumber(Integer.parseInt(accountNumberTextBox.getText()));
                                    save.setInterestRate(Double.parseDouble(interestRateTextBox.getText()));
                                    save.setDateOpened(formatter.parse(dateTextBox.getText()));
                                    StartProgram.WriteToEach();
                                    accountFrame.dispose();
                                    mainMenu menu= new mainMenu();
                                    menu.openMenu();                   
                            }catch (Exception ee) {
                            //TODO: handle exception
                            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                            JOptionPane.showMessageDialog(errorFrame,"Input Error for Saving account");
                            }
                        }
                        if(isCD){
                            try {
                                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                    account.setInterestRate(Double.parseDouble(interestRateTextBox.getText()));
                                    ((CD)account).setDateOpened(formatter.parse(dateTextBox.getText()));
                                    ((CD)account).setrolloverDate(formatter.parse(cddateTextBox.getText()));
                                    ((CD)account).setAccountNumber(Integer.parseInt(accountNumberTextBox.getText()));

                                    StartProgram.WriteToEach();
                                    accountFrame.dispose();
                                    mainMenu menu= new mainMenu();
                                    menu.openMenu();                   
                            }catch (Exception ee) {
                            //TODO: handle exception
                            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                            JOptionPane.showMessageDialog(errorFrame,"Imput Error for a CD account");
                        }
                    }
                        if(isChecking){
                            try {
                                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                    ((CheckingAccount)account).setAccountNumber(Integer.parseInt(accountNumberTextBox.getText()));
                                    ((CheckingAccount)account).setType(accountTypeDrop.getSelectedItem().toString());
                                    ((CheckingAccount)account).setisBackup((isBackup.isSelected()) ? true : false);
                                    ((CheckingAccount)account).setBackupAccountNumber(Integer.parseInt(backupTextField.getText()));
                                    ((CheckingAccount)account).setDateOpened(formatter.parse(dateTextBox.getText()));
                                    StartProgram.WriteToEach();
                                    accountFrame.dispose();
                                    mainMenu menu= new mainMenu();
                                    menu.openMenu();                   
                            }catch (Exception ee) {
                            //TODO: handle exception
                            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                            JOptionPane.showMessageDialog(errorFrame,"Input Error for Checking account");
                            }
                        }
                        if(isloan){
                            try {
                                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                ((LoanAccount)account).setInterestRate(Double.parseDouble(interestRateTextBox.getText()));
                                ((LoanAccount)account).setPaymentDueDate(formatter.parse(duedateTextBox.getText()));
                                ((LoanAccount)account).setPaymentNotificationDate(formatter.parse(notedateTextBox.getText()));
                                ((LoanAccount)account).setPaymentAmountDue(Double.parseDouble(amountDueLabel.getText()));
                                ((LoanAccount)account).setType(accountTypeDrop.getSelectedItem().toString());
                                ((LoanAccount)account).setMissedPayment(false); 
                                ((LoanAccount)account).setLastPaymentDate((isBackup.isSelected())?formatter.parse(duedateTextBox.getText()):formatter.parse(duedateTextBox.getText()));
                                StartProgram.WriteToEach();
                                accountFrame.dispose();
                                mainMenu menu= new mainMenu();
                                menu.openMenu();                   
                            }catch (Exception ee) {
                                //TODO: handle exception
                                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                                JOptionPane.showMessageDialog(errorFrame,"Input Error for a new loan account");
                            }
                        }           
                        inList=true;
                    }
                }
                if(!inList){
                    if(accountTypeDrop.getSelectedItem().equals("Savings")){
                        try {
                                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                accountList.add(new SavingsAccount(
                                    Integer.parseInt(ssTextBox.getText()), Integer.parseInt(accountNumberTextBox.getText()),
                                    Double.parseDouble(amountTextBox.getText()),Double.parseDouble(interestRateTextBox.getText()),
                                    formatter.parse(dateTextBox.getText())
                                    )
                                );
                                StartProgram.WriteToEach();
                                accountFrame.dispose();
                                mainMenu menu= new mainMenu();
                                menu.openMenu();                   
                        }catch (Exception ee) {
                        //TODO: handle exception
                        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                        JOptionPane.showMessageDialog(errorFrame,"Input Error for Saving account");
                        }
                    }
                    if(isCD){
                        try {
                                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                accountList.add(new CD(Integer.parseInt(ssTextBox.getText()),
                                Double.parseDouble(amountTextBox.getText()),Double.parseDouble(interestRateTextBox.getText()),
                                formatter.parse(dateTextBox.getText()),
                                formatter.parse(cddateTextBox.getText()),Integer.parseInt("100"))
                                );
                                StartProgram.WriteToEach();
                                accountFrame.dispose();
                                mainMenu menu= new mainMenu();
                                menu.openMenu();                   
                        }catch (Exception ee) {
                        //TODO: handle exception
                        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                        JOptionPane.showMessageDialog(errorFrame,"Imput Error for a CD account");
                    }
                }
                    if(isChecking){
                        try {
                                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                accountList.add(new CheckingAccount(Integer.parseInt(ssTextBox.getText()),
                                Integer.parseInt(accountNumberTextBox.getText()), accountTypeDrop.getSelectedItem().toString(),
                                Double.parseDouble(amountTextBox.getText()),((isBackup.isSelected()) ? true : false),
                                Integer.parseInt(backupTextField.getText()),0,formatter.parse(dateTextBox.getText()))
                                );
                                StartProgram.WriteToEach();
                                accountFrame.dispose();
                                mainMenu menu= new mainMenu();
                                menu.openMenu();                   
                        }catch (Exception ee) {
                        //TODO: handle exception
                        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                        JOptionPane.showMessageDialog(errorFrame,"Input Error for Checking account");
                        }
                    }
                    if(isloan){
                        try {
                                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                                accountList.add(
                                    new LoanAccount(Integer.parseInt(ssTextBox.getText()), Double.parseDouble(amountTextBox.getText()),
                                        Double.parseDouble(interestRateTextBox.getText()), formatter.parse(duedateTextBox.getText()),
                                        formatter.parse(notedateTextBox.getText()),Double.parseDouble(amountTextBox.getText())/780,
                                        accountTypeDrop.getSelectedItem().toString(),false, 
                                        ((isBackup.isSelected())?formatter.parse(duedateTextBox.getText()):formatter.parse(duedateTextBox.getText())
                                        )
                                    )
                                );
                                StartProgram.WriteToEach();
                                accountFrame.dispose();
                                mainMenu menu= new mainMenu();
                                menu.openMenu();                   
                        }catch (Exception ee) {
                        //TODO: handle exception
                        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                        JOptionPane.showMessageDialog(errorFrame,"Input Error for a new loan account");
                    }
                    }
                }
                accountFrame.dispose();
            }catch (Exception ee) {
            //handle exception
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,"Input Error");
            }    
        }
        if (doneButton.hasFocus()) {
            //System.out.println(ssTextBox.getText());
            try {
                StartProgram.WriteToEach();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(errorFrame,"Error updating");
            }
            mainMenu menu = new mainMenu();
            menu.openMenu();
        }

    }

    @Override
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnabled(boolean b) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub

    }
}