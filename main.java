import Accounts.Account;
import Accounts.CheckingAccount;
import Accounts.LoanAccount;
import Accounts.SavingsAccount;
import Menus.Menu;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        File loanFile = new File("../bankingSystem406/Database Files/Loans.txt");
        File checkingFile = new File("../bankingSystem406/Database Files/checkingAccounts.txt");
        File savingsFile = new File("../bankingSystem406/Database Files/savingsAccounts.txt");

        List<LoanAccount> loanAccounts = GetLoanData(loanFile);
        List<CheckingAccount> checkingAccounts = GetCheckingData(checkingFile);
        List<SavingsAccount> savingsAccounts = GetSavingsData(savingsFile);
        List<Account> accountList = new ArrayList<>();

        accountList.addAll(loanAccounts);
        accountList.addAll(checkingAccounts);
        accountList.addAll(savingsAccounts);

        for(var account : accountList)
        {
            System.out.println(account.getCurrentBalance());
        }

        Menu menu= new Menu();
        menu.openMenu(accountList);
    }

    public static List<CheckingAccount> GetCheckingData(File file){
        var checkingAccounts = new ArrayList<CheckingAccount>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                checkingAccounts.add(new CheckingAccount(Integer.parseInt(items[0]), Integer.parseInt(items[1]),
                        items[2], Double.parseDouble(items[3]), Integer.parseInt(items[4]), Integer.parseInt(items[5]),
                        Integer.parseInt(items[6]),formatter.parse(items[7])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return checkingAccounts;
    }
    public static  List<LoanAccount> GetLoanData(File file){
        var loanAccounts = new ArrayList<LoanAccount>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                loanAccounts.add(new LoanAccount(Integer.parseInt(items[0]),
                        Double.parseDouble(items[1]), Double.parseDouble(items[2]), formatter.parse(items[3]),
                        formatter.parse(items[4]), Double.parseDouble(items[5]), items[6],
                        Integer.parseInt(items[7])==1, formatter.parse(items[8])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return loanAccounts;
    }

    public static List<SavingsAccount> GetSavingsData(File file){
        var savingsAccounts = new ArrayList<SavingsAccount>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                savingsAccounts.add(new SavingsAccount(Integer.parseInt(items[0]), Integer.parseInt(items[1]),
                                                       Double.parseDouble(items[2]), Double.parseDouble(items[3]),
                                                       formatter.parse(items[4])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return savingsAccounts;
    }
}
