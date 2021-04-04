    import javax.swing.*;  
    public class userCreation {  
    public static void main(String[] args) {  
    JFrame checkFrame=new JFrame();//creating instance of JFrame  
    
    JLabel sslabel=new JLabel("SS");  
    sslabel.setBounds(30,10,100, 40);//x axis, y axis, width, height 
    checkFrame.add(sslabel);//adding button in JFrame

    JTextField ssTextBox=new JTextField(null);  
    ssTextBox.setBounds(130,10,100, 40);//x axis, y axis, width, height 
    checkFrame.add(ssTextBox);//adding button in JFrame  
    
    JLabel streetLabel=new JLabel("Street Address");  
    streetLabel.setBounds(30,60,100, 40);//x axis, y axis, width, height 
    checkFrame.add(streetLabel);//adding button in JFrame

    JTextField streetTextBox=new JTextField(null);  
    streetTextBox.setBounds(130,60,100, 40);//x axis, y axis, width, height 
    checkFrame.add(streetTextBox);//adding button in JFrame  

    JLabel cityLabel=new JLabel("City");  
    cityLabel.setBounds(30,110,100, 40);//x axis, y axis, width, height 
    checkFrame.add(cityLabel);//adding button in JFrame

    JTextField cityTextBox=new JTextField(null);  
    cityTextBox.setBounds(130,110,100, 40);//x axis, y axis, width, height 
    checkFrame.add(cityTextBox);//adding button in JFrame  

    JLabel stateLabel=new JLabel("State");  
    stateLabel.setBounds(30,160,100, 40);//x axis, y axis, width, height 
    checkFrame.add(stateLabel);//adding button in JFrame

    JTextField stateTextBox=new JTextField(null);  
    stateTextBox.setBounds(130,160,100, 40);//x axis, y axis, width, height 
    checkFrame.add(stateTextBox);//adding button in JFrame  

    JLabel zipLabel=new JLabel("Zip");  
    zipLabel.setBounds(30,210,100, 40);//x axis, y axis, width, height 
    checkFrame.add(zipLabel);//adding button in JFrame

    JTextField zipTextBox=new JTextField(null);  
    zipTextBox.setBounds(130,210,100, 40);//x axis, y axis, width, height 
    checkFrame.add(zipTextBox);//adding button in JFrame  

    JLabel firstLabel=new JLabel("First Name");  
    firstLabel.setBounds(30,260,100, 40);//x axis, y axis, width, height 
    checkFrame.add(firstLabel);//adding button in JFrame

    JTextField firstTextBox=new JTextField(null);  
    firstTextBox.setBounds(130,260,100, 40);//x axis, y axis, width, height 
    checkFrame.add(firstTextBox);//adding button in JFrame  

    JLabel lastLabel=new JLabel("Last Name");  
    lastLabel.setBounds(30,310,100, 40);//x axis, y axis, width, height 
    checkFrame.add(lastLabel);//adding button in JFrame

    JTextField lastTextBox=new JTextField(null);  
    lastTextBox.setBounds(130,310,100, 40);//x axis, y axis, width, height 
    checkFrame.add(lastTextBox);//adding button in JFrame  

    JButton submitButton=new JButton("Submit");//creating instance of JButton
    submitButton.setBounds(130,360,100, 40);//x axis, y axis, width, height  
    checkFrame.add(submitButton);//adding button in JFrame

    checkFrame.setSize(400,500);//400 width and 500 height  
    checkFrame.setLayout(null);//using no layout managers  
    checkFrame.setVisible(true);//making the frame visible  
    }  
    }  