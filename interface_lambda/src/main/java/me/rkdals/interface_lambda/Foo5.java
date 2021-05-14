package me.rkdals.interface_lambda;

public interface Foo5 {
    void printName();

    /*
    @ImplSpec
    이 구현체는 getName()으로 가져와서 문자열을 대문자로 바꿔 출력한다
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }
    // 내가 만든 인터페이스에만 쓸 수 있다.  이미 제공된 인터페이스에는 추가 불가능

//    default String toString() {} // 오류
    String toString();

    String getName();

    static void printAnyThing() {
        System.out.println("Foo");
        int max = Math.max(3, 4);
    }
}
