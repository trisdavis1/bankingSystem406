    package Menus;
    import java.awt.event.ActionEvent;
    import java.beans.PropertyChangeListener;
    import javax.swing.*;  
    
    public class accountTellerView implements Action{  
        JFrame TellerViewFrame=new JFrame();//creating instance of JFrame

        public void open() {  
        TellerViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        int sectionTop=60;//where main section starts

        JLabel Title=new JLabel("User Info");//Title
        Title.setBounds(130,1,100, 60);//x axis, y axis, width, height 
        TellerViewFrame.add(Title);//adding button in JFrame

        JLabel amountLabel=new JLabel("Amount");  
        amountLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        TellerViewFrame.add(amountLabel);//adding button in JFrame

        JFormattedTextField amountTextBox=new JFormattedTextField(123673);  
        amountTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        TellerViewFrame.add(amountTextBox);//adding button in JFrame
        
        JButton doneButton=new JButton("Next");//creating instance of JButton
        doneButton.setBounds(130,sectionTop+50,100, 40);//x axis, y axis, width, height
        doneButton.addActionListener(this);
        TellerViewFrame.dispose();
        TellerViewFrame.add(doneButton);//adding button in JFrame

        TellerViewFrame.setSize(400,500);//400 width and 500 height  
        TellerViewFrame.setLayout(null);//using no layout managers  
        TellerViewFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //when Next is clicked get the user data
        // TODO pass the SS to data getting function
        accountTellerView a=new accountTellerView();
        TellerViewFrame.dispose();
        a.open();
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