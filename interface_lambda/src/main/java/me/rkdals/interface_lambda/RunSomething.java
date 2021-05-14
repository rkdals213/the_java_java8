package me.rkdals.interface_lambda;

@FunctionalInterface
public interface RunSomething {
    void doIt();

//    void doIt2(); // 추상 메소드가 2개 이상이므로 에러가 남

    static void printName() {
        System.out.println("Kang");
    }

    default void printAge() {
        System.out.println("30");
    }
}

/*
 추상 메소드가 한개만 있을대 함수형 인터페이스임
 static, default 함수가 있어도 상관이 없음
 오로지 추상메소드만 중요
 */
