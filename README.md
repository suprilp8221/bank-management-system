# bank-management-system
This is a terminal-based Java project that simulates basic banking operations. It allows users to create and manage bank accounts with features like:

---

## 📌 Features

- 🆕 Create new bank accounts
- 💰 Deposit money into an account
- 💸 Withdraw money from an account
- 📊 Check account balance
- ❌ Delete an account
- 📋 View all account details
- 💾 Save and load data from `accounts.txt`

---

## 🛠 Technologies Used

- Java (JDK 17+)
- OOP (Object-Oriented Programming)
- File I/O (BufferedReader, BufferedWriter)
- ArrayList to manage multiple customers
- Terminal-based input using `Scanner`

---

## 📂 Project Structure

bank-management-system/
│
├── Main.java # Menu and user interaction
├── Bank.java # Handles all bank-level operations
├── Customer.java # Represents each individual bank customer
├── accounts.txt # File that stores saved customer data
├── README.md # Project description and usage


---

## ▶️ How to Run

### 📦 Compile:

```bash
javac *.java

java Main

===== BANK MANAGEMENT SYSTEM =====
1. Create Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Remove Account
6. Show All Accounts
7. Exit
