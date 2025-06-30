import java.io.*;
import java.util.ArrayList;



public class Bank {
    private ArrayList<Customer> customers = new ArrayList<>();

    // Add new customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Account created successfully.");
    }

    // Find customer by account number
    public Customer findCustomer(int accountNumber) {
        for (Customer c : customers) {
            if (c.getAccountNumber() == accountNumber) {
                return c;
            }
        }
        return null; // not found
    }

    // Remove customer by account number
    public boolean removeCustomer(int accountNumber) {
        Customer customer = findCustomer(accountNumber);
        if (customer != null) {
            customers.remove(customer);
            return true;
        }
        return false;
    }

    // Show all customers
    public void showAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println(" No customers found.");
            return;
        }

        for (Customer c : customers) {
            c.printDetails();
            System.out.println("------------------");
        }
    }
    public void loadFromFile(String filename) {
    try {
        File file = new File(filename);
        if (!file.exists()) return;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                int acc = Integer.parseInt(parts[0]);
                String name = parts[1];
                double bal = Double.parseDouble(parts[2]);

                customers.add(new Customer(acc, name, bal));
            }
        }

        reader.close();
    } catch (Exception e) {
        System.out.println("Error loading file: " + e.getMessage());
    }
}
    public void saveToFile(String filename) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Customer c : customers) {
            writer.write(c.getAccountNumber() + "," + c.getName() + "," + c.getBalance());
            writer.newLine();
        }
        writer.close();
    } catch (Exception e) {
        System.out.println("Error saving file: " + e.getMessage());
    }
}


}
