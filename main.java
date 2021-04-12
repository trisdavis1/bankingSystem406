import Accounts.Account;
import Accounts.LoanAccount;
import Menus.Menu;
import Menus.initATM;
import Menus.initTeller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        File loanFile = new File("../bankingSystem406/Database Files/Loans.txt");
        List<LoanAccount> loanAccounts = new ArrayList<>();
        List<Account> accountList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(loanFile))) {
            
            String line;
            while((line = br.readLine()) != null){

                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                loanAccounts.add(new LoanAccount(Integer.parseInt(items[0]),
                        Double.parseDouble(items[1]), Double.parseDouble(items[2]), formatter.parse(items[3]),
                        formatter.parse(items[4]), Double.parseDouble(items[5]), items[6],
                        Integer.parseInt(items[7])==1, formatter.parse(items[8])));
            }
            //open main Menu
            Menu menu= new Menu();
            menu.openMenu(accountList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        for(var loan : loanAccounts){
            System.out.println(loan.currentBalance); // just to verify its working (can be deleted)
        }
    }
}
