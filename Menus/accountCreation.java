package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import Accounts.Account;
import Accounts.SavingsAccount;
import MainProgram.StartProgram;

public class accountCreation implements Action{
    JFrame accountCreationFrame=new JFrame();//creating instance of JFrame for the window
    JLabel cdDateLabel=new JLabel("Date of Rollover");//label
    JTextField cddateTextBox=new JTextField();//date when it rollsover
    
    JLabel dueDateLabel=new JLabel("Next Due Date");//label
    JTextField duedateTextBox=new JTextField();//date when payment due

    JLabel noteDateLabel=new JLabel("Notify Date");//label
    JTextField notedateTextBox=new JTextField();//date when notify

    JLabel accountNumberLabel=new JLabel("Account Number");//label for above
    JTextField accNumberTextBox=new JTextField();//account number

    String[] accountTypes=StartProgram.getAccountTypes();//types of accounts
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes);//type of account

    JTextField ssTextBox=new JTextField();//ss input

    JTextField interestRateTextBox=new JTextField();//interest rate

    JCheckBox isBackup=new JCheckBox("Backup");
    JLabel backupLabel=new JLabel("Backup Account"); 
    JTextField backupTextField=new JTextField();//interest rate

    JTextField accountNumberTextBox=new JTextField();//this account number

    JTextField dateTextBox=new JTextField();//date opened
     
    JButton submitButton=new JButton("Submit");//creating instance of JButton

    JTextField amountTextBox=new JTextField();  

    public void open(String ss) { 
        accountCreationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit

        JLabel Title=new JLabel("Account Creation");//Title

        Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
        accountCreationFrame.add(Title);//adding button in JFrame
        
        int sectionTop=60;//where main section starts
        JLabel ssLabel=new JLabel("User SS");  
        ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(ssLabel);//adding button in JFrame

        //social security number 
        ssTextBox.setText(ss);
        ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(ssTextBox);//adding button in JFrame

        //choose account type
        JLabel accountTypeLabel=new JLabel("Account Type");  
        accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(accountTypeLabel);//adding button in JFrame

        accountTypeDrop.setSelectedIndex(0);     
        accountTypeDrop.addActionListener(this);
        accountTypeDrop.setBounds(130,sectionTop+50,140, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(accountTypeDrop);//adding button in JFrame 

        //input inital amount in account
        JLabel amountLabel=new JLabel("Inital Amount");  
        amountLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(amountLabel);//adding button in JFrame

        //amount
        amountTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(amountTextBox);//adding button in JFrame 

        isBackup.setBounds(280,sectionTop+45,100, 40);
        accountCreationFrame.add(isBackup);//add in JFrame
        isBackup.setVisible(false);

        //backup account label
        backupLabel.setBounds(280,sectionTop+70,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(backupLabel);//adding in JFrame
        backupLabel.setVisible(false);

        //backup account input
        backupTextField.setBounds(280,sectionTop+100,100, 40);
        accountCreationFrame.add(backupTextField);
        backupTextField.setVisible(false);

        //account number label
        accountNumberLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(accountNumberLabel);//adding button in JFrame
        accountNumberLabel.setVisible(false);

        //account number input
        accNumberTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accNumberTextBox.setText(Integer.toString(StartProgram.getAccountList().size()));
        accountCreationFrame.add(accNumberTextBox);//adding button in JFrame 
        accNumberTextBox.setVisible(false);

        //cd rollover date label
        cdDateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(cdDateLabel);//adding button in JFrame
        cdDateLabel.setVisible(false);

        //cd rollover date text box
        cddateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(cddateTextBox);//adding button in JFrame 
        cddateTextBox.setVisible(false);
        
        //due date label
        noteDateLabel.setBounds(280,sectionTop+70,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(noteDateLabel);//adding button in JFrame
        noteDateLabel.setVisible(false);

        //due date text box
        notedateTextBox.setBounds(280,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(notedateTextBox);//adding button in JFrame 
        notedateTextBox.setVisible(false);

        //due date label
        dueDateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(dueDateLabel);//adding button in JFrame
        dueDateLabel.setVisible(false);

        //due date text box
        duedateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(duedateTextBox);//adding button in JFrame 
        duedateTextBox.setVisible(false);

        JLabel accountNumberLabel=new JLabel("Account #");  
        accountNumberLabel.setBounds(30,sectionTop+200,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(accountNumberLabel);//adding button in JFrame

        List<Account>accountList=new ArrayList<Account>();
        accountNumberTextBox.setText(Integer.toString(accountList.size()+1));
        accountNumberTextBox.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(accountNumberTextBox);//adding button in JFrame

        JLabel interestRateLabel=new JLabel("interest Rate");  
        interestRateLabel.setBounds(30,sectionTop+250,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(interestRateLabel);//adding button in JFrame

        interestRateTextBox.setText(Double.toString(new Account().getInterestRate()));;
        interestRateTextBox.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(interestRateTextBox);//adding button in JFrame

        JLabel dateLabel=new JLabel("Date Opened");  
        dateLabel.setBounds(30,sectionTop+300,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(dateLabel);//adding button in JFrame

        dateTextBox.setText("01/15/2020");//the date covid reached the US
        dateTextBox.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(dateTextBox);//adding button in JFrame

        //button to submit
        submitButton.setBounds(130,sectionTop+350,100, 40);//x axis, y axis, width, height  
        accountCreationFrame.add(submitButton);//adding button in JFrame
        submitButton.addActionListener(this);

        accountCreationFrame.setSize(400,500);//400 width and 500 height  
        accountCreationFrame.setLayout(null);//using no layout managers  
        accountCreationFrame.setVisible(true);//making the frame visible
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        boolean isCD = accountTypeDrop.getSelectedItem().equals("CD");
        boolean isChecking = accountTypeDrop.getSelectedItem().equals("TMB")||accountTypeDrop.getSelectedItem().equals("Gold/Diamond");
        boolean isloan=accountTypeDrop.getSelectedItem().equals("Short Term")||accountTypeDrop.getSelectedItem().equals("Long Term")||accountTypeDrop.getSelectedItem().equals("Credit Card");       
        if(isCD){
            cddateTextBox.setVisible(true);
            cdDateLabel.setVisible(true);
        }
        else if(isChecking){
            accNumberTextBox.setVisible(true);
            accountNumberLabel.setVisible(true);
            backupTextField.setVisible(true);
            backupLabel.setVisible(true);
            isBackup.setVisible(true);
        }
        else if(isloan){
            dueDateLabel.setVisible(true);
            duedateTextBox.setVisible(true);
            noteDateLabel.setVisible(true);
            notedateTextBox.setVisible(true);
        }
        if(!isCD){
            cddateTextBox.setVisible(false);
            cdDateLabel.setVisible(false);
        }
        if(!isChecking){
            accNumberTextBox.setVisible(false);
            accountNumberLabel.setVisible(false);
            backupTextField.setVisible(false);
            backupLabel.setVisible(false);
            isBackup.setVisible(false);
        }
        if(!isloan){
            dueDateLabel.setVisible(false);
            duedateTextBox.setVisible(false);
            noteDateLabel.setVisible(false);
            notedateTextBox.setVisible(false);
        }
        if(submitButton.hasFocus()){
            //System.out.println(ssTextBox.getText());
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,"Updating User Info");
            List<Account>accountList=StartProgram.getAccountList();
            if(accountTypeDrop.getSelectedItem().equals("Saving")){
                try {
                        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                        accountList.add(new SavingsAccount(
                            Integer.parseInt(ssTextBox.getText()), Integer.parseInt(accountNumberTextBox.getText()),
                            Double.parseDouble(amountTextBox.getText()),Double.parseDouble(interestRateTextBox.getText()),
                            formatter.parse(dateTextBox.getText())
                            )
                        );
                        StartProgram.WriteToEach();
                        accountCreationFrame.dispose();
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
                        accountList.add(new SavingsAccount(
                            Integer.parseInt(ssTextBox.getText()), Integer.parseInt(accountNumberTextBox.getText()),
                            Double.parseDouble(amountTextBox.getText()),Double.parseDouble(interestRateTextBox.getText()),
                            formatter.parse(dateTextBox.getText())
                            )
                        );
                        StartProgram.WriteToEach();
                        accountCreationFrame.dispose();
                        mainMenu menu= new mainMenu();
                        menu.openMenu();                   
                }catch (Exception ee) {
                //TODO: handle exception
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                JOptionPane.showMessageDialog(errorFrame,"Input Error for CD account");
            }
            }
            if(isChecking){
                try {
                        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                        accountList.add(new SavingsAccount(
                            Integer.parseInt(ssTextBox.getText()), Integer.parseInt(accountNumberTextBox.getText()),
                            Double.parseDouble(amountTextBox.getText()),Double.parseDouble(interestRateTextBox.getText()),
                            formatter.parse(dateTextBox.getText())
                            )
                        );
                        StartProgram.WriteToEach();
                        accountCreationFrame.dispose();
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
                        accountList.add(new SavingsAccount(
                            Integer.parseInt(ssTextBox.getText()), Integer.parseInt(accountNumberTextBox.getText()),
                            Double.parseDouble(amountTextBox.getText()),Double.parseDouble(interestRateTextBox.getText()),
                            formatter.parse(dateTextBox.getText())
                            )
                        );
                        StartProgram.WriteToEach();
                        accountCreationFrame.dispose();
                        mainMenu menu= new mainMenu();
                        menu.openMenu();                   
                }catch (Exception ee) {
                //TODO: handle exception
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                JOptionPane.showMessageDialog(errorFrame,"Input Error for a new loan account");
            }
            }

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
    