    package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
    public class accountCreation implements Action{
        JFrame Frame=new JFrame();//creating instance of JFrame for the window

        JTextField cddateTextBox=new JTextField(null);//date when it rollsover
        JLabel cdDateLabel=new JLabel("Date of Rollover");//label for above

        String[] accountTypes={"None","Certificate of Deposit","Short Term Loan","Long Term Loan","Credit Card","Checking","Savings","This is My Bank"};
        JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes);//type of account

    public void open() { 
        Frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//end program on exit

        JLabel Title=new JLabel("Account Creation");//Title

        

        Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
        Frame.add(Title);//adding button in JFrame
        
        int sectionTop=60;//where main section starts
        JLabel ssLabel=new JLabel("User SS");  
        ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        Frame.add(ssLabel);//adding button in JFrame
        //social security number 
        JTextField ssTextBox=new JTextField(null);
        ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        Frame.add(ssTextBox);//adding button in JFrame

        //choose account type
        JLabel accountTypeLabel=new JLabel("Account Type");  
        accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
        Frame.add(accountTypeLabel);//adding button in JFrame


        accountTypeDrop.setSelectedIndex(0);     
        accountTypeDrop.addActionListener(this);
        accountTypeDrop.setBounds(130,sectionTop+50,140, 40);//x axis, y axis, width, height 
        Frame.add(accountTypeDrop);//adding button in JFrame 

        //input inital amount in account
        JLabel amountLabel=new JLabel("Inital Amount");  
        amountLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        Frame.add(amountLabel);//adding button in JFrame

        JTextField amountTextBox=new JTextField(null);  
        amountTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        Frame.add(amountTextBox);//adding button in JFrame  

        cdDateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        Frame.add(cdDateLabel);//adding button in JFrame
        cdDateLabel.setVisible(false);

        
        cddateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        Frame.add(cddateTextBox);//adding button in JFrame 
        cddateTextBox.setVisible(false);

        //button to submit
        JButton submitButton=new JButton("Submit");//creating instance of JButton
        submitButton.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height  
        Frame.add(submitButton);//adding button in JFrame

        Frame.setSize(400,500);//400 width and 500 height  
        Frame.setLayout(null);//using no layout managers  
        Frame.setVisible(true);//making the frame visible
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
    