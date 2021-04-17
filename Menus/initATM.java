package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import Accounts.Account;

import javax.swing.*;  
    public class initATM implements Action{  
    JFrame initATMFrame=new JFrame();//creating instance of JFrame
    JButton userButton=new JButton("Edit User");
    JButton doneButton=new JButton("Next");//creating instance of JButton
    JTextField ssTextBox=new JTextField();
    List<Account> accountList;

    public void open(List<Account> aL) { 
        accountList=aL; 
        initATMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        int sectionTop=60;//where main section starts

        JLabel Title=new JLabel("Welcome to the ATM");//Title
        Title.setBounds(130,1,200, 60);//x axis, y axis, width, height 
        initATMFrame.add(Title);//adding button in JFrame
        
        JLabel ssLabel=new JLabel("User SS");  
        ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        initATMFrame.add(ssLabel);//adding button in JFrame
        
        ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        ssTextBox.setText("423453245");
        initATMFrame.add(ssTextBox);//adding button in JFrame

        doneButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
        doneButton.addActionListener(this);
        initATMFrame.add(doneButton);//adding button in JFrame

        userButton.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height
        userButton.addActionListener(this);
        initATMFrame.add(userButton);//adding button in JFrame

        initATMFrame.setSize(400,500);//400 width and 500 height  
        initATMFrame.setLayout(null);//using no layout managers  
        initATMFrame.setVisible(true);//making the frame visible
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //when Next is clicked get the user data
        // TODO pass the SS to data getting function
        if(doneButton.hasFocus()){
           accountSelection a=new accountSelection();
            try {
                String ss=ssTextBox.getText();
                if(String.valueOf(ss).length()==9){
                    List<Account> CustAccounts=new ArrayList<Account>();
                    for (Account account : accountList) {
                        if(account.getCustomerId()==Integer.parseInt(ss))
                            {CustAccounts.add(account);
                        }
                    }  
                    a.open(ss,CustAccounts); 
                    initATMFrame.dispose();
                }
                else{
                    JFrame errorFrame=new JFrame();//creating instance of JFrame
                    errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                    //default title and icon
                    JOptionPane.showMessageDialog(errorFrame,"To Incorrect number of Digits. Re-enter SS");
                }
               

            } catch (Exception ee) {
                //TODO: handle exception
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                //default title and icon
                JOptionPane.showMessageDialog(errorFrame,ee);
            }
        }
        if(userButton.hasFocus()){
            try {
                userView a=new userView();
                a.open(accountList,ssTextBox.getText());
                initATMFrame.dispose();
            } catch (Exception ee) {
                //TODO: handle exception
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                //default title and icon
                JOptionPane.showMessageDialog(errorFrame,"Error in SS input!");
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