package me.rkdals.interface_lambda;

public class DefaultFoo implements Foo5, Bar2 {
    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public void printNameUpperCase() {
        System.out.println(this.getName().toUpperCase());
    } // 재정의 하지 않으면 Foo5와 Bar2가 둘다 같은 이름으로 기본 메소드를 갖고 있기 때문에 에러가 발생한다.

    @Override
    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        Foo5 foo5 = new DefaultFoo("Kang");
        foo5.printName();
        foo5.printNameUpperCase();

        Foo5.printAnyThing();
    }
}
