package me.rkdals.interface_lambda;

public interface Bar extends Foo5{
    void printNameUpperCase(); // Foo5에서 제공하는 기본 구현체를 제공하고 싶지 않은 경우 추상 클래스로 오버라이딩 -> Bar를 상속받는 클래스가 재정의하면됨
}
