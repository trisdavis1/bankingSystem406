package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.*;
import Accounts.Account;
import MainProgram.StartProgram;  
public class CheckMenu implements Action{  
    Account account= new Account();
    JCheckBox stopPaymentCheck=new JCheckBox("Stop Payment");  
    JTextField accountNumberField=new JTextField();
    JTextField checkTextBox=new JTextField(null); 
    JTextField checkNumberBox=new JTextField(null);  
    JButton submitButton=new JButton("Submit");//creating instance of JButton
    JFrame checkFrame=new JFrame();//creating instance of JFrame 
    public void open(Account aL) {
        account=aL;
        checkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel Title=new JLabel("Check Input");
        Title.setBounds(150,0,100,20);//x axis, y axis, width, height 
        checkFrame.add(Title);//adding button in JFrame
        int sectionTop=30;      

        stopPaymentCheck.setBounds(130,sectionTop+150,150, 20);//x axis, y axis, width, height 
        checkFrame.add(stopPaymentCheck);//adding button in JFrame 

        JLabel checkNumberLabel=new JLabel("Check #");  
        checkNumberLabel.setBounds(60,sectionTop,100, 40);//x axis, y axis, width, height 
        checkFrame.add(checkNumberLabel);//adding button in JFrame

        checkTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        checkFrame.add(checkTextBox);//adding button in JFrame  

        JLabel amountLabel=new JLabel("Check Amount");  
        amountLabel.setBounds(30,sectionTop+50,90, 40);//x axis, y axis, width, height 
        checkFrame.add(amountLabel);//adding button in JFrame

        checkNumberBox.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height 
        checkFrame.add(checkNumberBox);//adding button in JFrame

        JLabel accountNumber=new JLabel("Account Number");  
        accountNumber.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        checkFrame.add(accountNumber);//adding button in JFrame
        accountNumberField.setText(Integer.toString(account.getAccountNumber()));
        accountNumberField.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountNumberField.setEnabled(false);
        checkFrame.add(accountNumberField);//adding button in JFrame

        submitButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height  
        checkFrame.add(submitButton);//adding button in JFrame
        submitButton.addActionListener(this);

        checkFrame.setSize(400,500);//400 width and 500 height  
        checkFrame.setLayout(null);//using no layout managers  
        checkFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(submitButton.hasFocus()){
            try {
                StartProgram.WriteToEach();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                JOptionPane.showMessageDialog(errorFrame,"Updating");
            }
            mainMenu menu= new mainMenu();
            checkFrame.dispose();
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