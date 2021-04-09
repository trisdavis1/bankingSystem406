    package Menus;
    import javax.swing.*;  
    public class Menu{  
    
    public static void main(String[] args) {  
        accountCreation aC = new accountCreation();
        aC.create();

        accountView aV= new accountView();
        aV.create();

        CheckMenu cM= new CheckMenu();
        cM.create();

        Payment pM= new Payment();
        pM.create();

        userCreation uC = new userCreation();
        uC.create();

        userView uV= new userView();
        uV.create();
        
        
    }
}