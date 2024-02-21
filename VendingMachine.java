import java.util.Scanner;

public class VendingMachine {
    private Snack selectedSnack;

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


    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.welcome();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a snack (a/b/c/d): ");
        char snackChoice = scanner.nextLine().toLowerCase().charAt(0);

        vendingMachine.selectSnack(snackChoice);

        scanner.close();
    }
}