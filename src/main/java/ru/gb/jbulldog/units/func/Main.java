package ru.gb.jbulldog.units.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
//        Stream<Integer> integerStream = integers.stream()
//                .filter(p -> p%2==0)

        /*ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1,2,3));
        al.stream()
                .filter(item -> item != 2)
                .collect(Collectors.toList());
        System.out.println();*/

        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1,2,3));
        al.stream();

        Stream.of();
        Stream.builder();
        Stream.empty();
        al = (ArrayList<Integer>) Stream.generate(new Random()::nextInt).limit(10).collect(Collectors.toList());
        //Stream.concat();

        System.out.println(al);
    }
}
