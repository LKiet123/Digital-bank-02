package vn.funix.fx23056.java.asm02;

import vn.funix.fx23056.java.asm02.models.Account;
import vn.funix.fx23056.java.asm02.models.Bank;
import vn.funix.fx23056.java.asm02.models.Customer;

import java.util.Scanner;

public class Asm02 {
//    doi tuong Bank
    static Bank bank = new Bank();
    private static final String Student_Id = "FX23056 @V2.0.0";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do{
            showMenu(); //hien thi menu
            choice = Integer.parseInt(sc.nextLine());//nhap lua chon chuc nang
            switch (choice){
                case 1 -> addCustomer();
                case 2 -> addAccount();
                case 3 -> displayCustomers();
                case 4 -> searchByName();
                case 5 -> searchByCccd();
                case 0 -> System.out.println("Tam biet!");
                default -> System.out.println("Lua chon khong hop le!");

            }
        }
        while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("+----------+------------------------+-----------+");
        System.out.println("|       NGAN HANG SO | " + Student_Id + "             |");
        System.out.println("+----------+------------------------+-----------+");
        System.out.println("|1. Them khach hang");
        System.out.println("|2. Them tai khoan cho khach hang");
        System.out.println("|3. Hien thi danh sach khach hang");
        System.out.println("|4. Tim kiem theo ten khach hang ");
        System.out.println("|5. Tim kiem theo so cccd");
        System.out.println("|0. Exit");
        System.out.println("+----------+------------------------+-----------+");
        System.out.print("Chon chuc nang: ");
    }
//them khach hang
public static void addCustomer() {
    System.out.print("Nhập tên khách hàng: ");
    String name = sc.nextLine();

    while (true) {
        System.out.print("Nhập số CCCD: ");
        String cccd = sc.nextLine();

        // Kiểm tra nếu người dùng muốn thoát
        if (cccd.equalsIgnoreCase("No")) {
            return;
        }

        // Kiểm tra tính hợp lệ của CCCD (12 số)
        if (cccd.matches("\\d{12}")) {
            Customer customer = new Customer();
            customer.setName(name);
            try {
                customer.setCustomerId(cccd);
            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
                return;
            }
//            them vao danh sach ngan hang
            bank.addCustomer(customer);
            System.out.println("Đã thêm khách hàng " + cccd + " vào danh sách");
            break;
        } else {
            System.out.println("Số CCCD không hợp lệ,");
            System.out.println("Vui lòng nhập lại hoặc nhập 'No' để thoát:");
        }
    }
}
//them tai khoan cho khach hang da co trong ngan hang
    public static void addAccount(){
        System.out.println("Nhap CCCD khach hang: ");
        String cccd = sc.nextLine();
        if(!bank.isCustomerExisted(cccd)){
            System.out.println("Khong ton tai khach hang!");
            return;

        }
        System.out.println("Nhap ma so tai khoan: ");
        String accountNumber = sc.nextLine();
        System.out.println("Nhap so du: ");
        double balance = Double.parseDouble(sc.nextLine());
        if(balance < 50_000){
            System.out.println("So du phai tren 50_000 đ!");
            return;
        }
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);

        boolean add = bank.addAccount(cccd, account);
        if(add){
            System.out.println("Them tai khoan thanh cong!");

        }else {
            System.out.println("Tai khoan da ton tai!");
        }
    }
// hien thi danh sach khach hang
    private static void displayCustomers() {
        for(Customer customer : bank.getCustomers()){
            customer.displayInformation();
        }
    }
//tim kiem theo ten khach hang
    private static void searchByName() {
        System.out.println("Nhap ten khach hang: ");
        String name = sc.nextLine();
        for(Customer customer : bank.searchCustomerByName(name)) {
            customer.displayInformation();
        }
    }
//tim kiem theo so cccd
    private static void searchByCccd() {
        System.out.println("Nhap so cccd: ");
        String cccd = sc.nextLine();
        boolean found = false;
        for(Customer customer : bank.getCustomers()){
            if(customer.getCustomerId().equals(cccd)){
                customer.displayInformation();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Khong tim thay!");
        }
    }
}