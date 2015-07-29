public class Order {
        private String customerName;
        private String orderNumber;
        private String city;
        private int quantity;

    public Order() {
    }

    public Order(String customerName,String city, String orderNumber, int quantity) {
        this.customerName = customerName;
        this.orderNumber = orderNumber;
        this.city = city;
        this.quantity = quantity;
    }

    public String getCity() {
        return city;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return customerName+";"+city+";"+orderNumber+";"+quantity;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
