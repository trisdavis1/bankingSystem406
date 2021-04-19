package Menus;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;

import Accounts.Account;
import MainProgram.StartProgram;

public class loanView implements Action {
    List<Account> accountList;
    JTextField amountTextBox = new JTextField();
    JButton doneButton = new JButton("Done");// creating instance of JButton
    JButton updateButton = new JButton("Update");// creating instance of JButton
    JFrame accountFrame = new JFrame();// creating instance of JFrame
    JTextField ssTextBox = new JTextField();

    public void open(List<Account> aL,int loanType) {
        accountList = aL;
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// end program on exit

        JLabel Title = new JLabel("Loan View");// Title
        Title.setBounds(130, 1, 100, 60);// x axis, y axis, width, height
        accountFrame.add(Title);// adding button in JFrame

        int sectionTop = 60;// where main section starts
        JLabel ssLabel = new JLabel("User SS");
        ssLabel.setBounds(30, sectionTop, 100, 40);// x axis, y axis, width, height
        accountFrame.add(ssLabel);// adding button in JFrame

        ssTextBox.setText(Integer.toString(accountList.get(0).getCustomerId()));
        ssTextBox.setBounds(130, sectionTop, 100, 40);// x axis, y axis, width, height
        accountFrame.add(ssTextBox);// adding button in JFrame

        JLabel accountTypeLabel = new JLabel("Account Type");
        accountTypeLabel.setBounds(30, sectionTop + 50, 100, 40);// x axis, y axis, width, height
        accountFrame.add(accountTypeLabel);// adding button in JFrame

        String[] accountTypes = StartProgram.getAccountTypes();
        JComboBox<String> accountTypeDrop = new JComboBox<>(accountTypes);
        accountTypeDrop.setSelectedIndex(loanType);
        accountTypeDrop.setBounds(130, sectionTop + 50, 160, 40);// x axis, y axis, width, height
        accountFrame.add(accountTypeDrop);// adding button in JFrame

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(30, sectionTop + 100, 100, 40);// x axis, y axis, width, height
        accountFrame.add(amountLabel);// adding button in JFrame

        amountTextBox.setText(Double.toString(aL.get(0).getCurrentBalance()));
        amountTextBox.setBounds(130, sectionTop + 100, 100, 40);// x axis, y axis, width, height
        accountFrame.add(amountTextBox);// adding button in JFrame

        updateButton.setBounds(130, sectionTop + 250, 100, 40);// x axis, y axis, width, height
        accountFrame.add(updateButton);// adding button in JFrame
        updateButton.addActionListener(this);

        doneButton.setBounds(130, sectionTop + 300, 100, 40);// x axis, y axis, width, height
        accountFrame.add(doneButton);// adding button in JFrame
        doneButton.addActionListener(this);

        accountFrame.setSize(400, 500);// 400 width and 500 height
        accountFrame.setLayout(null);// using no layout managers
        accountFrame.setVisible(true);// making the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (updateButton.hasFocus()) {
            JFrame errorFrame=new JFrame();//creating instance of JFrame
            errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
            //default title and icon

            JOptionPane.showMessageDialog(errorFrame,"Updating");
            try {
                try {
                        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                        accountList.add(
                            new LoanAccount(Integer.parseInt(ssTextBox.getText()), Double.parseDouble(amountTextBox.getText()),
                                Double.parseDouble(interestRateTextBox.getText()), formatter.parse(duedateTextBox.getText()),
                                formatter.parse(notedateTextBox.getText()),Double.parseDouble(amountTextBox.getText())/780,
                                accountTypeDrop.getSelectedItem().toString(),false, 
                                ((isBackup.isSelected())?formatter.parse(duedateTextBox.getText()):formatter.parse(duedateTextBox.getText())
                                )
                            )
                        );
                        StartProgram.WriteToEach();
                        accountCreationFrame.dispose();
                        mainMenu menu= new mainMenu();
                        menu.openMenu();                   
                }catch (Exception ee) {
                //TODO: handle exception
                errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//end program on exit
                JOptionPane.showMessageDialog(errorFrame,"Input Error for a new loan account");
                }
            } catch (Exception ee) {
                //TODO: handle exception
            }
            
        }
        if (doneButton.hasFocus()) {
            try {
                StartProgram.WriteToEach();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                JFrame errorFrame=new JFrame();//creating instance of JFrame
                JOptionPane.showMessageDialog(errorFrame,"Updating");
            }
            accountFrame.dispose();
            mainMenu menu = new mainMenu();
            menu.openMenu();
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