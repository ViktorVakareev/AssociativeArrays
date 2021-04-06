package com.softuni.fundamentals.AArrays_StreamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine().split(" ")).
                map(e-> Integer.parseInt(e)).collect(Collectors.toList());

        numbers.stream().
                sorted((a,b)->b.compareTo(a)).
                limit(3).
                forEach(e-> System.out.print(e+" "));


    }
}
