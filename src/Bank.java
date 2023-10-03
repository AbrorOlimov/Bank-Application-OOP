import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
import java.io.*;

public class Bank {
    private List<BankAccount> accounts = new LinkedList<>();

    public void addAccount(BankAccount account){
        accounts.add(account);
        System.out.println("Account added successfully!");
    }

    public BankAccount getAccount(Long accountNumber){
        for (BankAccount account: accounts) {
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public void removeAccount(Long accountNumber){
        BankAccount accountToRemove = null;
        for (BankAccount account: accounts) {
            if(account.getAccountNumber().equals(accountNumber)){
                accountToRemove = account;
                break;
            }
        }
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
            System.out.println("Account with account number: " + accountNumber + " is removed");
        } else {
            System.out.println("Account with account number: " + accountNumber + " does not exist");
        }
    }

    public void sortAccountsByName(){
        Collections.sort(accounts, Comparator.comparing(BankAccount::getAccountHolder));
    }

    public void sortAccountsByAccountNumber(){
        Collections.sort(accounts, Comparator.comparing(BankAccount::getAccountNumber));
    }

    public void readAccountsFromFile(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                if (str[0].equals("SavingsAccount")) {
                    addAccount(new SavingsAccount(Long.parseLong(str[1]), str[2], Double.parseDouble(str[3]),    Double.parseDouble(str[4])));
                } else if (str[0].equals("CheckingAccount")) {
                    addAccount(new CheckingAccount(Long.parseLong(str[1]), str[2], Double.parseDouble(str[3]), Double.parseDouble(str[4])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAccountsToFile(String fileName){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (BankAccount account : accounts) {
                bw.write(account.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAccounts(){
        for (BankAccount account: accounts) {
            System.out.println(account);
        }
    }

}
