    package Menus;
    import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.*;

import Accounts.Account;
public class userView implements Action{ 
    List<Account>accountList; 
    JFrame userViewFrame=new JFrame();//creating instance of JFrame  
    JButton doneButton=new JButton("Done");//creating instance of JButton
    JButton submitButton=new JButton("Submit");//creating instance of JButton
    JLabel ssLabel=new JLabel("SS");  
    JTextField ssTextBox=new JTextField(123456789);
    public void open(List<Account>aL, int ss) { 
        accountList=aL; 
        String user[] = { "233435656", "1525 Kioam", "Ellwood", "KS", "56708", "Mary", "White" };
        
        userViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel Title=new JLabel("User View");  
        Title.setBounds(150,5,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(Title);//adding button in JFrame

        int sectionTop=50;
        
        ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(ssLabel);//adding button in JFrame

          
        ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(ssTextBox);//adding button in JFrame  
        
        JLabel streetLabel=new JLabel("Street Address");  
        streetLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(streetLabel);//adding button in JFrame

        JTextField streetTextBox=new JTextField(user[1]);  
        streetTextBox.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(streetTextBox);//adding button in JFrame  

        JLabel cityLabel=new JLabel("City");  
        cityLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(cityLabel);//adding button in JFrame

        JTextField cityTextBox=new JTextField(user[2]);  
        cityTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(cityTextBox);//adding button in JFrame  

        JLabel stateLabel=new JLabel("State");  
        stateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(stateLabel);//adding button in JFrame

        JTextField stateTextBox=new JTextField(user[3]);  
        stateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(stateTextBox);//adding button in JFrame  

        JLabel zipLabel=new JLabel("Zip");  
        zipLabel.setBounds(30,sectionTop+200,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(zipLabel);//adding button in JFrame

        JTextField zipTextBox=new JTextField(user[4]);  
        zipTextBox.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(zipTextBox);//adding button in JFrame  

        JLabel firstLabel=new JLabel("First Name");  
        firstLabel.setBounds(30,sectionTop+250,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(firstLabel);//adding button in JFrame

        JTextField firstTextBox=new JTextField(user[5]);  
        firstTextBox.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(firstTextBox);//adding button in JFrame  

        JLabel lastLabel=new JLabel("Last Name");  
        lastLabel.setBounds(30,sectionTop+300,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(lastLabel);//adding button in JFrame

        JTextField lastTextBox=new JTextField(user[6]);  
        lastTextBox.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(lastTextBox);//adding button in JFrame  
        
        submitButton.setBounds(50,sectionTop+350,100,40);//x axis, y axis, width, height
        userViewFrame.add(submitButton);//adding button in JFrame
        submitButton.addActionListener(this);
        
        doneButton.setBounds(200,sectionTop+350,100,40);//x axis, y axis, width, height
        userViewFrame.add(doneButton);//adding button in JFrame
        doneButton.addActionListener(this);

        userViewFrame.setSize(400,500);//400 width and 500 height  
        userViewFrame.setLayout(null);//using no layout managers  
        userViewFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(submitButton.hasFocus()){
            System.out.println(ssTextBox.getText());
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,"Updating User Info");
        }
        if(doneButton.hasFocus()){
            userViewFrame.dispose();
            Menu menu= new Menu();
            menu.openMenu();
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