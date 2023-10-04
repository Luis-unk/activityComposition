package exFix;

import exFix.entities.Client;
import exFix.entities.Enum.OrderStatus;
import exFix.entities.Order;
import exFix.entities.OrderItem;
import exFix.entities.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name, email, birthDate);


        Date date = new Date(System.currentTimeMillis());
        Date moment = date;
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String orderStatus = sc.next();
        Order order = new Order(moment, OrderStatus.valueOf(orderStatus));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.print("Product Name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product Price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            Product product = new Product(productName, price);
            OrderItem orderItem = new OrderItem(quantity, price, product);
            order.addItem(orderItem);
        }

        System.out.println("ORDER SUMARY: ");
        System.out.println("Order Moment: " + sdf2.format(order.getMoment()));
        System.out.println("Order Status: " + OrderStatus.valueOf(orderStatus));
        System.out.println("Client: " + client);
        System.out.println("Order Items: ");

        for (int i = 0; i < n; i ++) {
            System.out.print(order.getItems().get(i).getProduct().getNameProduct() + ", ");
            System.out.print("Quantity: " + order.getItems().get(i).getQuantity());
            System.out.print(", Subtotal: " + String.format("$%.2f", order.getItems().get(i).subTotal(order.getItems().get(i).getQuantity(),
                    order.getItems().get(i).getPrice())));
            System.out.println();
        }

        System.out.println("Total price: " + String.format("$%.2f", order.total()));

        sc.close();
    }
}

