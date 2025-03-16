package org.example.service;

import org.example.model.Dish;
import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private List<Dish> menu = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1;

    public void addDishToMenu(Dish dish) {
        menu.add(dish);
    }

    public void removeDishFromMenu(String dishName) {
        menu.removeIf(d -> d.getName().equalsIgnoreCase(dishName));
    }

    public void viewMenu() {
        if (menu.isEmpty()) {
            System.out.println("Menu está vazio");
        } else {
            menu.forEach(System.out::println);
        }
    }

    public Order createOrder(String customer, List<String> dishNames) {
        Order order = new Order(orderCounter++, customer);
        for (String name : dishNames) {
            menu.stream()
                    .filter(dish -> dish.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .ifPresent(order::addDish);
        }
        orders.add(order);
        return order;
    }

    public void viewAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("Nenhum pedido foi feito.");
        } else {
            orders.forEach(Order::viewOrder);
        }
    }
}
