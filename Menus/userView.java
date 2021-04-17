package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;
import javax.swing.*;

import Accounts.ATMuser;
import Accounts.Account;
import Accounts.User;
import MainProgram.StartProgram;

public class userView implements Action{ 
    List<User>userList;
    JFrame userViewFrame=new JFrame();//creating instance of JFrame  
    JButton doneButton=new JButton("Done");//creating instance of JButton
    JButton submitButton=new JButton("Submit");//creating instance of JButton
    JLabel ssLabel=new JLabel("SS");  
    JTextField ssTextBox=new JTextField(423453245);
    JTextField lastTextBox=new JTextField(); 
    JTextField streetTextBox=new JTextField();  
    JTextField cityTextBox=new JTextField();
    JTextField firstTextBox=new JTextField();
    JTextField stateTextBox=new JTextField();  
    JTextField zipTextBox=new JTextField();

    public void open(List<Account>aL, String ss,boolean isWorker) { 
        
        userList=StartProgram.getUserList();
        User userInfo=userList.get(0);
        for (User user : userList) {
            if(Integer.toString(user.getCustomerId()).equals(ss))
                userInfo=user;
        }
        userViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel Title=new JLabel("User View");  
        Title.setBounds(150,5,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(Title);//adding button in JFrame

        int sectionTop=50;
        
        ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(ssLabel);//adding button in JFrame
        ssTextBox.setText(Integer.toString(userInfo.getCustomerId()));
        ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(ssTextBox);//adding button in JFrame  
        if(!isWorker)ssTextBox.setEnabled(false);

        JLabel streetLabel=new JLabel("Address");  
        streetLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(streetLabel);//adding button in JFrame

        streetTextBox.setText(userInfo.getAddress());
        streetTextBox.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(streetTextBox);//adding button in JFrame  

        JLabel cityLabel=new JLabel("City");  
        cityLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(cityLabel);//adding button in JFrame

        cityTextBox.setText(userInfo.getCity());
        cityTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(cityTextBox);//adding button in JFrame  

        JLabel stateLabel=new JLabel("State");  
        stateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(stateLabel);//adding button in JFrame

        stateTextBox.setText(userInfo.getState());
        stateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(stateTextBox);//adding button in JFrame  

        JLabel zipLabel=new JLabel("Zip");  
        zipLabel.setBounds(30,sectionTop+200,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(zipLabel);//adding button in JFrame

        zipTextBox.setText(Integer.toString(userInfo.getZip())); 
        zipTextBox.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(zipTextBox);//adding button in JFrame  

        JLabel firstLabel=new JLabel("First Name");  
        firstLabel.setBounds(30,sectionTop+250,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(firstLabel);//adding button in JFrame

        firstTextBox.setText(userInfo.getFirst());
        firstTextBox.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(firstTextBox);//adding button in JFrame  

        JLabel lastLabel=new JLabel("Last Name");
        lastLabel.setBounds(30,sectionTop+300,100, 40);//x axis, y axis, width, height 
        userViewFrame.add(lastLabel);//adding button in JFrame

        lastTextBox.setText(userInfo.getLast());
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
            List<User>userList=StartProgram.getUserList();
            boolean inList=false;
            try {
                for (User user : userList) {
                    if(user.getCustomerId()==Integer.parseInt(ssTextBox.getText())){
                        user.setAddress(streetTextBox.getText());
                        user.setCity(cityTextBox.getText());
                        user.setState(stateTextBox.getText());
                        user.setZip(Integer.parseInt(zipTextBox.getText()));
                        user.setfirst(firstTextBox.getText());
                        user.setLast(lastTextBox.getText()); 
                        inList=true;
                    }
                }
                if(!inList){
                    userList.add(new ATMuser(Integer.parseInt(ssTextBox.getText()),
                    streetTextBox.getText(), cityTextBox.getText(), stateTextBox.getText(),
                    Integer.parseInt(zipTextBox.getText()), firstTextBox.getText(),
                    lastTextBox.getText()));
                    errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                    JOptionPane.showMessageDialog(errorFrame,"New User Created");
                }
            } catch (Exception ee) {
            //TODO: handle exception
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            JOptionPane.showMessageDialog(errorFrame,"Input Error");
            }
        }
        if(doneButton.hasFocus()){
            userViewFrame.dispose();
            try {
                StartProgram.WriteToEach();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                JOptionPane.showMessageDialog(errorFrame,"File Error");
            }
            mainMenu menu= new mainMenu();
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