    package Menus;
    import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import Accounts.Account;
    public class transferTeller implements Action{  
        JFrame transferFrame=new JFrame();//creating instance of JFrame
        JButton CtoSButton=new JButton("Checking to Saving");//creating instance of JButton
        JButton StoCButton=new JButton("Saving to Checking");//creating instance of JButton
        JButton doneButton=new JButton("Done");//creating instance of JButton
        Account account;
    public void open(Account account){ 
        account=account;
        int sectionTop=60;//where main section starts
        transferFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        CtoSButton.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height
        CtoSButton.addActionListener(this);
        
        if(account.getType().equals("Checking"))
            transferFrame.add(CtoSButton);//adding button in JFrame

        StoCButton.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height
        StoCButton.addActionListener(this);
        if(account.getType().equals("Saving"))
            transferFrame.add(StoCButton);//adding button in JFrame

        doneButton.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height
        doneButton.addActionListener(this);
        transferFrame.add(doneButton);//adding button in JFrame

        transferFrame.setSize(400,500);//400 width and 500 height  
        transferFrame.setLayout(null);//using no layout managers  
        transferFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //decide if a withdraw or deposit
        if(CtoSButton.hasFocus()){
            amountTransfer a=new amountTransfer();
            transferFrame.dispose();
            a.open(account,0);
        }
        else if(StoCButton.hasFocus()){
            amountTransfer a=new amountTransfer();
            transferFrame.dispose();
            a.open(account,1);
        }
        else if(doneButton.hasFocus()){
            mainMenu a=new mainMenu();
            transferFrame.dispose();
            a.openMenu();
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