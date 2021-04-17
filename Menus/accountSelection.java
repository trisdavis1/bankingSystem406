package Menus;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import Accounts.Account;
import MainProgram.StartProgram;
public class accountSelection implements Action{  
    JFrame accSelectFrame=new JFrame();//creating instance of JFrame
    String[] accountTypes={"None","Certificate of Deposit","Short Term Loan","Long Term Loan","Credit Card","Checking","Savings","This is My Bank","Gold"};
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes);//type of account
    List<Account>accountList;
    public void open(String ID,List<Account> aL) {
        accountList=aL;
        accSelectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        int sectionTop=60;//where main section starts

        JLabel Title=new JLabel("Select an account type");//Title
        Title.setBounds(130,1,200, 60);//x axis, y axis, width, height 
        accSelectFrame.add(Title);//adding button in JFrame
        
        JLabel ss = new JLabel("ID:"+ID.substring(ID.length() - 4));//only show last four
        ss.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        accSelectFrame.add(ss);//adding button in JFrame

        JLabel accountTypeLabel=new JLabel("Account Type");  
        accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
        accSelectFrame.add(accountTypeLabel);//adding button in JFrame

        accountTypeDrop.setSelectedIndex(0);
        accountTypeDrop.setBounds(130,sectionTop+50,140, 40);//x axis, y axis, width, height 
        accSelectFrame.add(accountTypeDrop);//adding button in JFrame 

        JButton doneButton=new JButton("Next");//creating instance of JButton
        doneButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
        doneButton.addActionListener(this);
        accSelectFrame.dispose();
        accSelectFrame.add(doneButton);//adding button in JFrame

        accSelectFrame.setSize(400,500);//400 width and 500 height  
        accSelectFrame.setLayout(null);//using no layout managers  
        accSelectFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // when next is selected get the account infomation and open the withdraw or deposit window
        //TODO add in the passing of data for which account
        int index=accountTypeDrop.getSelectedIndex();
        String accountClass=StartProgram.convertToClass(index);
        List<Account> CustAccounts=new ArrayList<Account>();
        for (Account account : accountList) {
            System.out.println(accountClass+" "+account.getType());
            if(accountClass.equals(account.getType()))
            {
                CustAccounts.add(account);
                //System.out.println(account.getClass().toString());
            }
        }
        if(accountClass.equals("none")){
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            //default title and icon
            JOptionPane.showMessageDialog(errorFrame,"Choose an account type");
        }
        else if(CustAccounts.size()==0){
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            //default title and icon
            JOptionPane.showMessageDialog(errorFrame,"You don't have type of account");}
        else{
           System.out.println();
            worDselect a = new worDselect();
            accSelectFrame.dispose();
            a.open(CustAccounts); 
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