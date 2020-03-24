package cn.roy.java8.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Roy
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red",120));
        apples.add(new Apple("red",220));
        apples.add(new Apple("green",160));
        apples.add(new Apple("green",260));
        apples.sort(Apple::getWeight);
        int i = 0;
        filter(apples, (Apple a) -> a.getColor().equals("green"));

        format(apples,(a)-> a.getColor()+"|"+a.getWeight()+i);

        format(apples,(a)-> a.getWeight()+"");
    }

    public static void format(List<Apple> apples,AppleFomatter f){
        for (Apple apple : apples) {
            String str = f.format(apple);
            System.out.println(str);
        }
    }

    public static <T> void filter(List<T> apples, Predicate<T> p){
        for (T apple : apples) {
            if (p.test(apple)){
                System.out.println(apple);
            }
        }
    }
}

interface AppleFomatter{
    String format(Apple apple);
}

class Apple{
    private String color;
    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
