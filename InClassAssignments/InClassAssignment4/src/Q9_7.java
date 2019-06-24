import java.util.Date;

class Q9_7 {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.format("balance: %.2f\nmonthly interest: %.2f\ndate created: %s\n",
                account.getBalance(), account.getMonthlyInterest(), account.getDateCreated().toString());
    }
}


class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date();

    Account() {
    }

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    double getAnnualInterestRate() {
        return annualInterestRate;
    }

    void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    Date getDateCreated() {
        return dateCreated;
    }

    double getMonthlyInterestRate() {
        return annualInterestRate / 1200;
    }

    double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    void deposit(double amount) {
        balance += amount;
    }

}