package me.rkdals.interface_lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("kang");
        names.add("min");
        names.add("hyeong");

//        ///////////////////////////////////////////////////////////////////////////////////////////////////
//
//        names.forEach(System.out::println);
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////////
//
//        Spliterator<String> spliterator = names.spliterator();
//        Spliterator<String> stringSpliterator = spliterator.trySplit();
//        while (spliterator.tryAdvance(System.out::println)) ;
//        System.out.println("=========================");
//        while (stringSpliterator.tryAdvance(System.out::println)) ;
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////////
//
//        List<String> k = names.stream().map(String::toUpperCase)
//                .filter(s -> s.startsWith("k"))
//                .collect(Collectors.toList());
//
//        System.out.println(k);
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////////
//
//        names.removeIf(s -> s.startsWith("k"));
//        names.forEach(System.out::println);
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////////

        Comparator<String> comparator = String::compareToIgnoreCase;
        names.sort(comparator.reversed());
        System.out.println(names);
    }
}
