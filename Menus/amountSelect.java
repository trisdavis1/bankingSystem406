    package Menus;
    import java.awt.event.ActionEvent;
    import java.beans.PropertyChangeListener;

import javax.swing.*;  
    public class amountSelect implements Action{  
    JFrame amountFrame=new JFrame();//creating instance of JFrame
    int wr=42;
    JTextField amountTextBox=new JTextField(null);//amount text box

    public void open(int wOr) {  //withdraw or deposit
        amountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//end program on exit
        int sectionTop=60;//where main section starts
        wr=wOr;
        JLabel Title;
        if(wOr==0){
            Title=new JLabel("Withdraw");//Title
        }
        else{
            Title=new JLabel("Deposit");//Title
        }
        Title.setBounds(150,1,200, 60);//x axis, y axis, width, height 
        amountFrame.add(Title);

        JLabel amountLabel=new JLabel("Amount");  
        amountLabel.setBounds(30,sectionTop,100, 40);//x axis, y axis, width, height 
        amountFrame.add(amountLabel);//adding button in JFrame
  
        amountTextBox.setBounds(130,sectionTop,100, 40);//x axis, y axis, width, height 
        amountFrame.add(amountTextBox);//adding button in JFrame  

        JButton doneButton=new JButton("Next");//creating instance of JButton
        doneButton.setBounds(130,sectionTop+300,100, 40);//x axis, y axis, width, height
        amountFrame.add(doneButton);//adding button in JFrame
        doneButton.addActionListener(this);

        amountFrame.setSize(400,500);//400 width and 500 height  
        amountFrame.setLayout(null);//using no layout managers  
        amountFrame.setVisible(true);//making the frame visible  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //decide what to pass
        if(wr==0){
            //withdraw stuff
            System.out.println("try to withdraw $"+amountTextBox.getText()+" from account");
        }
        else if(wr==1){
            //deposit stuff
            System.out.println("try to deposit $"+amountTextBox.getText()+" into account");
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