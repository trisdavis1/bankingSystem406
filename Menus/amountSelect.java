package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import Accounts.Account;
import MainProgram.StartProgram; 
public class amountSelect implements Action{  
    JFrame amountFrame=new JFrame();//creating instance of JFrame
    int wr=42;
    List<Account>accountList;
    JTextField amountTextBox=new JTextField(null);//amount text box
    JButton nextButton=new JButton("Submit");//creating instance of JButton
    JButton doneButton=new JButton("Done");//creating instance of JButton
    Account account;
    public void open(Account ac, int wOr) {  //transfer
        account=ac;
        amountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        int sectionTop=60;//where main section starts
        wr=wOr;
        JLabel Title;
        if(wOr==0){
            Title=new JLabel("Withdraw");//Title
            nextButton.setText("Withdraw");
        }
        else{
            Title=new JLabel("Deposit");//Title
            nextButton.setText("Deposit");
        }
        Title.setBounds(150,1,200, 60);//x axis, y axis, width, height 
        amountFrame.add(Title);

        JLabel amountLabel=new JLabel("Amount");  
        amountLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        amountFrame.add(amountLabel);//adding button in JFrame
  
        amountTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        amountFrame.add(amountTextBox);//adding button in JFrame  

        nextButton.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height
        amountFrame.add(nextButton);//adding button in JFrame
        nextButton.addActionListener(this);

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
            mainMenu menu= new mainMenu();
            menu.openMenu();
        }
        else if(amountTextBox.getText().isEmpty())message="Amount is empty!";

        else if(wr==0){
            //withdraw stuff
            int amount=Integer.parseInt(amountTextBox.getText());
            if(amount<account.getCurrentBalance()){
                try {
                    account.withdraw(amount);
                    message="trying to withdraw $"+amountTextBox.getText();
                } catch (Exception ee) {
                    JFrame errorFrame=new JFrame();//creating instance of JFrame
                    errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                    JOptionPane.showMessageDialog(errorFrame,"Integer Error");
                }
            }else{
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                JOptionPane.showMessageDialog(errorFrame,"Dude, You broke! Current Amount "+account.getCurrentBalance());
            }
            
        }
        else if(wr==1){
            //deposit stuff
             try {
                account.deposit(Integer.parseInt(amountTextBox.getText()));
                message="trying to deposit $"+amountTextBox.getText();
            } catch (Exception ee) {
                //TODO: handle exception
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                JOptionPane.showMessageDialog(errorFrame,"Integer Error");
            }
        }
        if(nextButton.hasFocus()){
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            //default title and icon
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