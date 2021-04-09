    package Menus;
    import javax.swing.*;  
    public class userView {  
    public void create() {  
    JFrame Frame=new JFrame();//creating instance of JFrame  
    Frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    JLabel Title=new JLabel("User View");  
    Title.setBounds(150,5,100, 40);//x axis, y axis, width, height 
    Frame.add(Title);//adding button in JFrame

    int sectionTop=50;
    JLabel ssLabel=new JLabel("SS");  
    ssLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
    Frame.add(ssLabel);//adding button in JFrame

    JTextField ssTextBox=new JTextField("123-12-1234");  
    ssTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
    Frame.add(ssTextBox);//adding button in JFrame  
    
    JLabel streetLabel=new JLabel("Street Address");  
    streetLabel.setBounds(30,sectionTop+50,100, 40);//x axis, y axis, width, height 
    Frame.add(streetLabel);//adding button in JFrame

    JTextField streetTextBox=new JTextField("123 Wherever Lane");  
    streetTextBox.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height 
    Frame.add(streetTextBox);//adding button in JFrame  

    JLabel cityLabel=new JLabel("City");  
    cityLabel.setBounds(30,sectionTop+100,100, 40);//x axis, y axis, width, height 
    Frame.add(cityLabel);//adding button in JFrame

    JTextField cityTextBox=new JTextField("Anytown");  
    cityTextBox.setBounds(130,sectionTop+100,100, 40);//x axis, y axis, width, height 
    Frame.add(cityTextBox);//adding button in JFrame  

    JLabel stateLabel=new JLabel("State");  
    stateLabel.setBounds(30,sectionTop+150,100, 40);//x axis, y axis, width, height 
    Frame.add(stateLabel);//adding button in JFrame

    JTextField stateTextBox=new JTextField("MO");  
    stateTextBox.setBounds(130,sectionTop+150,100, 40);//x axis, y axis, width, height 
    Frame.add(stateTextBox);//adding button in JFrame  

    JLabel zipLabel=new JLabel("Zip");  
    zipLabel.setBounds(30,sectionTop+200,100, 40);//x axis, y axis, width, height 
    Frame.add(zipLabel);//adding button in JFrame

    JTextField zipTextBox=new JTextField("12344");  
    zipTextBox.setBounds(130,sectionTop+200,100, 40);//x axis, y axis, width, height 
    Frame.add(zipTextBox);//adding button in JFrame  

    JLabel firstLabel=new JLabel("First Name");  
    firstLabel.setBounds(30,sectionTop+250,100, 40);//x axis, y axis, width, height 
    Frame.add(firstLabel);//adding button in JFrame

    JTextField firstTextBox=new JTextField("Stan");  
    firstTextBox.setBounds(130,sectionTop+250,100, 40);//x axis, y axis, width, height 
    Frame.add(firstTextBox);//adding button in JFrame  

    JLabel lastLabel=new JLabel("Last Name");  
    lastLabel.setBounds(30,sectionTop+300,100, 40);//x axis, y axis, width, height 
    Frame.add(lastLabel);//adding button in JFrame

    JTextField lastTextBox=new JTextField("Lee");  
    lastTextBox.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height 
    Frame.add(lastTextBox);//adding button in JFrame  

    JButton submitButton=new JButton("Submit");//creating instance of JButton
    submitButton.setBounds(130,sectionTop+350,100, 40);//x axis, y axis, width, height
    Frame.add(submitButton);//adding button in JFrame

    Frame.setSize(400,500);//400 width and 500 height  
    Frame.setLayout(null);//using no layout managers  
    Frame.setVisible(true);//making the frame visible  
    }
}