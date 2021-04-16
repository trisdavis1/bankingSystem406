package MainProgram;
import Accounts.ATMuser;
import Accounts.Account;
import Accounts.CheckingAccount;
import Accounts.LoanAccount;
import Accounts.SavingsAccount;
import Accounts.User;
import Menus.Menu;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StartProgram {
    static List<Account> accountList = new ArrayList<>();
    static List<Account> loanAccounts= new ArrayList<>();
    static List<Account> checkingAccounts=new ArrayList<>();
    static List<Account> savingsAccounts=new ArrayList<>();
    static List<User> userList=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        File loanFile = new File("Database Files/loanAccounts.txt");
        File checkingFile = new File("../bankingSystem406/Database Files/checkingAccounts.txt");
        File savingsFile = new File("../bankingSystem406/Database Files/savingsAccounts.txt");
        File userFile = new File("../bankingSystem406/Database Files/customer.txt");

        loanAccounts = GetLoanData(loanFile);
        checkingAccounts = GetCheckingData(checkingFile);
        savingsAccounts = GetSavingsData(savingsFile);
        userList= GetUserData(userFile);
        

        accountList.addAll(loanAccounts);
        accountList.addAll(checkingAccounts);
        accountList.addAll(savingsAccounts);

        for(var account : accountList)
        {
            System.out.println(account.getCurrentBalance());
        }

        Menu menu= new Menu();
        menu.openMenu();

        WriteAccountData(checkingFile, checkingAccounts);
        WriteAccountData(loanFile, loanAccounts);
        WriteAccountData(savingsFile, savingsAccounts);
    }
    public static List<Account> getAccountList(){
        return accountList;
    }public static List<Account> getCheckingAccountList(){
        return checkingAccounts;
    }public static List<Account> getSavingAccountList(){
        return savingsAccounts;
    }public static List<Account> getLoanAccountList(){
        return loanAccounts;
    }
    public static String convertToClass(int index){
        if(index==0)return "none";
        if(index==1)return "class Accounts.SavingsAccount";
        if(index==2)return "class Accounts.LoanAccount";
        if(index==3)return "class Accounts.LoanAccount";
        if(index==4)return "class Accounts.CheckingAccount";
        if(index==5)return "class Accounts.SavingsAccount";
        if(index==6)return "class Accounts.SavingsAccount";
        return "None";
    }

    public static List<Account> GetCheckingData(File file){
        var checkingAccounts = new ArrayList<Account>();

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
    public static List<User> GetUserData(File file){
        var UserAccounts = new ArrayList<User>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                UserAccounts.add(new ATMuser(Integer.parseInt(items[0]), items[1], items[2], items[3], Integer.parseInt(items[4]), items[5], items[6]));
                System.out.println(UserAccounts.size());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return UserAccounts;
    }

    public static  List<Account> GetLoanData(File file){
        var loanAccounts = new ArrayList<Account>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

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

    public static List<Account> GetSavingsData(File file){
        var savingsAccounts = new ArrayList<Account>();

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

    public static void WriteAccountData(File file, List<Account> accounts) throws IOException {
        FileWriter writer = new FileWriter(file);
        ArrayList<String[]> records = new ArrayList<String[]>();

        for(var account : accounts)
        {
            records.add(account.accountToArray());
        }

        for(var record : records)
        {
            writer.append(String.join(",", record));
            writer.append("\n");
        }

        writer.flush();
        writer.close();
    }
}
