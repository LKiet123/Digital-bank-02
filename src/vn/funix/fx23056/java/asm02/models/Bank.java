package vn.funix.fx23056.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    //    tạo id duy nhất cho mỗi đối tượng bank
    private final String id = UUID.randomUUID().toString();

    //    ds những khách hàng của ngân hàng
    private final List<Customer> customers = new ArrayList<>();
//them khach hang moi vao ngan hang
    public void addCustomer(Customer newCustomer){
        if(!isCustomerExisted(newCustomer.getCustomerId())){
            customers.add(newCustomer);
        }
    }
//    kiem tra xem khach hang co ton tai hay khong thong qua cccd
    public boolean isCustomerExisted(String cccd){
        return customers.stream().anyMatch(customer -> customer.getCustomerId().equals(cccd));
    }

//    lay ds khach hang trong ngan hang
    public List<Customer> getCustomers(){
//        tra ve danh sach khach hang
        return customers;
    }
//tim kiem theo ten khach hang
    public List<Customer> searchCustomerByName(String name){
        List<Customer> result = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(customer);
            }
        }
        //tra ve danh sach khach hang
        return result;
    }
//    them tai khoan cho khach hang
//    tim khach hang theo cccd va them tai khoan moi
    //cccd cua khach hang can them tai khoan
//    account cua tai khoan moi
    public boolean addAccount(String cccd, Account account){
        Customer customer = findCustomerByCccd(cccd);
        if(customer != null){
            return customer.addAccount(account);
        }
        return false;
    }

//    tim khach hang theo cccd
//    tra ve khach hang neu tim thay, null khong tim thay
    private Customer findCustomerByCccd(String cccd){

        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(cccd))
                .findFirst().orElse(null);
    }
}
