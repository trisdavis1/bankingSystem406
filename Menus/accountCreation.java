package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;


import Accounts.Account;
import Accounts.SavingsAccount;
import MainProgram.StartProgram;
public class accountCreation implements Action{
    JFrame accountCreationFrame=new JFrame();//creating instance of JFrame for the window
    List<Account>a;
    JTextField cddateTextBox=new JTextField();//date when it rollsover
    JLabel cdDateLabel=new JLabel("Date of Rollover");//label for above
    String[] accountTypes=StartProgram.getAccountTypes();
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes);//type of account
    JTextField ssTextBox=new JTextField();
    JTextField interestRateTextBox=new JTextField();
    JTextField accountNumberTextBox=new JTextField();
    JTextField dateTextBox=new JTextField();
    JButton submitButton=new JButton("Submit");//creating instance of JButton
    JTextField amountTextBox=new JTextField(null);  
    public void open(String ss) { 
        accountCreationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit

        JLabel Title=new JLabel("Account Creation");//Title

        Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
        accountCreationFrame.add(Title);//adding button in JFrame
        
        int sectionTop=60;//where main section starts
        JLabel ssLabel=new JLabel("User SS");  
        ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(ssLabel);//adding button in JFrame
        //social security number 
        ssTextBox.setText(ss);
        ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(ssTextBox);//adding button in JFrame

        //choose account type
        JLabel accountTypeLabel=new JLabel("Account Type");  
        accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(accountTypeLabel);//adding button in JFrame

        accountTypeDrop.setSelectedIndex(0);     
        accountTypeDrop.addActionListener(this);
        accountTypeDrop.setBounds(130,sectionTop+50,140, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(accountTypeDrop);//adding button in JFrame 

        //input inital amount in account
        JLabel amountLabel=new JLabel("Inital Amount");  
        amountLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(amountLabel);//adding button in JFrame

        amountTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(amountTextBox);//adding button in JFrame  

        cdDateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(cdDateLabel);//adding button in JFrame
        cdDateLabel.setVisible(false);
        
        cddateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(cddateTextBox);//adding button in JFrame 
        cddateTextBox.setVisible(false);

        JLabel accountNumberLabel=new JLabel("Account #");  
        accountNumberLabel.setBounds(30,sectionTop+200,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(accountNumberLabel);//adding button in JFrame

        accountNumberTextBox.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(accountNumberTextBox);//adding button in JFrame

        JLabel interestRateLabel=new JLabel("interest Rate");  
        interestRateLabel.setBounds(30,sectionTop+250,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(interestRateLabel);//adding button in JFrame

        interestRateTextBox.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(interestRateTextBox);//adding button in JFrame

        JLabel dateLabel=new JLabel("Date Opened");  
        dateLabel.setBounds(30,sectionTop+300,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(dateLabel);//adding button in JFrame

        dateTextBox.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height 
        accountCreationFrame.add(dateTextBox);//adding button in JFrame

        //button to submit
        submitButton.setBounds(130,sectionTop+350,100, 40);//x axis, y axis, width, height  
        accountCreationFrame.add(submitButton);//adding button in JFrame
        submitButton.addActionListener(this);

        accountCreationFrame.setSize(400,500);//400 width and 500 height  
        accountCreationFrame.setLayout(null);//using no layout managers  
        accountCreationFrame.setVisible(true);//making the frame visible
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(accountTypeDrop.getSelectedIndex()==1){
            cddateTextBox.setVisible(true);
            cdDateLabel.setVisible(true);
        }
        if(accountTypeDrop.getSelectedIndex()!=1){
            cddateTextBox.setVisible(false);
            cdDateLabel.setVisible(false);
        }
        if(submitButton.hasFocus()){
            System.out.println(ssTextBox.getText());
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,"Updating User Info");
            List<Account>accountList=StartProgram.getAccountList();
            try {
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    accountList.add(new SavingsAccount(
                        Integer.parseInt(ssTextBox.getText()), Integer.parseInt(accountNumberTextBox.getText()),
                        Double.parseDouble(amountTextBox.getText()),Double.parseDouble(interestRateTextBox.getText()),
                        formatter.parse(dateTextBox.getText())
                        )
                    );
                    accountCreationFrame.dispose();
                    mainMenu menu= new mainMenu();
                    menu.openMenu();
                    
            }catch (Exception ee) {
                //TODO: handle exception
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                JOptionPane.showMessageDialog(errorFrame,"Input Error");
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
    