package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<Double>> products = new LinkedHashMap<>();
        String input = scanner.nextLine();
        double total = 0.0;
        while (!input.equals("buy")) {
            String[] commandsArray = input.split(" ");
            String product = commandsArray[0];
            double price = Double.parseDouble(commandsArray[1]);
            double quantity = Double.parseDouble(commandsArray[2]);

            if (products.containsKey(product)) {
                double oldQuantity = products.get(product).get(1);
                products.get(product).add(price);
                products.get(product).add(oldQuantity + quantity);
                products.get(product).remove(0);
                products.get(product).remove(0);
            } else {
                products.putIfAbsent(product, new ArrayList<>());
                products.get(product).add(price);
                products.get(product).add(quantity);
            }

            input = scanner.nextLine();
        }

        products.entrySet().stream().
                forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), (e.getValue().get(1)) * e.getValue().get(0)));
    }
}
