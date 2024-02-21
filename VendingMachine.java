public class VendingMachine {
    public void welcome() {
        System.out.println("Welcome to the Snack Vending Machine");
        System.out.println("Instructions: ");
        System.out.println("1. Choose a Snack.");

        System.out.println("2. Insert $1 bills for payment. ");
        System.out.println("3. Confirm the transaction. ");
        System.out.println("4. Enjoy! ");
    }
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.welcome();
    }
}