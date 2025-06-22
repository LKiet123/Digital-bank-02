package vn.funix.fx23056.java.asm02.models;

//lop truu tuong User
public abstract class User {
//    ten nguoi dung
    private String name;
//    cccd
    private String customerId;

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCustomerId() {

        return this.customerId;
    }

     //cccd cua nguoi dung phai la 12 so
    public void setCustomerId(String customerId) throws Exception {
        if (customerId != null && customerId.matches("\\d{12}")) {
            this.customerId = customerId;
        } else {
            throw new Exception("So CCCD khong hop le");
        }
    }
}
