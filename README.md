# 🏦 Java ATM Project

A console-based ATM account application built with Core Java. It demonstrates OOP, interfaces, custom exceptions, file handling, and the Reflection API to load a bank-specific class at runtime.

## 📌 Project Overview

The project includes three bank implementations:
- SBI ATM
- ICICI ATM
- HDFC ATM

The current `ATM` entry point asks for the selected class name, account holder name, and initial balance. It then creates an account object using reflection and prints its details.

> **Scope note:** The bank classes implement deposit, withdrawal, and balance methods. The current `ATM.java` entry point does not yet provide an interactive transaction menu to call these methods.

## 🛠️ Technologies and Concepts

- Core Java and Object-Oriented Programming
- Interfaces and method overriding
- Java Reflection API
- Custom checked exceptions
- File handling and Java I/O streams
- Static and instance initialization blocks
- Try-with-resources
- `toString()` method overriding
- Git and GitHub

## 📂 Project Structure

```text
AtmProject/
├── README.md
├── .gitignore
├── sources.txt
│
├── src/
│   └── com/
│       └── nit/
│           └── atmProject/
│               ├── blogic/
│               │   ├── HDFCATM.java
│               │   ├── ICICIATM.java
│               │   └── SBIATM.java
│               │
│               ├── exceptions/
│               │   ├── InsufficientFundsException.java
│               │   └── InvalidAmountException.java
│               │
│               ├── spec/
│               │   └── ATMCard.java
│               │
│               └── user/
│                   └── ATM.java
│
├── bankdetails.txt
├── bankdetailsICICI.txt
└── bankdetailsSBI.txt
```

### Build output (`bin/`)

The `bin/` directory is generated when Java files are compiled. It contains `.class` files arranged in the same package structure as `src/`.

```text
bin/
└── com/
    └── nit/
        └── atmProject/
            ├── blogic/
            │   ├── HDFCATM.class
            │   ├── ICICIATM.class
            │   └── SBIATM.class
            │
            ├── exceptions/
            │   ├── InsufficientFundsException.class
            │   └── InvalidAmountException.class
            │
            ├── spec/
            │   └── ATMCard.class
            │
            └── user/
                └── ATM.class
```

The `bin/` directory and `.class` files are build artifacts and can be regenerated from the source code.

## ✨ Features

### 1. Bank-specific classes

`SBIATM`, `ICICIATM`, and `HDFCATM` each implement the `ATMCard` interface.

### 2. Common ATM contract

The `ATMCard` interface declares:
- `deposit(double amt)`
- `withdraw(double amt)`
- `currentBalance()`

### 3. Runtime class loading

The entry point uses `Class.forName(cardName)` to load the requested bank class. Enter its fully qualified class name, including the package.

### 4. Reflection-based object creation

Reflection locates the public constructor with parameter types `String` and `double`, then invokes it with the account holder name and opening balance.

### 5. Custom exceptions

- `InvalidAmountException` represents invalid transaction amounts.
- `InsufficientFundsException` represents withdrawals exceeding the available balance.

### 6. File-based bank details and account sequence

Each bank class reads bank name, branch name, and IFSC information from its respective text file. It also reads and updates an account-number sequence file using Java data input/output streams.

## ⚙️ Prerequisites

- Java JDK installed
- Windows Command Prompt or another terminal
- Git (optional)

Verify Java installation:

```cmd
java -version
javac -version
```

## 🚀 Compile and Run on Windows

Run the following commands from the project root directory.

### 1. Open the project directory

```cmd
cd /d "C:\Users\ACER\OneDrive\Desktop\Project Workplace\javaAtmProject"
```

### 2. Compile all Java files into `bin`

```cmd
if not exist bin mkdir bin
powershell -NoProfile -Command "$files = Get-ChildItem '.\src' -Recurse -Filter '*.java' | ForEach-Object { $_.FullName }; if ($files) { javac -d '.\bin' $files }"
```

### 3. Start the application

```cmd
java -cp bin com.nit.atmProject.user.ATM
```

### 4. Select a bank

At the `Insert card:` prompt, enter one class name:

**SBI**
```text
com.nit.atmProject.blogic.SBIATM
```

**ICICI**
```text
com.nit.atmProject.blogic.ICICIATM
```

**HDFC**
```text
com.nit.atmProject.blogic.HDFCATM
```

Then enter the account holder name and initial balance.

## 🗂️ Required Configuration Files

The selected bank class reads a configuration file from the project root (the current working directory):

| Bank | Required file |
|---|---|
| HDFC | `bankdetails.txt` |
| ICICI | `bankdetailsICICI.txt` |
| SBI | `bankdetailsSBI.txt` |

Each file should contain the bank name, branch name, and IFSC value on separate lines. Use only dummy/sample values in public repositories. Account sequence `.data` files are created or updated by the application.

## 🔮 Possible Improvements

- Add a user-facing menu for deposit, withdrawal, and balance inquiries.
- Improve amount validation, including consistent rejection of zero amounts.
- Add input validation and clearer error handling.
- Add transaction history and unit tests.
- Provide sample configuration files with dummy values to make setup easier.

## 👨‍💻 Author

**Ayushhh-raj**

GitHub: [@Ayushhh-raj](https://github.com/Ayushhh-raj)

## 📄 License

This project is intended for educational and learning purposes.