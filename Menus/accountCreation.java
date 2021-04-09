    package Menus;
import javax.swing.*;
    public class accountCreation{ 
    public void open() { 
        JFrame Frame=new JFrame();//creating instance of JFrame for the window
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

        String[] accountTypes={"None","Certificate of Deposit","Short Term Loan","Long Term Loan","Credit Card","Checking","Savings","This is My Bank"};
        JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes); 
        accountTypeDrop.setSelectedIndex(0);     
        accountTypeDrop.addActionListener(new Listener());
        accountTypeDrop.setBounds(130,sectionTop+50,140, 40);//x axis, y axis, width, height 
        Frame.add(accountTypeDrop);//adding button in JFrame 

        //input inital amount in account
        JLabel amountLabel=new JLabel("Inital Amount");  
        amountLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
        Frame.add(amountLabel);//adding button in JFrame

        JTextField amountTextBox=new JTextField(null);  
        amountTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
        Frame.add(amountTextBox);//adding button in JFrame  

        JLabel cdDateLabel=new JLabel("Date of Rollover");  
        cdDateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
        Frame.add(cdDateLabel);//adding button in JFrame

        JTextField cddateTextBox=new JTextField(null);  
        cddateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
        Frame.add(cddateTextBox);//adding button in JFrame 

        //button to submit
        JButton submitButton=new JButton("Submit");//creating instance of JButton
        submitButton.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height  
        Frame.add(submitButton);//adding button in JFrame

        Frame.setSize(400,500);//400 width and 500 height  
        Frame.setLayout(null);//using no layout managers  
        Frame.setVisible(true);//making the frame visible
    }
}
    