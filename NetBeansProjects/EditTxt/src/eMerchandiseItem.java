
public class eMerchandiseItem {

    private String merchandiseID;
    private String description;
    private double price;
    private int quantity;
    private int totalOrders;
    private Order[] orders = new Order[32];

    public eMerchandiseItem() {
    }

    public eMerchandiseItem(String merchandiseID, String description, double price, int quantity, int totalOrders, Order[] orderarray) {
        this.merchandiseID = merchandiseID;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.totalOrders = totalOrders;
        this.orders = orderarray;
    }

    public String getDescription() {
        return description;
    }

    public String getMerchandiseID() {
        return merchandiseID;
    }

    public Order[] getOrders() {
        return orders;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMerchandiseID(String merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    public void setOrders(Order[] orderarray) {
        this.orders = orderarray;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    @Override
    public String toString() {
        return merchandiseID + ":" + description + ":" + price + ":" + quantity + ":" + totalOrders;
    }

    private Order findOrder(String orderNumber){
        for(int i = 0;i<totalOrders;i++){
                if(orders[i].getOrderNumber().equals(orderNumber)) return orders[i];
        }
        return null;
    }

    public int handleOrder(String orderNumber){
        Order temp = findOrder(orderNumber);
        if(temp != null){
            if(temp.getQuantity() < quantity){
                quantity = quantity - temp.getQuantity();
                temp.setOrderNumber("-1");
                return 0;
            }
        } else return 1;
        return 2;
    }


}
