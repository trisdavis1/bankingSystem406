package Menus;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class Listener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getClass()+" clicked");
        
    }
    public Object getValue(String key) {
        // TODO Auto-generated method stub
        return null;
    }
    public void putValue(String key, Object value) {
        // TODO Auto-generated method stub
        
    }
    public void setEnabled(boolean b) {
        // TODO Auto-generated method stub
        
    }

    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub
        
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        // TODO Auto-generated method stub
        
    }
        
}
