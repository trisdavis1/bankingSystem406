package MainProgram;
import Accounts.ATMuser;
import Accounts.Account;
import Accounts.CD;
import Accounts.Check;
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
    static List<Account> accountList = new ArrayList<>();//overall list of all accounts
    static List<Account> loanAccounts= new ArrayList<>();//list of loan accounts
    static List<Account> checkingAccounts=new ArrayList<>();//list of checking accounts
    static List<Account> savingsAccounts=new ArrayList<>();//list of saving accounts
    static List<Account> cdAccounts=new ArrayList<>();//list of cd's
    static List<User> userList=new ArrayList<>();//list of all users
    static String[] accountTypes={"none","Savings","CD","TMB","Gold/Diamond","Short Term","Long Term","Credit Card"};
    public static void main(String[] args) throws IOException {
        //input files
        File loanFile = new File("Database Files/loanAccounts.txt");
        File checkingFile = new File("../bankingSystem406/Database Files/checkingAccounts.txt");
        File savingsFile = new File("../bankingSystem406/Database Files/savingsAccounts.txt");
        File cDFile = new File("../bankingSystem406/Database Files/cds.txt");
        File userFile = new File("../bankingSystem406/Database Files/customer.txt");

        //grab all data
        loanAccounts = GetLoanData(loanFile);
        checkingAccounts = GetCheckingData(checkingFile);
        savingsAccounts = GetSavingsData(savingsFile);
        cdAccounts = GetCDData(cDFile);
        userList= GetUserData(userFile);
        
        //add accounts to accountList
        accountList.addAll(loanAccounts);
        accountList.addAll(checkingAccounts);
        accountList.addAll(savingsAccounts);
        accountList.addAll(cdAccounts);

        /* for(var account : accountList)
        {
            System.out.println(account.getCurrentBalance());
        } */
        //test writing operations
        StartProgram.WriteToEach();
        mainMenu menu= new mainMenu();
        menu.openMenu();//open main menu
    }
    public static List<Account> getAccountList(){
        //get total account list
        return accountList;
    }
    public static List<Account> getCheckingAccountList(){
        //get checking list
        return checkingAccounts;
    }
    public static List<Account> getSavingAccountList(){
        //get saving list
        return savingsAccounts;
    }
    public static List<Account> getcdAccountList(){
        //get cd list
        return cdAccounts;
    }public static List<Account> getLoanAccountList(){
        //get list of loans
        return loanAccounts;
    }
    public static List<User> getUserList(){
        //get list of users
        return userList;
    }
    public static String convertToClass(int index){
        //convert from dropdown menu to account type
        String classyList="none";
        if(index==1){classyList= "Savings";}
        if(index==2){classyList= "CD";}
        if(index==3){classyList= "TMB";}
        if(index==4){classyList= "Gold/Diamond";}
        if(index==5){classyList= "Short Term";}
        if(index==6){classyList= "Long Term";}
        if(index==7){classyList= "Credit Card";}
        
        
        return classyList;
    }
    public static int convertToIndex(String input){
        //convert from account type to dropdown index
        int out=0;
        if(input.equals("Savings"))return 1;
        if(input.equals("CD"))return 2;
        if(input.equals("TMB"))return 3;
        if(input.equals("Gold/Diamond"))return 4;
        if(input.equals("Short Term"))return 5;
        if(input.equals("Long Term"))return 6;
        if(input.equals("Credit Card"))return 7;
        return out;
    }
    public static String[] getAccountTypes(){
        //get list of account types
        return accountTypes;
    }
    public static void WriteToEach() throws IOException{
        //update and write to all lists
        for (Account account : accountList) {
            //if the list does not have it add it to the sublist
            if(account.getType().equals("Savings")){
                if(!savingsAccounts.contains(account))savingsAccounts.add(account);
            }if(account.getType().equals("CD")){
                if(!cdAccounts.contains(account))cdAccounts.add(account);
            }if(account.getType().equals("TMB")){
                if(!checkingAccounts.contains(account))checkingAccounts.add(account);
            }if(account.getType().equals("Gold/Diamond")){
                if(!checkingAccounts.contains(account))checkingAccounts.add(account);
            }if(account.getType().equals("Short Term")){
                if(!loanAccounts.contains(account))loanAccounts.add(account);
            }if(account.getType().equals("Long Term")){
                if(!loanAccounts.contains(account))loanAccounts.add(account);
            }if(account.getType().equals("Credit Card")){
                if(!loanAccounts.contains(account))loanAccounts.add(account);
            }
        } 
        //load all files
        File loanFile = new File("Database Files/loanAccounts.txt");
        File checkingFile = new File("../bankingSystem406/Database Files/checkingAccounts.txt");
        File savingsFile = new File("../bankingSystem406/Database Files/savingsAccounts.txt");
        File userFile = new File("../bankingSystem406/Database Files/customer.txt");
        File cDFile = new File("../bankingSystem406/Database Files/cds.txt");
        //write to all them
        WriteAccountData(checkingFile, checkingAccounts);
        WriteAccountData(loanFile, loanAccounts);
        WriteAccountData(savingsFile, savingsAccounts);
        WriteAccountData(cDFile, cdAccounts);
        WriteUserData(userFile, userList);
    }

    public static List<Account> GetCheckingData(File file){
        //get data for checking accounts
        var checkingAccounts = new ArrayList<Account>();
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");//for formatting

                checkingAccounts.add(new CheckingAccount(Integer.parseInt(items[0]), Integer.parseInt(items[1]),
                        items[2], Double.parseDouble(items[3]), Boolean.parseBoolean(items[4]), Integer.parseInt(items[5]),
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
        //get user data
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
        //get saved loan account data
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
    public static List<Account> GetCDData(File file){
        //get data on CD accounts
        var CDAccounts = new ArrayList<Account>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                CDAccounts.add(new CD(Integer.parseInt(items[0]),Double.parseDouble(items[1]),
                Double.parseDouble(items[2]),formatter.parse(items[3]),
                formatter.parse(items[4]),Integer.parseInt(items[5])));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return CDAccounts;
    }
    public static List<Check> GetCheckData(File file){
        //get data on CD accounts
        var Checks = new ArrayList<Check>();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] items = line.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                Checks.add(new Check(Integer.parseInt(items[0]),Integer.parseInt(items[1]),
                    Double.parseDouble(items[2]), Boolean.parseBoolean(items[3]),
                    formatter.parse(items[4]), Boolean.parseBoolean(items[5]),
                    Boolean.parseBoolean(items[6])
                    )
                );
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return Checks;
    }
    public static List<Account> GetSavingsData(File file){
        //get data on saving accounts
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
        //write to given file the given account list
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
    public static void WriteUserData(File file, List<User> users) throws IOException {
        //write to file all the users
        FileWriter writer = new FileWriter(file);
        ArrayList<String[]> records = new ArrayList<String[]>();

        for(var user : users)
        {
            records.add(user.accountToArray());
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

