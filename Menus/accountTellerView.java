    package Menus;
    import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import Accounts.Account;  
public class accountTellerView implements Action{
    List<Account> accountList;
    JButton transferButton=new JButton("Transfer");//creating instance of JButton
    JFrame accountTellerFrame=new JFrame();//creating instance of JFrame

    public void open(List<Account> aL) {
        accountList=aL;
        accountTellerFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//end program on exit
        JLabel Title=new JLabel("Teller Account View");//Title
        Title.setBounds(130,1,200, 60);//x axis, y axis, width, height 
        accountTellerFrame.add(Title);//adding button in JFrame
        
        int sectionTop=60;//where main section starts
        JLabel ssLabel=new JLabel("SS");  
        ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(ssLabel);//adding button in JFrame

        System.out.print(aL.get(0).customerId);
        JFormattedTextField ssTextBox=new JFormattedTextField(aL.get(0).customerId);
        ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(ssTextBox);//adding button in JFrame

        JLabel amountLabel=new JLabel("Amount");  
        amountLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(amountLabel);//adding button in JFrame

        JFormattedTextField amountTextBox=new JFormattedTextField(aL.get(0).currentBalance);  
        amountTextBox.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(amountTextBox);//adding button in JFrame  

        transferButton.setBounds(250,sectionTop+50,100, 40);//x axis, y axis, width, height  
        accountTellerFrame.add(transferButton);//adding button in JFrame
        transferButton.addActionListener(this);

        JLabel statusLabel=new JLabel("Status");  
        statusLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(statusLabel);//adding button in JFrame

        JFormattedTextField statusTextBox=new JFormattedTextField(aL.get(0).status);  
        statusTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(statusTextBox);//adding button in JFrame  

        String[] columnNames = {"Date","C/D","Amount", "Honored"};
        Object[][] data = {
            {"1-30-2021", "C",34565, false},
            {"1-25-2021", "C",343256, true},
            {"1-24-2021", "D",32453, false},
            {"1-21-2021", "C",20, true},
            {"1-17-2021", "D",45410, false}
        };
        JTable recentTable=new JTable(data,columnNames);
        JScrollPane scrollPane = new JScrollPane(recentTable);
        scrollPane.setBounds(10,sectionTop+150,350, 80);//x axis, y axis, width, height 
        recentTable.setFillsViewportHeight(true); 
        accountTellerFrame.add(scrollPane);//adding pane in JFrame

        JButton updateButton=new JButton("Update");//creating instance of JButton
        updateButton.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height  
        accountTellerFrame.add(updateButton);//adding button in JFrame

        JButton doneButton=new JButton("Done");//creating instance of JButton
        doneButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
        accountTellerFrame.dispose();
        accountTellerFrame.add(doneButton);//adding button in JFrame

        accountTellerFrame.setSize(400,500);//400 width and 500 height  
        accountTellerFrame.setLayout(null);//using no layout managers  
        accountTellerFrame.setVisible(true);//making the frame visible  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(transferButton.hasFocus()){
            transferTeller a=new transferTeller();
            accountTellerFrame.dispose();;
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