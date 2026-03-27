//DigitalWallet
import java.util.Scanner;

class DigitalWallet { 
    private double balance;
    private String currency;   

  
    public DigitalWallet() { //default constructor
        balance  = 0.0;
        currency = "PKR";      
    }

    // Parameterized constructor
    public DigitalWallet(double b, String c) {
        balance  = b;
        currency = c;
    }

    public void addMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to add: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        balance += amount;
        System.out.println("Money added! Current balance: " + currency + " " + balance);
    }

    public void spendMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to spend: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance! Current balance: " + currency + " " + balance);
        } else {
            balance -= amount;
            System.out.println("Spent " + currency + " " + amount + 
                             ". Remaining balance: " + currency + " " + balance);
        }
    }

    public void showBalance() {
        System.out.println("Currency: " + currency);
        System.out.println("Balance : " + currency + " " + balance);
    }
}

public class DigitalWalletRunner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DigitalWallet wallet1 = new DigitalWallet();          
        
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n DIGITAL WALLET ");
            System.out.println("1. Add Money");
            System.out.println("2. Spend Money");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: wallet1.addMoney();   break;
                case 2: wallet1.spendMoney(); break;
                case 3: wallet1.showBalance(); break;
                case 4: System.out.println("Exiting wallet. Goodbye!"); break;
                default: System.out.println("Invalid choice. Choose between 1 to 4 only.");
            }
        }
        sc.close();
    }
}