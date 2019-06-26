import java.util.Date;
import java.util.Scanner;

public class Q10_7 {
    public static void main(String[] args) {
        ATMMachine atmMachine = new ATMMachine();
        atmMachine.run();
    }
}

class ATMMachine {
    private Scanner input = new Scanner(System.in);
    private Account[] accounts = new Account[10];
    private int id;

    ATMMachine() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }
    }

    void run() {
        int menuChoice;
        while (true) {
            id = getID();
            System.out.println("Account ID: " + id);
            menuChoice = displayMenu();
            while (menuChoice != 4) {
                if (menuChoice == 1) {
                    System.out.println("Balance: " + accounts[id].getBalance());
                } else if (menuChoice == 2) {
                    withdrawFunds();
                } else if (menuChoice == 3) {
                    depositFunds();
                }
                menuChoice = displayMenu();
            }
        }
    }

    /* gets ID from user */
    private int getID() {
        int id;
        System.out.print("Enter ID: ");
        id = input.nextInt();
        while (!validID(id)) {
            System.out.println("Not a valid ID");
            System.out.print("Enter ID: ");
            id = input.nextInt();
        }
        return id;
    }

    /* checks if ID is valid */
    private boolean validID(int id) {
        for (Account account : accounts) {
            if (id == account.getId())
                return true;
        }
        return false;
    }

    /* displays menu and get user choice */
    private int displayMenu() {
        int choice;

        System.out.println("Enter 1 to view current Balance");
        System.out.println("Enter 2 to withdraw funds");
        System.out.println("Enter 3 to deposit funds");
        System.out.println("Enter 4 to exit this menu");
        System.out.print("Enter you choice: ");
        choice = input.nextInt();
        while (!(choice >= 1 && choice <= 4)) {
            System.out.println("Invalid Choice");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
        }
        return choice;
    }

    private void withdrawFunds() {
        double amount;
        System.out.print("Enter amount to withdraw: ");
        amount = input.nextDouble();
        accounts[id].withdraw(amount);
    }

    private void depositFunds() {
        double amount;
        System.out.print("Enter amount to deposit: ");
        amount = input.nextDouble();
        accounts[id].deposit(amount);
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
