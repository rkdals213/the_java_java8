package me.rkdals.interface_lambda;

public class Foo {
    public static void main(String[] args) {
        // 익명 내부 클래스
        RunSomething runSomething1 = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello World");
            }
        };
        runSomething1.doIt();

        RunSomething runSomething2 = () -> System.out.println("Hello World");
        // 람다 표현식
        // 함수형 인터페이스를 인라인로 구현한 오브젝트로 볼 수 있음
        runSomething2.doIt();

        int baseNumber = 10;
        RunSomething2 runSomething21 = number -> number + baseNumber;
        // 외부 변수를 참조함 으로 순수 함수라고 볼 수 없다
        System.out.println(runSomething21.doIt(1));
    }
}
