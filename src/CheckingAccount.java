public class CheckingAccount extends BankAccount{
    double overdraftLimit;

    public CheckingAccount(long accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }
    @Override
    public void withdraw(double amount) throws InsufficientFundsException{
        double totalBalance = getBalance() + overdraftLimit;
        if(totalBalance >= amount && getBalance() >= 0){
            setBalance(getBalance() - amount);
        } else {
            throw new InsufficientFundsException("Overdraft limit has been exceeded");
        }
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "overdraftLimit=" + overdraftLimit +
                "} " + super.toString();
    }
}
