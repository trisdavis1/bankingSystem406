    package Menus;
    import java.awt.event.ActionEvent;
    import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Accounts.Account;
import MainProgram.StartProgram;  

    public class initManage implements Action{  
    List<Account> accountList;
    JFrame initTellerFrame=new JFrame();//creating instance of JFrame
    String[] accountTypes=StartProgram.getAccountTypes();
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes);//type of account
    JTextField ssTextBox=new JTextField(423453245);
    JButton userButton=new JButton("Edit User");//creating instance of JButton
    JButton intSetButton= new JButton("Set interest");//button for setting interest
    JButton billButton=new JButton("Send Bills");//creating instance of JButton
    JButton rolloverButton=new JButton("Rollover");//creating instance of JButton
    JButton doneButton=new JButton("Next");//creating instance of JButton

    public void open(List<Account> aL) { 
    accountList=aL; 
    initTellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
    int sectionTop=60;//where main section starts

    JLabel Title=new JLabel("Welcome Manager");//Title
    Title.setBounds(130,1,200, 60);//x axis, y axis, width, height 
    initTellerFrame.add(Title);//adding button in JFrame
    
    JLabel ssLabel=new JLabel("User SS");  
    ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
    initTellerFrame.add(ssLabel);//adding button in JFrame
    ssTextBox.setText("423453245");
    ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
    initTellerFrame.add(ssTextBox);//adding button in JFrame

    JLabel accountTypeLabel=new JLabel("Account Type");  
    accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
    initTellerFrame.add(accountTypeLabel);//adding button in JFrame

    accountTypeDrop.setSelectedIndex(0);
    accountTypeDrop.setBounds(130,sectionTop+50,140, 40);//x axis, y axis, width, height 
    initTellerFrame.add(accountTypeDrop);//adding button in JFrame 

    userButton.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height
    userButton.addActionListener(this);
    initTellerFrame.add(userButton);//adding button in JFrame

    billButton.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height
    billButton.addActionListener(this);
    initTellerFrame.add(billButton);//adding button in JFrame

    rolloverButton.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height
    rolloverButton.addActionListener(this);
    initTellerFrame.add(rolloverButton);//adding button in JFrame
    
    intSetButton.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height
    intSetButton.addActionListener(this);
    initTellerFrame.add(intSetButton);//adding button in JFrame

    doneButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
    doneButton.addActionListener(this);
    initTellerFrame.add(doneButton);//adding button in JFrame

    initTellerFrame.setSize(400,500);//400 width and 500 height  
    initTellerFrame.setLayout(null);//using no layout managers  
    initTellerFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //when Next is clicked get the user data
        // TODO pass the SS to data getting function
        if(intSetButton.hasFocus()){
            interstSet a=new interstSet();
            initTellerFrame.dispose();
            a.open(accountList);
        }
        else if(accountTypeDrop.getSelectedItem()=="Short Term Loan"||
            accountTypeDrop.getSelectedItem()=="Long Term Loan"||
            accountTypeDrop.getSelectedItem()=="Credit Card"){
                loanView a=new loanView();
                initTellerFrame.dispose();
                a.open(accountList,accountTypeDrop.getSelectedIndex());
        }
        else if(doneButton.hasFocus()){
            worDselect a=new worDselect();
            try {
                int index=accountTypeDrop.getSelectedIndex();
                String classboy=StartProgram.convertToClass(index);
                String ss=ssTextBox.getText();
                if(String.valueOf(ss).length()==9){
                    List<Account> CustAccounts=new ArrayList<Account>();
                    for (Account account : accountList) {
                        if(account.getCustomerId()==Integer.parseInt(ss)){
                            if(account.getType().equals(classboy)){
                                CustAccounts.add(account);
                            }
                        }
                    }
                    if(classboy.equals("none")){
                        JFrame errorFrame=new JFrame();//creating instance of JFrame
                        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                        JOptionPane.showMessageDialog(errorFrame,"Choose an account type");
                    }
                    else{
                        initTellerFrame.dispose();
                        a.open(CustAccounts); 
                    }
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
        else if(rolloverButton.hasFocus()){
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,"Sending Out Rollover Notices Now.");
        }
        else if(billButton.hasFocus()){
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,"Sending Out Bill Notices Now.");
        }
        if(userButton.hasFocus()){
            userView a=new userView();
            initTellerFrame.dispose();
            a.open(accountList,ssTextBox.getText(),true);
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