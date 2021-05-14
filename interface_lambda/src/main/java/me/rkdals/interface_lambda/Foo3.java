package me.rkdals.interface_lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo3 {
    public static void main(String[] args) {
        Foo3 foo = new Foo3();
        foo.run();
    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11 -> 섀도잉
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11 -> 섀도잉
            }
        };

        IntConsumer printInt = (i) -> {
//            int baseNumber = 11; // 에러
            System.out.println(i + baseNumber);
        };
        /*
        람다의 익명클래스와 로컬클래스와의 공통점
            - 외부 변수를 참조할 수 있다 -> 외부 변수가 사실상 final(effective final)인 경우
        차이점
            - 람다는 섀도잉이 안된다 -> 익명클래스와 로컬클래스는 그 자체가 하나의 scope이다. 하지만 람다는 별도의 scope가 아니다.
            - 외부 변수가 effective final이 아닌경우 참조 불가능
         */
        printInt.accept(10);

//        baseNumber++; // effective final이 아니게 되어서 람다에서 참조가 불가능
    }
}
