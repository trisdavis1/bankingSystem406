    package Menus;
    import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import Accounts.Account;  
public class accountTellerView implements Action{
    List<Account> accountList;
    JButton transferButton=new JButton("Transfer");//creating instance of JButton
    JButton withdrawButton=new JButton("Withdraw");//creating instance of JButton
    JButton depositButton=new JButton("Deposit");//creating instance of JButton
    JButton updateButton=new JButton("Update");//creating instance of JButton
    JButton doneButton=new JButton("Done");//creating instance of JButton
    JFrame accountTellerFrame=new JFrame();//creating instance of JFrame

    public void open(List<Account> aL) {
        accountList=aL;
        String User[]={"233435656","1525 Kioam","Ellwood","KS","56708","Mary","White"};
        accountTellerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        JLabel Title=new JLabel("Teller Account View");//Title
        Title.setBounds(130,1,200, 60);//x axis, y axis, width, height 
        accountTellerFrame.add(Title);//adding button in JFrame
        
        int sectionTop=60;//where main section starts
        JLabel ssLabel=new JLabel("SS");  
        ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(ssLabel);//adding button in JFrame

        JFormattedTextField ssTextBox=new JFormattedTextField(User[0]);
        ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(ssTextBox);//adding button in JFrame

        JLabel amountLabel=new JLabel("Amount");  
        amountLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(amountLabel);//adding button in JFrame

        JFormattedTextField amountTextBox=new JFormattedTextField(aL.get(0).currentBalance);  
        amountTextBox.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height 
        accountTellerFrame.add(amountTextBox);//adding button in JFrame  

        transferButton.setBounds(250,sectionTop,100, 40);//x axis, y axis, width, height  
        accountTellerFrame.add(transferButton);//adding button in JFrame
        transferButton.addActionListener(this);

        withdrawButton.setBounds(250,sectionTop+50,100, 40);//x axis, y axis, width, height  
        accountTellerFrame.add(withdrawButton);//adding button in JFrame
        withdrawButton.addActionListener(this);

        depositButton.setBounds(250,sectionTop+100,100, 40);//x axis, y axis, width, height  
        accountTellerFrame.add(depositButton);//adding button in JFrame
        depositButton.addActionListener(this);

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

        updateButton.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height  
        accountTellerFrame.add(updateButton);//adding button in JFrame
        updateButton.addActionListener(this);

        doneButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
        accountTellerFrame.add(doneButton);//adding button in JFrame
        doneButton.addActionListener(this);

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
        if(withdrawButton.hasFocus()){
            amountSelect a=new amountSelect();
            accountTellerFrame.dispose();
            a.open(accountList,0);
        }
        if(depositButton.hasFocus()){
            amountSelect a=new amountSelect();
            accountTellerFrame.dispose();
            a.open(accountList,1);
        }
        if (doneButton.hasFocus()) {
            accountTellerFrame.dispose();
            Menu menu = new Menu();
            menu.openMenu(accountList);
        }
        if (updateButton.hasFocus()) {
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,"Updating");
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