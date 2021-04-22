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
    JFrame initManagerFrame=new JFrame();//creating instance of JFrame
    String[] accountTypes=StartProgram.getAccountTypes();
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes);//type of account
    JTextField ssTextBox=new JTextField(000000000);
    JButton userButton=new JButton("Edit User");//creating instance of JButton
    JButton intSetButton= new JButton("Set interest");//button for setting interest
    JButton billButton=new JButton("Send Bills");//creating instance of JButton
    JButton rolloverButton=new JButton("Rollover");//creating instance of JButton
    JButton nextButton=new JButton("Next");//creating instance of JButton
    JButton menuButton=new JButton("Menu");//creating instance of JButton
    public void open(List<Account> aL) { 
    accountList=aL; 
    initManagerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
    int sectionTop=60;//where main section starts

    JLabel Title=new JLabel("Welcome Manager");//Title
    Title.setBounds(130,1,200, 60);//x axis, y axis, width, height 
    initManagerFrame.add(Title);//adding button in JFrame
    
    JLabel ssLabel=new JLabel("User SS");  
    ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
    initManagerFrame.add(ssLabel);//adding button in JFrame
    ssTextBox.setText("000000000");
    ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
    initManagerFrame.add(ssTextBox);//adding button in JFrame

    JLabel accountTypeLabel=new JLabel("Account Type");  
    accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
    initManagerFrame.add(accountTypeLabel);//adding button in JFrame

    accountTypeDrop.setSelectedIndex(0);
    accountTypeDrop.setBounds(130,sectionTop+50,140, 40);//x axis, y axis, width, height 
    initManagerFrame.add(accountTypeDrop);//adding button in JFrame 

    userButton.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height
    userButton.addActionListener(this);
    initManagerFrame.add(userButton);//adding button in JFrame

    billButton.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height
    billButton.addActionListener(this);
    initManagerFrame.add(billButton);//adding button in JFrame

    rolloverButton.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height
    rolloverButton.addActionListener(this);
    initManagerFrame.add(rolloverButton);//adding button in JFrame
    
    intSetButton.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height
    intSetButton.addActionListener(this);
    initManagerFrame.add(intSetButton);//adding button in JFrame

    nextButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
    nextButton.addActionListener(this);
    initManagerFrame.add(nextButton);//adding button in JFrame

    menuButton.setBounds(130,sectionTop+350,100, 40);//x axis, y axis, width, height
    menuButton.addActionListener(this);
    initManagerFrame.add(menuButton);//adding button in JFrame

    initManagerFrame.setSize(400,500);//400 width and 500 height  
    initManagerFrame.setLayout(null);//using no layout managers  
    initManagerFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //when Next is clicked get the user data
        // TODO pass the SS to data getting function
        if(menuButton.hasFocus()){
            mainMenu menu= new mainMenu();
            menu.openMenu();
            initManagerFrame.dispose();
        }
        if(intSetButton.hasFocus()){
            interstSet a=new interstSet();
            initManagerFrame.dispose();
            a.open(accountList);
        }
        else if(accountTypeDrop.getSelectedItem()=="Short Term"||
            accountTypeDrop.getSelectedItem()=="Long Term"||
            accountTypeDrop.getSelectedItem()=="Credit Card"){
                loanView a=new loanView();
                initManagerFrame.dispose();
                a.open(accountList,accountTypeDrop.getSelectedIndex());
                int index=accountTypeDrop.getSelectedIndex();
                String accountClass=StartProgram.convertToClass(index);
                List<Account> CustAccounts=new ArrayList<Account>();
                for (Account account : accountList){
                    //System.out.println(accountClass+" "+account.getType());
                    if(accountClass.equals(account.getType()))
                    {
                        CustAccounts.add(account);
                        //System.out.println(account.getClass().toString());
                    }
                }
                if(accountClass.equals("none")){
                    JFrame errorFrame=new JFrame();//creating instance of JFrame
                    errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                    //default title and icon
                    JOptionPane.showMessageDialog(errorFrame,"Choose an account type");
                }
                else if(CustAccounts.size()==0){
                    JFrame errorFrame=new JFrame();//creating instance of JFrame
                    errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                    //default title and icon
                    JOptionPane.showMessageDialog(errorFrame,"You don't have type of account");}
                else{
                    initManagerFrame.dispose();
                    a.open(CustAccounts,index); 
                }  
        }
        else if(nextButton.hasFocus()){
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
                    else if(CustAccounts.size()==0){
                        JFrame errorFrame=new JFrame();//creating instance of JFrame
                        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                        //default title and icon
                        JOptionPane.showMessageDialog(errorFrame,"They don't have type of account");}
                    else{
                        System.out.println();
                        initManagerFrame.dispose();
                        a.open(CustAccounts,true);
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
            initManagerFrame.dispose();
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