package MainProgram;
import Accounts.ATMuser;
import Accounts.Account;
import Accounts.CheckingAccount;
import Accounts.LoanAccount;
import Accounts.SavingsAccount;
import Accounts.User;
import Menus.mainMenu;

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

        /* for(var account : accountList)
        {
            System.out.println(account.getCurrentBalance());
        } */

        mainMenu menu= new mainMenu();
        menu.openMenu();
        //use below in interface
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
    }public static List<User> getUserList(){
        return userList;
    }
    public static String convertToClass(int index){
        String classyList="none";
        if(index==0){classyList="none";}
        if(index==1){classyList= "CD";}
        if(index==2){classyList= "Short Term";}
        if(index==3){classyList= "Long Term";}
        if(index==4){classyList= "Credit Card";}
        if(index==5){classyList= "checking";}
        if(index==6){classyList= "Savings";}
        if(index==7){classyList= "TMB";}
        if(index==8){classyList= "Gold/Diamond";}
        return classyList;
    }
    public static int convertToIndex(String input){
        if(input.equals("none"))return 0;
        if(input.equals("CD"))return 1;
        if(input.equals("Short Term"))return 2;
        if(input.equals("Long Term"))return 3;
        if(input.equals("Credit Card"))return 4;
        if(input.equals("checking"))return 5;
        if(input.equals("Savings"))return 6;
        if(input.equals("TMB"))return 7;
        if(input.equals("Gold/Diamond"))return 8;
        return 0;
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
