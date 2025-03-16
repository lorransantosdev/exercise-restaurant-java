package org.example.controller;

import org.example.model.Dish;
import org.example.model.Order;
import org.example.service.RestaurantService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RestaurantController {
    private final Scanner scanner = new Scanner(System.in);
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public void start() {
        boolean running = true;
        while(running) {
            showOptions();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addDisk();
                case 2 -> removeDisk();
                case 3 -> restaurantService.viewMenu();
                case 4 -> addOrder();
                case 5 -> restaurantService.viewAllOrders();
                case 6 -> running = false;
                default -> System.out.println("Opção invalida, tente novamente");
            }
        }

        scanner.close();
    }

    public void showOptions() {
        System.out.println("\n--- Sistema do Restaurante ---");
        System.out.println("1. Adicionar um novo prato ao menu");
        System.out.println("2. Remover prato do Menu");
        System.out.println("3. Mostrar Menu");
        System.out.println("4. Criar pedido");
        System.out.println("5. Ver todos os pedidos");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void addDisk() {
        System.out.print("Enter dish name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        restaurantService.addDishToMenu(new Dish(name, price, description));
    }

    public void removeDisk() {
        System.out.print("Enter dish name to remove: ");
        String removeName = scanner.nextLine();
        restaurantService.removeDishFromMenu(removeName);
    }

    public void addOrder() {
        System.out.print("Enter customer name: ");
        String customer = scanner.nextLine();
        List<String> dishNames = new ArrayList<>();
        System.out.print("Enter dish names (comma-separated): ");
        String[] dishes = scanner.nextLine().split(",");
        Collections.addAll(dishNames, dishes);
        Order order = restaurantService.createOrder(customer, dishNames);
        order.viewOrder();
    }

}

