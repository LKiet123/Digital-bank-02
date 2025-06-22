package vn.funix.fx23056.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
//customer kế thừa từ User
public class Customer extends User {
//    danh sach tai khoan cua khach hang
    private List<Account> accounts = new ArrayList<>();
//   tra ve danh sach tai khoan cua khach hang
    public List<Account> getAccounts() {

        return accounts;
    }
    //kiem tra xem khach hang co premium hay khong
    public boolean isPremiumCustomer(){
        for(Account account : accounts){
            if (account.isPremiumAccount()) {
                return true;
            }
        }
        return false;
    }

//    them tai khoan moi cho khach hang
    public boolean addAccount(Account newAccount){
        for(Account account : accounts){
            if(account.getAccountNumber().equals(newAccount.getAccountNumber())){
                return false;
            }
        }
        accounts.add(newAccount);
        return true;
    }

//tinh tong so tai khoan cua khach hang
    public double getBalance(){

        return accounts.stream().mapToDouble(Account::getBalance).sum();
    }
//hien thi thong tin cua khach hang, cac tai khoan
    public void displayInformation(){
        System.out.printf("%s | %s | %s |%, .0f đ\n",
                getCustomerId(), getName(),
                isPremiumCustomer() ? "Premium" : "Normal",
                getBalance());

        int i = 1;
        for(Account account : accounts){
            System.out.printf("%d. %s\n", i++, account);
        }
    }

}
