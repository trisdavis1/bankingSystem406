    package Menus;
    import java.awt.event.ActionEvent;
    import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import Accounts.Account;  

    public class initManage implements Action{  
    List<Account> accountList;
    JFrame initTellerFrame=new JFrame();//creating instance of JFrame
    String[] accountTypes={"None","Certificate of Deposit","Short Term Loan","Long Term Loan","Credit Card","Checking","Savings","This is My Bank"};
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes);//type of account
    JButton intSetButton= new JButton("Set interest");//button for setting interest
    JButton doneButton=new JButton("Next");//creating instance of JButton

    public void open(List<Account> aL) { 
    accountList=aL; 
    initTellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
    int sectionTop=60;//where main section starts

    JLabel Title=new JLabel("Welcome Manager");//Title
    Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
    initTellerFrame.add(Title);//adding button in JFrame
    
    JLabel ssLabel=new JLabel("User SS");  
    ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
    initTellerFrame.add(ssLabel);//adding button in JFrame
    
    JFormattedTextField ssTextBox=new JFormattedTextField(123456789);
    ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
    initTellerFrame.add(ssTextBox);//adding button in JFrame

    JLabel accountTypeLabel=new JLabel("Account Type");  
    accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
    initTellerFrame.add(accountTypeLabel);//adding button in JFrame

    accountTypeDrop.setSelectedIndex(0);
    accountTypeDrop.setBounds(130,sectionTop+50,140, 40);//x axis, y axis, width, height 
    initTellerFrame.add(accountTypeDrop);//adding button in JFrame 

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
        if(doneButton.hasFocus()){
            accountView a=new accountView();
            initTellerFrame.dispose();
            a.open(accountList);
        }
        if(intSetButton.hasFocus()){
            interstSet a=new interstSet();
            initTellerFrame.dispose();
            a.open(accountList);
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