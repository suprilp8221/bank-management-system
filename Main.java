import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        bank.loadFromFile("accounts.txt");
        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Remove Account");
            System.out.println("6. Show All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();  // clear buffer
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double bal = sc.nextDouble();
                    Customer newCustomer = new Customer(accNo, name, bal);
                    bank.addCustomer(newCustomer);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int accDep = sc.nextInt();
                    Customer cDep = bank.findCustomer(accDep);
                    if (cDep != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depAmt = sc.nextDouble();
                        cDep.deposit(depAmt);
                        System.out.println(" Money deposited.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int accWith = sc.nextInt();
                    Customer cWith = bank.findCustomer(accWith);
                    if (cWith != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withAmt = sc.nextDouble();
                        boolean success = cWith.withdraw(withAmt);
                        if (success) {
                            System.out.println(" Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int accBal = sc.nextInt();
                    Customer cBal = bank.findCustomer(accBal);
                    if (cBal != null) {
                        System.out.println("Your Balance: ₹" + cBal.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number to remove: ");
                    int accDel = sc.nextInt();
                    boolean removed = bank.removeCustomer(accDel);
                    if (removed) {
                        System.out.println("Account removed.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    bank.showAllCustomers();
                    break;

                case 7:
                    System.out.println("Thank you for using the Bank System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);
        bank.saveToFile("accounts.txt");
        sc.close();
    }
}
