package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import Accounts.Account;
import MainProgram.StartProgram;  
    public class amountTransfer implements Action{  
    JFrame amountFrame=new JFrame();//creating instance of JFrame
    int wr=42;
    
    Account account;
    JComboBox<Integer> accountBox=new JComboBox<Integer>();//account drop down
    JTextField amountTextBox=new JTextField(null);//amount text box
    JButton transferButton=new JButton("Transfer");//creating instance of JButton
    JButton doneButton=new JButton("Done");//creating instance of JButton

    public void open(Account aL, int wOr) {  //withdraw or deposit
        account=aL;
        amountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        int sectionTop=60;//where main section starts
        List<Account>allaccounts=StartProgram.getAccountList();
        List<Account>otheraccountList= new ArrayList<Account>();//where to deposit the money

        wr=wOr;
        JLabel Title;
        if(wOr==0){
            Title=new JLabel("Checking to Saving");//Title
            for (Account otheraccount : allaccounts) {
                System.out.println(otheraccount.getType());
                if(otheraccount.getType().equals("Savings")&&
                    otheraccount.getCustomerId()==account.getCustomerId()){
                    otheraccountList.add(account);
                }
            }
        }
        else{
            Title=new JLabel("Saving to Checking");//Title
            for (Account otheraccount : allaccounts) {
                if((otheraccount.getType().equals("TMB")||
                        otheraccount.getType().equals("Gold/Diamond")
                        )&&otheraccount.getCustomerId()==account.getCustomerId()){
                    otheraccountList.add(otheraccount);    
                }
            }
        }
        for (Account account : otheraccountList) {
            System.out.println(otheraccountList.size());
            accountBox.addItem(account.getAccountNumber());
        }
        Title.setBounds(150,1,200, 60);//x axis, y axis, width, height 
        amountFrame.add(Title);

        JLabel amountLabel=new JLabel("Amount");  
        amountLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        amountFrame.add(amountLabel);//adding button in JFrame
  
        amountTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        amountFrame.add(amountTextBox);//adding button in JFrame  

        accountBox.setBounds(130,sectionTop+50,100, 40);
        amountFrame.add(accountBox);//adding button in JFrame

        transferButton.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height
        amountFrame.add(transferButton);//adding button in JFrame
        transferButton.addActionListener(this);

        doneButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
        amountFrame.add(doneButton);//adding button in JFrame
        doneButton.addActionListener(this);

        amountFrame.setSize(400,500);//400 width and 500 height  
        amountFrame.setLayout(null);//using no layout managers  
        amountFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String message="Error: Something is OwO ):";
        //decide what to pass
        if(doneButton.hasFocus()){
            try {
                StartProgram.WriteToEach();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                JOptionPane.showMessageDialog(errorFrame,"Updating");
            }
            amountFrame.dispose();
            try {
                StartProgram.WriteToEach();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                JOptionPane.showMessageDialog(errorFrame,"Updating");
            }
            mainMenu menu= new mainMenu();
            menu.openMenu();
        }
        else if(amountTextBox.getText().isEmpty())message="Amount is empty!";

        else if(wr==0 && !amountTextBox.getText().isEmpty()){
            //withdraw stuff
            message="trying to move $"+amountTextBox.getText()+" from checking to saving account";
        }
        else if(wr==1 && !amountTextBox.getText().isEmpty()){
            //deposit stuff
            message="trying to move $"+amountTextBox.getText()+" from saving to checking account";
        }
        if(!doneButton.hasFocus()){
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,message);
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