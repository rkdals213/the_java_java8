package me.rkdals.refer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApp1 {
    public static void main(String[] args) {
        OnlineClass spring_boot = new OnlineClass(1, "spring boot", false);
//        Duration studyDuration1 = spring_boot.getProgress().getStudyDuration(); // 에러 발생 -> null이 리턴되기 때문
//        System.out.println(studyDuration1);

//        spring_boot.setProgressOptional(null); // null pointer 에러

        Optional.of(10);

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        Optional<OnlineClass> jpa = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        System.out.println(spring.isPresent());
        System.out.println(spring.isEmpty());

        OnlineClass onlineClass1 = spring.get();
        System.out.println(onlineClass1.getTitle());

//        OnlineClass onlineClass2 = jpa.get(); // no such value exception
//        System.out.println(onlineClass2.getTitle());

        spring.ifPresent(oc -> System.out.println(oc.getTitle()));
        jpa.orElse(createNewClasses());  // oprional에 객체가 있던 없던 항상 createNewClasses가 실행이 됨
        jpa.orElseGet(OptionalApp1::createNewClasses);  // oprional에 없는 경우에만 createNewClasses가 실행이 됨
//        jpa.orElseThrow(IllegalAccessError::new); // oprional에 없는 경우에 에러를 던짐

        Optional<OnlineClass> onlineClass2 = spring.filter(oc -> oc.getId() > 10);
        Optional<OnlineClass> onlineClass3 = spring.filter(oc -> oc.getId() > 0);
        System.out.println(onlineClass2); // 비어있음
        System.out.println(onlineClass3); // 존재함

        Optional<Integer> integer = spring.map(OnlineClass::getId);
        System.out.println(integer);

        Optional<Progress> progress = spring.flatMap(OnlineClass::getProgressOptional); // optional로 리턴된 progress를 flatmap으로 꺼낸다



    }

    private static OnlineClass createNewClasses() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
