package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.*;
import org.springframework.stereotype.*;

import javax.inject.*;
import java.util.*;

@Component
@Scope("prototype")
class Door {}
@Component class Engine {}
@Component class TurboEngine extends Engine {}
@Component class SuperEngine extends Engine {}

@Component
@Scope("prototype")
class Car {
    @Value("red") String color;
    @Value("100") int oil;
//    @Autowired
    Engine engine;
//    @Autowired
    Door[] doors;

    public Car(){}

//    생성자는 @Autowired 생략 가능 but 기본 생성자 있을 때는 기본 생성자로 클래스 생성
//    생성자가 여러개일 때는 매개변수 있는 생성자에 @Autowired 써줘야함
    @Autowired
    public Car(@Value("red") String color, @Value("100") int oil, Engine engine, Door[] doors) {
        this.color = color;
        this.oil = oil;
        this.engine = engine;
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}

public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
//      Car car = ac.getBean("car", Car.class); // 타입을 지정하면 형변환 안해도됨. 아래의 문장과 동일
        Car car  = (Car) ac.getBean("car"); // 이름으로 빈 검색
        Car car2 = (Car) ac.getBean(Car.class);   // 타입으로 빈 검색
        System.out.println("car = " + car);
        System.out.println("car2 = " + car2);

    }
}