//package com.fastcampus.ch3;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
////Component명은 클래스 이름 첫글자 소문자한 이름 등록
////@Component("engine")
//class Engine {}    // <bean id="engine" class="com.fastcampus.ch3.Engine"/>
//@Component class SuperEngine extends Engine{}
//@Component class TurboEngine extends Engine{}
//@Component class Door {}
//@Component
//class Car {
//    @Value("red") String color;
//    @Value("100") int oil;
//    @Autowired @Qualifier("superEngine") // = @Resource(name="superEngine")
//    Engine engine;   // byType -  타입으로 먼저 검색, 여러 개면 이름으로 검색 (superEngine, turboEngine)
//    @Autowired
//    Door[] doors;
//
//    public Car() {} // 기본 생성자 꼭 만들어 주기
//
//    public Car(String color, int oil, Engine engine, Door[] doors) {
//        this.color = color;
//        this.oil = oil;
//        this.engine = engine;
//        this.doors = doors;
//    }
//
//    public Car setColor(String color) {
//        this.color = color;
//        return this;
//    }
//
//    public Car setOil(int oil) {
//        this.oil = oil;
//        return this;
//    }
//
//    public Car setEngine(Engine engine) {
//        this.engine = engine;
//        return this;
//    }
//
//    public Car setDoors(Door[] doors) {
//        this.doors = doors;
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "color='" + color + '\'' +
//                ", oil=" + oil +
//                ", engine=" + engine +
//                ", doors=" + Arrays.toString(doors) +
//                '}';
//    }
//}//end Car
//
//public class SpringDiTest {
//    public static void main(String[] args) {
//        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
////        Car car = (Car) ac.getBean("car");      // byName, 아래와 같은 문장
//        Car car = ac.getBean("car", Car.class);       // byName, class type 정보 주기
////        Car car2 = (Car) ac.getBean(Car.class);             // byType
////        Engine engine = (Engine)ac.getBean("engine");     // byName
////        Engine engine = (Engine)ac.getBean(Engine.class);     // byType
////      Type이 여러개일 경우 type으로 찾으면 에러 (expected single matching bean but found 3)  -> Name으로 bean 가져오기
////        Door door = (Door) ac.getBean("door");
//
//
////        car.setColor("red");
////        car.setOil(100);
////        car.setEngine(engine);
////        car.setDoors(new Door[]{ac.getBean("door", Door.class), (Door) ac.getBean("door")});
//
//        System.out.println("car = " + car);     // soutv, toString 출력
//    }
//}
