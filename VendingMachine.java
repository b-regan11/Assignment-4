import java.util.Scanner;

public class VendingMachine {
    private Snack selectedSnack;
    private int totalAmount;

    public void welcome() {
        System.out.println("Welcome to the Snack Vending Machine!");
        System.out.println("Instructions: ");
        System.out.println("1. Choose a snack. ");
        
        System.out.println("\t a -> Cookies ($4)");
        System.out.println("\t b -> Chips ($3)");
        System.out.println("\t c -> Granola Bar ($2)");
        System.out.println("\t d -> Gum ($1)");
        
        System.out.println("2. Insert $1 bills for payment. ");
        System.out.println("3. Confirm the transaction. ");
        System.out.println("4. Enjoy! ");
    }

    public void selectSnack(char choice) {
        switch (choice) {
            case 'a':
                selectedSnack = new Snack(4, "Cookies");
                break;
            case 'b':
                selectedSnack = new Snack(3, "Chips");
                break;
            case 'c':
                selectedSnack = new Snack(2, "Granola Bar");
                break;
            case 'd':
                selectedSnack = new Snack(1, "Gum");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid snack.");
                System.exit(0);
        }
        if (selectedSnack != null) {
            System.out.println("Selected Snack: " + selectedSnack);
        }
    }

    public void insertMoney() {        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert money into the machine. ($1 bills only)");
        int amount = scanner.nextInt();
        totalAmount = amount;
        //totalAmount = selectedSnack.getCost();

        if (amount >= selectedSnack.getCost()) {
            System.out.println("$" + amount + " inserted. Total: $" + selectedSnack.getCost());
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Do you want to confirm the transaction? yes (y) / no (n): ");
            char snackChoice = scanner2.nextLine().toLowerCase().charAt(0);
            confirmTransaction(snackChoice);
        } else {
            System.out.println("Invalid amount. Please insert $1 bills only.");
            System.exit(0);
        }           
        scanner.close();
    }

    public void confirmTransaction(char choice) {
        switch (choice) {
            case 'Y':
                performTransaction();
                break;
            case 'y':
                performTransaction();;
                break;
            case 'N':
                cancelTransaction();
                break;
            case 'n':
                cancelTransaction();
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }
    }

    public void performTransaction() {
        if (totalAmount >= selectedSnack.getCost()) {
            int change = totalAmount - selectedSnack.getCost();
            System.out.println("Transaction completed. Enjoy your snack!");
            System.out.println("Change: $" + change);
        } else {
            System.out.println("Insufficient funds. Please insert more money");
        }
    }

    private void cancelTransaction() {
        System.out.println("Transaction cancelled. Full refund: $" + totalAmount);
        totalAmount = 0; // resets total amount
    }

    public void departureMessage() {
        System.out.println("Thank you for using the Snack Vending Machine");
    }


    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.welcome();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a snack (a/b/c/d): ");
        char snackChoice = scanner.nextLine().toLowerCase().charAt(0);

        vendingMachine.selectSnack(snackChoice);
        //insert money, confirm / cancel transaction here
        vendingMachine.insertMoney();
        vendingMachine.departureMessage();

        scanner.close();
    }
}