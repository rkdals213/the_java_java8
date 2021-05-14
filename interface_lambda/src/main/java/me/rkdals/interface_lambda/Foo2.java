package me.rkdals.interface_lambda;

import java.util.function.*;

public class Foo2 {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> plus5 = (i) -> i + 5;
        System.out.println(plus5.apply(1));

        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        Function<Integer, Integer> multiply2AndAdd10 = plus5.compose(multiply2); // multiply2 실행 후 add10
        System.out.println(multiply2AndAdd10.apply(2));

        Function<Integer, Integer> add10AndThenMultiply = plus5.andThen(multiply2); // add10 실행 후 multiply2
        System.out.println(add10AndThenMultiply.apply(2));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        BiFunction<Integer, Integer, Integer> multiply = (i, j) -> i * j;
        System.out.println(multiply.apply(3, 4));

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        Consumer<Integer> printT = System.out::println;
        printT.accept(10);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        Predicate<String> startWithKang = (s) -> s.startsWith("Kang");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        UnaryOperator<Integer> plus4 = (i) -> i + 4;
        UnaryOperator<Integer> multiply4 = (i) -> i * 4;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        BinaryOperator<Integer> plus = (i, j) -> i + j;
        System.out.println(plus.apply(10, 20));
    }
}
