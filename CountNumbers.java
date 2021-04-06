package com.softuni.fundamentals.AArrays_StreamAPI;

import java.net.Inet4Address;
import java.util.*;

public class CountNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).
                mapToDouble(e -> Double.parseDouble(e)).toArray();
        int counter = 0;

        Map<Double, Integer> num = new TreeMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!num.containsKey(numbers[i])) {
                num.put(numbers[i], 0);
            }
                num.put(numbers[i], num.get(numbers[i])+1);

        }
        for (Map.Entry<Double, Integer> n : num.entrySet()) {
            System.out.printf("%.0f -> %d%n",n.getKey(),n.getValue());
        }

    }
}
