package me.rkdals.refer.annotation;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("갈릭")
@Chicken("후라이드")
public class App {
    public static void main(String[] args) {
//        List<@Chicken String> names = Arrays.asList("kang");  // TYPE_USE로 애노테이션 타겟을 잡았기때문에 가능함
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> System.out.println(c.value()));

        ChickContainer chickContainer = App.class.getAnnotation(ChickContainer.class);
        Arrays.stream(chickContainer.value()).forEach(c -> System.out.println(c.value()));
   }

//    static class FeelsLikeChicken<@Chicken T> { // TYPE_PARAMETER로 애노테이션 타겟을 잡았기때문에 가능함
//        static public <@Chicken C> void print(@Chicken C c) {
//            System.out.println(c);
//        }
//    }
}
