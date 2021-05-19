package me.rkdals.refer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Kang");
        names.add("Min");
        names.add("Hyeong");

        Stream<String> stringNames1 = names.stream().map(String::toUpperCase);
//        names.forEach(System.out::println);
        stringNames1.forEach(System.out::println);
        stringNames1.forEach(System.out::println);

        System.out.println("=================================================");

        Stream<String> stringNames2 = names.stream().map(s -> {
            System.out.println(s); // 출력이 되지 않음
            return s.toUpperCase();
        });

        List<String> stringNames3 = names.stream().map(s -> {
            System.out.println(s); // 출력이 됨
            return s.toUpperCase();
        }).collect(Collectors.toList()); // 종료형 오퍼레이터를 실행한 이후에는 stream 안에 내용이 처리가 된다.

        System.out.println("=================================================");

        stringNames3.forEach(System.out::println);

        System.out.println("=================================================");

        names.forEach(System.out::println);

        System.out.println("=================================================");

        List<String> collect = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList()); // 병렬처리

        System.out.println("=================================================");

        List<String> collect2 = names.stream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        System.out.println("=================================================");

        collect.forEach(System.out::println);

    }
}
