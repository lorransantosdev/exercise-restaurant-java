package org.example;

import org.example.service.RestaurantService;
import org.example.controller.RestaurantController;

public class App {
    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();
        RestaurantController restaurantController = new RestaurantController(restaurantService);

        restaurantController.start();
        System.out.println("Sistema encerrado.");
    }
}