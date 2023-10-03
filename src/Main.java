import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO BANK ACCOUNT MANAGEMENT APPLICATION!");
        while (true){
            System.out.println("1. Add Savings Account \n2. Add Checking Account \n3. Deposit Money \n4. Withdraw Money " +
                    "\n5. Display Accounts \n6. Save Accounts to File \n7. Load Accounts from File \n8. Sort by account name " +
                    "\n9. Sort by account number \n10.Exit");

            System.out.println("Enter your choice: ");
            int input = scanner.nextInt();

            switch (input){
                case 1:
                    System.out.println("Enter Account Number: ");
                    Long accountNumber = scanner.nextLong();

                    System.out.println("Enter Account Holder: ");
                    String accountHolder = scanner.next();
                    scanner.next();

                    System.out.println("Enter Balance: ");
                    Double balance = scanner.nextDouble();

                    System.out.println("Enter Interest Rate: ");
                    Double interestRate = scanner.nextDouble();

                    SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolder, balance, interestRate);
                    bank.addAccount(savingsAccount);
                    System.out.println("Savings account added successfully!");
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("Enter Account Number: ");
                    Long checkingAccountNumber = scanner.nextLong();

                    System.out.println("Enter Account Holder: ");
                    String checkingAccountHolder = scanner.next();
                    scanner.next();

                    System.out.println("Enter Balance: ");
                    Double checkingBalance = scanner.nextDouble();

                    System.out.println("Enter Overdraft Limit: ");
                    Double checkingOverdraftLimit = scanner.nextDouble();

                    CheckingAccount checkingAccount = new CheckingAccount(checkingAccountNumber, checkingAccountHolder, checkingBalance, checkingOverdraftLimit);
                    bank.addAccount(checkingAccount);
                    System.out.println("Checking account added successfully!");
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("Enter Account Number: ");
                    Long depositAccountNumber = scanner.nextLong();
                    System.out.println("Enter Amount: ");
                    Double depositAmount = scanner.nextDouble();
                    BankAccount depositAccount = bank.getAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                        System.out.println("Amount deposited successfully!");
                        Thread.sleep(1000);

                    } else {
                        System.out.println("Account not found.");
                        Thread.sleep(1000);

                    }
                    break;
                case 4:
                    System.out.println("Enter Account Number: ");
                    Long withdrawAccountNumber = scanner.nextLong();
                    System.out.println("Enter Amount: ");
                    Double withdrawAmount = scanner.nextDouble();
                    BankAccount withdrawAccount = bank.getAccount(withdrawAccountNumber);
                    if (withdrawAccount != null){
                        withdrawAccount.withdraw(withdrawAmount);
                        System.out.println("Amount withdrawn successfully!");
                        Thread.sleep(1000);
                    } else {
                        System.out.println("Account not found.");
                        Thread.sleep(1000);
                    }
                    break;
                case 5:
                    System.out.println("-----------ACCOUNTS-----------");
                    bank.viewAccounts();
                    Thread.sleep(1000);
                    break;
                case 6:
                    System.out.println("Enter the filename to save accounts (e.g., output.csv): ");
                    String saveFileName = scanner.next();
                    bank.writeAccountsToFile(saveFileName);
                    System.out.println("Accounts saved to file successfully!");
                    Thread.sleep(1000);
                    break;
                case 7:
                    System.out.println("Enter the filename to load accounts (e.g., input.csv): ");
                    String loadFileName = scanner.next();
                    bank.readAccountsFromFile(loadFileName);
                    System.out.println("Accounts loaded from file successfully!");
                    Thread.sleep(1000);
                    break;
                case 8:
                    bank.sortAccountsByName();
                    System.out.println("Accounts sorted by name!");
                    Thread.sleep(1000);
                    break;
                case 9:
                    bank.sortAccountsByAccountNumber();
                    System.out.println("Accounts sorted by account number!");
                    Thread.sleep(1000);
                    break;
                case 10:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input!");
                    Thread.sleep(1000);
            }
        }
    }
}