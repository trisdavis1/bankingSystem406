    package Menus;
    import java.awt.event.ActionEvent;
    import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import Accounts.Account;  
    public class worDselect implements Action{  
    JFrame worDSelectFrame=new JFrame();//creating instance of JFrame
    JButton withdrawButton=new JButton("Withdraw");//creating instance of JButton
    JButton depositButton=new JButton("Deposit");//creating instance of JButton
    JButton viewButton=new JButton("View");//creating instance of JButton
    List<Account>accountList;

    public void open(List<Account>aL) {  
        accountList=aL;
        for (Account account : aL) {
            System.out.println(account.getCurrentBalance());
        }
        worDSelectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        int sectionTop=60;//where main section starts

        JLabel Title=new JLabel("Withdraw or Deposit");//Title
        Title.setBounds(130,1,200, 60);//x axis, y axis, width, height 
        worDSelectFrame.add(Title);

        withdrawButton.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height
        withdrawButton.addActionListener(this);
        worDSelectFrame.add(withdrawButton);//adding button in JFrame
        
        depositButton.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height
        depositButton.addActionListener(this);
        worDSelectFrame.add(depositButton);//adding button in JFrame

        viewButton.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height
        viewButton.addActionListener(this);
        worDSelectFrame.add(viewButton);//adding button in JFrame

        worDSelectFrame.setSize(400,500);//400 width and 500 height  
        worDSelectFrame.setLayout(null);//using no layout managers  
        worDSelectFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //decide if a withdraw or deposit
        if(withdrawButton.hasFocus()){
            amountSelect a=new amountSelect();
            worDSelectFrame.dispose();
            a.open(accountList,0);
        }
        else if(depositButton.hasFocus()){
            amountSelect a=new amountSelect();
            worDSelectFrame.dispose();
            a.open(accountList,1);
        }
        else if(viewButton.hasFocus()){
            accountView a=new accountView();
            worDSelectFrame.dispose();
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