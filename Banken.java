import java.util.Scanner;

public class Banken {
	public static int balance = 0;
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {				
        String menu = "Menu:\n1. Check balance\n2. Deposit\n3. Withdraw\n4. Exit";

        boolean run = true;
        System.out.println("Welcome to Bank of Jacob's, what can we do for you?");
        while (run) {
            System.out.println("\n" + menu);
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        exit();
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid input. Please select a valid option.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please select a valid option.");
                input.next();
            }
        }
        input.close();
    }

    public static void checkBalance() {
        System.out.println("Balance: " + balance + " sek.");
    }

    public static void deposit() {
        System.out.println("How much do you want to deposit?(sek)");
        if (input.hasNextInt()) {
            int deposit = input.nextInt();
                if (deposit > 0) {
                    balance += deposit;   
                } else {
                    System.out.println("Enter a positive number larger than 0 please.");
                } 
        } else {
            System.out.println("Invalid input. Please select a valid option.");
            input.next();
        }
    }

    public static void withdraw() {
        System.out.println("How much do you want to withdraw?(sek)");
        if (input.hasNextInt()) {
            int withdraw = input.nextInt();
            if (withdraw > 0) {
                if (withdraw <= balance) {
                    balance -= withdraw;
                } else {
                    System.out.println("You can't withdraw that much!\nMax withdrawal: " + balance + " sek");
                }
            } else {
                System.out.println("Enter a positive number larger than 0 please.");
            }
        } else {
            System.out.println("Invalid input. Please select a valid option.");
            input.next();
        }
    }

    public static void exit() {
        System.out.println("Thank you for using Bank of Jacob's, goodbye!");
    }
}