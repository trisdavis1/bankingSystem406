    package Menus;
    import javax.swing.*; 
    public class Menu{  
    
    public static void main(String[] args) {  
        accountCreation aC = new accountCreation();
        aC.open();

        accountView aV= new accountView();
        aV.open();

        CheckMenu cM= new CheckMenu();
        cM.open();

        Payment pM= new Payment();
        pM.open();

        userCreation uC = new userCreation();
        uC.open();

        userView uV= new userView();
        uV.open();
    }
}