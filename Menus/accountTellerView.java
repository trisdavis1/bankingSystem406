    package Menus;
    import java.util.List;

import javax.swing.*;

import Accounts.Account;
import Accounts.LoanAccount;  

    public class accountTellerView {
        List<Account> accountList;
    public void open(List<Account> aL) {
        accountList=aL;
    JFrame accountFrame=new JFrame();//creating instance of JFrame  
    accountFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//end program on exit
    
    JLabel Title=new JLabel("Teller Account View");//Title
    Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
    accountFrame.add(Title);//adding button in JFrame
    
    int sectionTop=60;//where main section starts
    JLabel ssLabel=new JLabel("SS");  
    ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
    accountFrame.add(ssLabel);//adding button in JFrame

    System.out.print(aL.get(0).customerId);
    JFormattedTextField ssTextBox=new JFormattedTextField(aL.get(0).customerId);
    ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
    accountFrame.add(ssTextBox);//adding button in JFrame

    JLabel amountLabel=new JLabel("Amount");  
    amountLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
    accountFrame.add(amountLabel);//adding button in JFrame

    JFormattedTextField amountTextBox=new JFormattedTextField(aL.get(0).currentBalance);  
    amountTextBox.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height 
    accountFrame.add(amountTextBox);//adding button in JFrame  

    JLabel statusLabel=new JLabel("Status");  
    statusLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
    accountFrame.add(statusLabel);//adding button in JFrame

    JFormattedTextField statusTextBox=new JFormattedTextField(aL.get(0).status);  
    statusTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
    accountFrame.add(statusTextBox);//adding button in JFrame  

    JButton updateButton=new JButton("Update");//creating instance of JButton
    updateButton.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height  
    accountFrame.add(updateButton);//adding button in JFrame

    JButton doneButton=new JButton("Done");//creating instance of JButton
    doneButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
    accountFrame.dispose();
    accountFrame.add(doneButton);//adding button in JFrame

    accountFrame.setSize(400,500);//400 width and 500 height  
    accountFrame.setLayout(null);//using no layout managers  
    accountFrame.setVisible(true);//making the frame visible  
    }
}