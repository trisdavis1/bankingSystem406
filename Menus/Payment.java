    import javax.swing.*;  
    public class Payment {  
    public static void main(String[] args) {  
    JFrame Frame=new JFrame();//creating instance of JFrame  
    Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel Title=new JLabel("Payment");
    Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
    Frame.add(Title);//adding button in JFrame
    
    int sectionTop=60;
    JLabel ssLabel=new JLabel("Account Number");  
    ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
    Frame.add(ssLabel);//adding button in JFrame

    JTextField ssTextBox=new JTextField(null);  
    ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
    Frame.add(ssTextBox);//adding button in JFrame

    JLabel accountTypeLabel=new JLabel("Account Type");  
    accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
    Frame.add(accountTypeLabel);//adding button in JFrame

    String[] accountTypes={"None","Short Term Loan","Long Term Mortgage Loan","Credit Card"};
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes); 
    accountTypeDrop.setSelectedIndex(0);     
    accountTypeDrop.setBounds(130,sectionTop+50,160, 40);//x axis, y axis, width, height 
    Frame.add(accountTypeDrop);//adding button in JFrame  

    JLabel amountLabel=new JLabel("Payment Amount");  
    amountLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
    Frame.add(amountLabel);//adding button in JFrame

    JTextField amountTextBox=new JTextField(null);  
    amountTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
    Frame.add(amountTextBox);//adding button in JFrame  

    JButton submitButton=new JButton("Submit");//creating instance of JButton
    submitButton.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height  
    Frame.add(submitButton);//adding button in JFrame

    Frame.setSize(400,500);//400 width and 500 height  
    Frame.setLayout(null);//using no layout managers  
    Frame.setVisible(true);//making the frame visible  
    }
}