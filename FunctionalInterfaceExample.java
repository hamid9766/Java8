package Java8;


import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Function<String, Integer> sum = (a) -> {
            System.out.println("This is Function Interface & it has apply method which is having return type!!!!");
            return a.length();
        };
        System.out.println(sum.apply("Hello"));

        Consumer<String> c = (a) -> {
            System.out.println("This is Consumer Interface & it has accept method which is having void return type!!!!");
            System.out.println(a.length());
        };
        c.accept("Hello World");

        Supplier<String> s = () -> {
            return "This is Supplier Interface & it has get method which is having only return type & no input Argument!!!!";
        };
        System.out.println(s.get());

        Supplier<LocalDateTime> ldt = () -> {
            return LocalDateTime.now();
        };
        System.out.println(ldt.get());


        //Using Lambda
        Function<Integer, Double>  fun = (i)-> Math.sqrt(i);
        System.out.println(fun.apply(4));

        //Method Reference
        Function<Integer, Double> methodRef = Math::sqrt;
        System.out.println("Using Method Reference");
        System.out.println(methodRef.apply(4));


        Function<String, String> stringFunction = String::toLowerCase;
        System.out.println(stringFunction.apply("Java Guides"));

        String[] strArray = {"A", "E", "I", "O", "U", "a", "e", "i", "o", "u"};

        // Using Lambda
        Arrays.sort(strArray, (s1, s2) -> s1.compareToIgnoreCase(s2));

        // Using Method Reference
        Arrays.sort(strArray, String::compareToIgnoreCase);

        //4. Reference to a constructor
        List<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Pineapple");
        fruitList.add("Orange");
        fruitList.add("Watermelon");

        Function<List<String>, Set<String>> methodReference = (fruits) -> new HashSet<>(fruits);
        System.out.println(methodReference.apply(fruitList));

        // Using method Reference
        Function<List<String>, Set<String>> setFunction = HashSet::new;
        System.out.println(setFunction.apply(fruitList));
    }
}
