package me.rkdals.interface_lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Foo4 {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();

        UnaryOperator<String> hi = (s) -> "hi " + s;
        UnaryOperator<String> hi2 = Greeting::hi; // Greeting.hi 메소드 생성
        UnaryOperator<String> hello = greeting::hello; // Greeting.hello 메소드 생성

        Supplier<Greeting> newGreeting = Greeting::new; // 매개변수가 없는 생성자를 사용
        Greeting kang1 = newGreeting.get();
        System.out.println(kang1.getName()); // null

        Function<String, Greeting> kangGreeting = Greeting::new; // 매개변수가 있는 생성자를 사용
        Greeting kang2 = kangGreeting.apply("Kang");
        System.out.println(kang2.getName()); // Kang

        String[] names = {"Kang", "Min", "Hyeong"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        Arrays.sort(names, (o1, o2) -> o1.compareToIgnoreCase(o2));
        Arrays.sort(names, String::compareToIgnoreCase); // 임의의 인스턴스 메소드 참조
        System.out.println(Arrays.toString(names));
    }
}
