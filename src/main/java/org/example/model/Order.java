package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private String customer;
    private List<Dish> dishList;
    private double total;

    public Order(int orderNumber, String customer) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.dishList = new ArrayList<>();
        this.total = 0.0;
    }

    public void addDish(Dish dish) {
        dishList.add(dish);
        total += dish.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public void viewOrder() {
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Customer: " + customer);
        System.out.println("Dishes:");
        for (Dish dish : dishList) {
            System.out.println(dish);
        }
        System.out.println("Total: R$" + total);
    }
}

