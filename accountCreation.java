    import javax.swing.*;  
    public class accountCreation {  
    public static void main(String[] args) {  
    JFrame accountFrame=new JFrame();//creating instance of JFrame  

    JLabel Title=new JLabel("Account Creation");
    Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
    accountFrame.add(Title);//adding button in JFrame
    
    int sectionTop=60;
    JLabel ssLabel=new JLabel("User SS");  
    ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
    accountFrame.add(ssLabel);//adding button in JFrame

    JTextField ssTextBox=new JTextField(null);  
    ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
    accountFrame.add(ssTextBox);//adding button in JFrame

    JLabel accountTypeLabel=new JLabel("Account Type");  
    accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
    accountFrame.add(accountTypeLabel);//adding button in JFrame

    String[] accountTypes={"None","Short Term Loan","Long Term Mortgage Loan","Credit Card","Checking","Savings","This is My Bank"};
    JComboBox accountTypeDrop=new JComboBox<String>(accountTypes); 
    accountTypeDrop.setSelectedIndex(0);     
    accountTypeDrop.setBounds(130,sectionTop+50,160, 40);//x axis, y axis, width, height 
    accountFrame.add(accountTypeDrop);//adding button in JFrame  

    JLabel amountLabel=new JLabel("Inital Amount");  
    amountLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
    accountFrame.add(amountLabel);//adding button in JFrame

    JTextField amountTextBox=new JTextField(null);  
    amountTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
    accountFrame.add(amountTextBox);//adding button in JFrame  

    JButton submitButton=new JButton("Submit");//creating instance of JButton
    submitButton.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height  
    accountFrame.add(submitButton);//adding button in JFrame

    accountFrame.setSize(400,500);//400 width and 500 height  
    accountFrame.setLayout(null);//using no layout managers  
    accountFrame.setVisible(true);//making the frame visible  
    }
}