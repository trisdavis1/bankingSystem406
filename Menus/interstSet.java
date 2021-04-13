    package Menus;
    import java.awt.event.ActionEvent;
    import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import Accounts.Account;  
    public class interstSet implements Action{  
    JFrame amountFrame=new JFrame();//creating instance of JFrame
    int wr=42;
    JFormattedTextField amountTextBox=new JFormattedTextField();//amount text box
    JButton doneButton=new JButton("Set");//creating instance of JButton
    List<Account>accountList;

    public void open(List<Account>aL) {
        amountTextBox.setValue(aL.get(0).interestRate);
        accountList=aL;
        amountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        int sectionTop=60;//where main section starts
        JLabel Title;
        Title=new JLabel("Set Interest");//Title
        Title.setBounds(150,1,200, 60);//x axis, y axis, width, height 
        amountFrame.add(Title);

        JLabel amountLabel=new JLabel("Amount");  
        amountLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        amountFrame.add(amountLabel);//adding button in JFrame
  
        amountTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        amountFrame.add(amountTextBox);//adding button in JFrame  

        doneButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
        amountFrame.add(doneButton);//adding button in JFrame
        doneButton.addActionListener(this);

        amountFrame.setSize(400,500);//400 width and 500 height  
        amountFrame.setLayout(null);//using no layout managers  
        amountFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //decide what to pass
        if(doneButton.hasFocus()){
            for (Account acc : accountList) {
                acc.interestRate=(double)amountTextBox.getValue();
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