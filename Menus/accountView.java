    package Menus;
    import javax.swing.*;  
    public class accountView {
    public void open() {  
    JFrame accountFrame=new JFrame();//creating instance of JFrame  
    accountFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//end program on exit
    
    JLabel Title=new JLabel("Account View");//Title
    Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
    accountFrame.add(Title);//adding button in JFrame
    
    int sectionTop=60;//where main section starts
    JLabel ssLabel=new JLabel("User SS");  
    ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
    accountFrame.add(ssLabel);//adding button in JFrame

    JFormattedTextField ssTextBox=new JFormattedTextField("123-45-6789");
    ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
    accountFrame.add(ssTextBox);//adding button in JFrame

    JLabel accountTypeLabel=new JLabel("Account Type");  
    accountTypeLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
    accountFrame.add(accountTypeLabel);//adding button in JFrame

    String[] accountTypes={"None","Short Term Loan","Long Term Mortgage Loan","Credit Card","Checking","Savings","This is My Bank"};
    JComboBox<String> accountTypeDrop=new JComboBox<>(accountTypes); 
    accountTypeDrop.setSelectedIndex(2);     
    accountTypeDrop.setBounds(130,sectionTop+50,160, 40);//x axis, y axis, width, height 
    accountFrame.add(accountTypeDrop);//adding button in JFrame  

    JLabel amountLabel=new JLabel("Amount");  
    amountLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
    accountFrame.add(amountLabel);//adding button in JFrame

    JFormattedTextField amountTextBox=new JFormattedTextField(123673);  
    amountTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
    accountFrame.add(amountTextBox);//adding button in JFrame  

    JButton updateButton=new JButton("Update");//creating instance of JButton
    updateButton.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height  
    accountFrame.add(updateButton);//adding button in JFrame

    JButton doneButton=new JButton("Done");//creating instance of JButton
    doneButton.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height
    accountFrame.dispose();
    accountFrame.add(doneButton);//adding button in JFrame

    accountFrame.setSize(400,500);//400 width and 500 height  
    accountFrame.setLayout(null);//using no layout managers  
    accountFrame.setVisible(true);//making the frame visible  
    }
}