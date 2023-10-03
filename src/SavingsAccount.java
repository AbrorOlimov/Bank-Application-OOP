public class SavingsAccount extends BankAccount implements InterestRate{
    double interestRate;

    public SavingsAccount(long accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return interestRate * getBalance();
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException{
        if(getBalance() >= amount && getBalance() - amount >= 0){
            setBalance(getBalance() - amount);
        }else {
            throw new InsufficientFundsException("The withdrawal limit has been exceeded");
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                "} " + super.toString();
    }
}
