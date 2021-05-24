package me.rkdals.refer.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER) // 제네릭을 만들 때
@Target(ElementType.TYPE_USE) // 타입을 사용하는 모든곳에 사용 가능하다.
@Repeatable(ChickContainer.class)
public @interface Chicken {
    String value();
}

