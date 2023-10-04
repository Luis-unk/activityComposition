package exFix.entities;

public class OrderItem {

    Order order = new Order();

    private Integer quantity;

    private Double price;

    private Product product;

    public OrderItem(){

    }

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }


    public Double subTotal(Integer quantity, double price){
        double sum = quantity * price;
        return sum;
    }

    public String toString(){
        return null;
    }
}
