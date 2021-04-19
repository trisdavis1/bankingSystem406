package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import Accounts.Account;
import Accounts.CD;
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
    JTextField amountTextBox=new JTextField();  
    
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    public void open(Account acc,Boolean editable) {
        account=acc;
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// end program on exit

        JLabel Title = new JLabel("Account View");// Title
        Title.setBounds(130, 1, 100, 60);// x axis, y axis, width, height
        accountFrame.add(Title);// adding button in JFrame

        int sectionTop = 60;// where main section starts
        JLabel ssLabel = new JLabel("Account Number");
        ssLabel.setBounds(30, sectionTop, 100, 40);// x axis, y axis, width, height
        accountFrame.add(ssLabel);// adding button in JFrame

        JTextField ssTextBox = new JTextField(Integer.toString(account.getCustomerId()));
        ssTextBox.setBounds(130, sectionTop, 100, 40);// x axis, y axis, width, height
        accountFrame.add(ssTextBox);// adding button in JFrame

        JLabel accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setBounds(30, sectionTop + 50, 100, 40);// x axis, y axis, width, height
        accountFrame.add(accountTypeLabel);// adding button in JFrame
        
        accountTypeDrop.setSelectedIndex(StartProgram.convertToIndex(account.getType()));
        accountTypeDrop.setBounds(130, sectionTop + 50, 160, 40);// x axis, y axis, width, height
        accountFrame.add(accountTypeDrop);// adding button in JFrame

        JLabel amountLabel=new JLabel("Balance");  
        amountLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountFrame.add(amountLabel);//adding button in JFrame

        //amount
        amountTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        amountTextBox.setText(Double.toString(account.getCurrentBalance()));
        accountFrame.add(amountTextBox);//adding button in JFrame 

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

        //account number label
        accountNumberLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountFrame.add(accountNumberLabel);//adding button in JFrame
        accountNumberLabel.setVisible(false);

        //account number input
        accNumberTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accNumberTextBox.setText(Integer.toString(StartProgram.getAccountList().size()));
        accountFrame.add(accNumberTextBox);//adding button in JFrame 
        accNumberTextBox.setVisible(false);

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

        //due date label
        dueDateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountFrame.add(dueDateLabel);//adding button in JFrame
        dueDateLabel.setVisible(false);

        //due date text box
        duedateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountFrame.add(duedateTextBox);//adding button in JFrame 
        duedateTextBox.setVisible(false);

        JLabel accountNumberLabel=new JLabel("Account #");  
        accountNumberLabel.setBounds(30,sectionTop+200,100, 40);//x axis, y axis, width, height 
        accountFrame.add(accountNumberLabel);//adding button in JFrame

        accountNumberTextBox.setText(Integer.toString(StartProgram.getAccountList().size()+1));
        accountNumberTextBox.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height 
        accountFrame.add(accountNumberTextBox);//adding button in JFrame

        JLabel interestRateLabel=new JLabel("interest Rate");  
        interestRateLabel.setBounds(30,sectionTop+250,100, 40);//x axis, y axis, width, height 
        accountFrame.add(interestRateLabel);//adding button in JFrame

        interestRateTextBox.setText(Double.toString(new Account().getInterestRate()));;
        interestRateTextBox.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height 
        accountFrame.add(interestRateTextBox);//adding button in JFrame

        JLabel dateLabel=new JLabel("Date Opened");  
        dateLabel.setBounds(30,sectionTop+300,100, 40);//x axis, y axis, width, height 
        accountFrame.add(dateLabel);//adding button in JFrame

        dateTextBox.setText("01/15/2020");//the date covid reached the US
        dateTextBox.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height 
        accountFrame.add(dateTextBox);//adding button in JFrame

        //button to submit
        doneButton.setBounds(130,sectionTop+350,100, 40);//x axis, y axis, width, height  
        accountFrame.add(doneButton);//adding button in JFrame
        doneButton.addActionListener(this);
        if(account.getType().equals("CD")){
            cddateTextBox.setText(formatter.format(((CD)account).getRolloverDate()));
            cddateTextBox.setVisible(true);
            cdDateLabel.setVisible(true);
        }
        else if(account.getType().equals("TMB")||account.getType().equals("Gold/Diamond")){
            accNumberTextBox.setText(Integer.toString(account.getAccountNumber()));
            accNumberTextBox.setVisible(true);
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
        }
        accountFrame.setSize(400,500);//400 width and 500 height  
        accountFrame.setLayout(null);//using no layout managers  
        accountFrame.setVisible(true);//making the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (updateButton.hasFocus()) {
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            //default title and icon
            JOptionPane.showMessageDialog(errorFrame,"Updating");
        }
        if (doneButton.hasFocus()) {
            try {
                StartProgram.WriteToEach();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                JOptionPane.showMessageDialog(errorFrame,"Updating");
            }
            
            accountFrame.dispose();
            try {
                StartProgram.WriteToEach();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                JOptionPane.showMessageDialog(errorFrame,"Updating");
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