    package Menus;
    import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import Accounts.Account;
import MainProgram.StartProgram;
    public class Menu implements Action{ 
        JFrame MenuFrame=new JFrame();//creating instance of JFrame
        JButton ATMButton=new JButton("ATM");//creating instance of JButton
        JButton tellerButton=new JButton("Teller");//creating instance of JButton
        JButton managerButton=new JButton("Manager");//creating instance of JButton
        List<Account> accountList;
    public void openMenu(){ 
        accountList=StartProgram.getAccountList();
        for (Account account : accountList) {
            if(account.getClass().toString().equals("class Accounts.CheckingAccount"))
            System.out.println("Balance: $"+account.getCurrentBalance());
        }
        int sectionTop=60;//where main section starts
        ATMButton.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height
        ATMButton.addActionListener(this);
        MenuFrame.add(ATMButton);//adding button in JFrame
        MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        
        tellerButton.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height
        tellerButton.addActionListener(this);
        MenuFrame.add(tellerButton);//adding button in JFrame

        managerButton.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height
        managerButton.addActionListener(this);
        MenuFrame.add(managerButton);//adding button in JFrame

        MenuFrame.setSize(400,500);//400 width and 500 height  
        MenuFrame.setLayout(null);//using no layout managers  
        MenuFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //decide if a withdraw or deposit
        if(ATMButton.hasFocus()){
            initATM a=new initATM();
            MenuFrame.dispose();
            a.open(accountList);
        }
        else if(tellerButton.hasFocus()){
            initTeller a=new initTeller();
            MenuFrame.dispose();
            a.open(accountList);
        }
        else if(managerButton.hasFocus()){
            initManage a=new initManage();
            MenuFrame.dispose();
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