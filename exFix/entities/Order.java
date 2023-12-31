package exFix.entities;

import exFix.entities.Enum.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;

    private OrderStatus status;

    private List<OrderItem> items = new ArrayList<>();

    public Order(){

    }

    public Order(Date moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total() {
        double res = 0;
        for (int i = 0; i < items.size();i++){
            res += items.get(i).subTotal(items.get(i).getQuantity(), items.get(i).getPrice());
        }
        return res;
    }

//    public String toString(){
//
//    }


}
