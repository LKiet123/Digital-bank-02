package vn.funix.fx23056.java.asm02.models;

public class Account {
    //    field
    private String accountNumber;
    private double balance;

    public Account() {
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isPremiumAccount(){
        return balance >= 10_000_000;
    }
    @Override
    public String toString() {
        return accountNumber + " |      \t\t\t     " +String.format("%,.0f đ", balance);
    }
}
