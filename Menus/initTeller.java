    package Menus;
    import java.awt.event.ActionEvent;
    import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Accounts.Account;
import MainProgram.StartProgram;  

public class initTeller implements Action{  
    List<Account> accountList;
    JFrame initTellerFrame=new JFrame();//creating instance of JFrame
    String[] accountTypes=StartProgram.getAccountTypes();
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes);//type of account
    JTextField ssTextBox=new JTextField(423453245);
    JButton doneButton=new JButton("Next");//creating instance of JButton
    JButton userEditButton=new JButton("Edit User");//creating instance of JButton
    JButton userCreateButton=new JButton("New User");//creating instance of JButton
    JButton accountCreateButton=new JButton("New \nAccount");//creating instance of JButton
    
    public void open(List<Account> aL) { 
        accountList=aL; 
        initTellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        int sectionTop=60;//where main section starts

        JLabel Title=new JLabel("Welcome Teller");//Title
        Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
        initTellerFrame.add(Title);//adding button in JFrame
        
        JLabel ssLabel=new JLabel("User SS");  
        ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        initTellerFrame.add(ssLabel);//adding button in JFrame
        
        ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height
        ssTextBox.setText("423453245");
        initTellerFrame.add(ssTextBox);//adding button in JFrame

        JLabel accountTypeLabel=new JLabel("Account Type");  
        accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
        initTellerFrame.add(accountTypeLabel);//adding button in JFrame

        accountTypeDrop.setSelectedIndex(0);
        accountTypeDrop.setBounds(130,sectionTop+50,140, 40);//x axis, y axis, width, height 
        initTellerFrame.add(accountTypeDrop);//adding button in JFrame 

        accountCreateButton.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height
        accountCreateButton.addActionListener(this);
        initTellerFrame.add(accountCreateButton);//adding button in JFrame

        userCreateButton.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height
        userCreateButton.addActionListener(this);
        initTellerFrame.add(userCreateButton);//adding button in JFrame

        userEditButton.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height
        userEditButton.addActionListener(this);
        initTellerFrame.add(userEditButton);//adding button in JFrame
        
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
        if(doneButton.hasFocus()){
            try {
                String ss=ssTextBox.getText();
                accountTellerView a=new accountTellerView();
                String classType=StartProgram.convertToClass(accountTypeDrop.getSelectedIndex());
                if(String.valueOf(ss).length()==9){
                    List<Account> CustAccounts;
                    CustAccounts=new ArrayList<Account>();
                    
                    for (Account account : accountList) {
                        if(account.getCustomerId()==Integer.parseInt(ss)){
                            System.out.println(classType+" "+account.getType());
                            if(classType.equals(account.getType())){
                                CustAccounts.add(account);
                                System.out.println("Type: "+account.getType());
                            }
                        }
                    }  
                    if(classType.equals("none")){
                        JFrame errorFrame=new JFrame();//creating instance of JFrame
                        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                        //default title and icon
                        JOptionPane.showMessageDialog(errorFrame,"Choose an account type");
                    }
                    else if(CustAccounts.size()==0){
                        JFrame errorFrame=new JFrame();//creating instance of JFrame
                        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                        //default title and icon
                        JOptionPane.showMessageDialog(errorFrame,"They don't have type of account");}
                    else{
                        System.out.println();
                        a.open(CustAccounts,ssTextBox.getText(),0);
                        initTellerFrame.dispose();
                    }
                }
            }catch (Exception ee) {
                //TODO: handle exception
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                //default title and icon
                JOptionPane.showMessageDialog(errorFrame,"Incorrect SS or no account of that type");
            }
        }
        else if(userEditButton.hasFocus()){
            try {
                userView a=new userView();
                a.open(accountList,ssTextBox.getText(),true);
                initTellerFrame.dispose();
            }catch (Exception ee) {
                //exception
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                //default title and icon
                JOptionPane.showMessageDialog(errorFrame,"Can't do anything without a SS number!");
            }
        }
        else if(userCreateButton.hasFocus()){
            try {
                userCreation a=new userCreation();
                a.open(ssTextBox.getText());
                initTellerFrame.dispose();
            } catch (Exception ee) {
                //handle exception
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                //default title and icon
                JOptionPane.showMessageDialog(errorFrame,"Can't do anything without a SS number!");
            }
        }
        else if(accountCreateButton.hasFocus()){
            try {
                accountCreation a=new accountCreation();
                a.open(ssTextBox.getText());
                initTellerFrame.dispose();
            } catch (Exception ee) {
                //handle exception
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                //default title and icon
                JOptionPane.showMessageDialog(errorFrame,"Can't do anything without a SS number!");
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