    import javax.swing.*;  
    public class CheckMenu {  
    public static void main(String[] args) {  
    JFrame checkFrame=new JFrame();//creating instance of JFrame  
          
    JCheckBox stopPaymentCheck=new JCheckBox("Stop Payment");  
    stopPaymentCheck.setBounds(130,0,150, 40);//x axis, y axis, width, height 
    checkFrame.add(stopPaymentCheck);//adding button in JFrame  
    
    JLabel amountLabel=new JLabel("Check Amount");  
    amountLabel.setBounds(30,90,100, 40);//x axis, y axis, width, height 
    checkFrame.add(amountLabel);//adding button in JFrame

    JTextField checkTextBox=new JTextField(null);  
    checkTextBox.setBounds(130,40,100, 40);//x axis, y axis, width, height 
    checkFrame.add(checkTextBox);//adding button in JFrame  

    JLabel checkNumberLabel=new JLabel("Check #");  
    checkNumberLabel.setBounds(60,40,100, 40);//x axis, y axis, width, height 
    checkFrame.add(checkNumberLabel);//adding button in JFrame
    
    JTextField checkNumberBox=new JTextField(null);  
    checkNumberBox.setBounds(130,90,100, 40);//x axis, y axis, width, height 
    checkFrame.add(checkNumberBox);//adding button in JFrame

    JLabel customerNameLabel=new JLabel("Customer Name");  
    customerNameLabel.setBounds(30,140,100, 40);//x axis, y axis, width, height 
    checkFrame.add(customerNameLabel);//adding button in JFrame
    
    JTextField customerNameField=new JTextField(null);  
    customerNameField.setBounds(130,140,100, 40);//x axis, y axis, width, height 
    checkFrame.add(customerNameField);//adding button in JFrame

    JLabel accountNumber=new JLabel("Account Number");  
    accountNumber.setBounds(30,190,100, 40);//x axis, y axis, width, height 
    checkFrame.add(accountNumber);//adding button in JFrame
    
    JTextField accountNumberField=new JTextField(null);  
    accountNumberField.setBounds(130,190,100, 40);//x axis, y axis, width, height 
    checkFrame.add(accountNumberField);//adding button in JFrame

    JButton submitButton=new JButton("Submit");//creating instance of JButton
    submitButton.setBounds(130,300,100, 40);//x axis, y axis, width, height  
    checkFrame.add(submitButton);//adding button in JFrame

    checkFrame.setSize(400,500);//400 width and 500 height  
    checkFrame.setLayout(null);//using no layout managers  
    checkFrame.setVisible(true);//making the frame visible  
    }  
    }  