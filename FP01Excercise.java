package Java8.in28Minutes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP01Excercise {
    public static void main(String[] args) {


        List<Integer> list = List.of(12,9,13,4,6,2,12,15);
        List<String> courseNames = List.of("Spring", "Spring Boot", "Microservices", "Aws","Aws", "Go","Spring MVC" ,"Java", "Python");

        // Print Odd Numbers
        Function<List<Integer>,List<Integer>> fun = num -> num.stream().filter(n -> n %2 !=0).collect(Collectors.toList());
        System.out.println(fun.apply(list));

        // list.stream().filter(n -> n %2 !=0).forEach(System.out::println);
        List<Integer> l = list.stream().filter(n -> n %2 !=0).collect(Collectors.toList());
        System.out.println("Print Odd Numbers -> " + l);

        // PrintOddNumber and cube
        List<Integer> a = list.stream().filter(n -> n%2!=0).map(num -> num * num *num).collect(Collectors.toList());
        System.out.println("Print Odd Numbers and cube -> " + a);

        // Print list that contains only spring
        List<String> s = courseNames.stream().filter(n -> n.contains("Spring")).collect(Collectors.toList());
        System.out.println("List that contains only spring word -> " + s);

        // Course Length should be greater than 3
        List<String> len = courseNames.stream().filter(n -> n.length() >=3).collect(Collectors.toList());
        System.out.println("Course Length should be greater than 3 -> " + len);


        // 2 ways of calculating sum using Integer class which has sum method and using lambda
        int sum = list.stream().reduce(0,Integer::sum);
        int sum1 = list.stream().reduce(0,(x,y) -> x+y);
        System.out.println("Sum of all the Numbers -> " + sum1);


        List<Integer> noOfCharsInCourse = courseNames.stream().map(course -> course.length()).collect(Collectors.toList());
        System.out.println("Length of Each Course inside CourseListNames "+ noOfCharsInCourse);

        // First Cube all numbers and then find Square
        int cubeSum = list.stream().map(x -> x*x*x).reduce(0,Integer::sum);
        System.out.println("First Cube all numbers and then find total sum -> " + cubeSum);

        System.out.println("Distinct numbers in a List -> "+ list.stream().distinct().collect(Collectors.toList()));

        System.out.println("Ascending Order List -> " + list.stream().sorted().collect(Collectors.toList()));

        System.out.println("Descending Order List -> " + list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));

        System.out.println("Descending Order List Using Lambda -> " + list.stream().sorted((x,y) -> y.compareTo(x)).collect(Collectors.toList()));

        System.out.println("Descending Order List -> " + courseNames.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));

        System.out.println("Sort by length -> " + courseNames.stream().sorted(Comparator.comparing(str -> str
                .length())).collect(Collectors.toList()));

        System.out.println("Sort Distinct based on length "+courseNames.stream().distinct().sorted(Comparator.comparing(str -> str.length())).collect(Collectors.toList()));


        System.out.println(parametrizedSquareMethod(list,x->x*x));
        BiPredicate<Integer, String> ssdf = (num, str) -> {
            return num<30 && str.length()>5;
        };
        System.out.println(ssdf.test(5,"Hamid"));


    }

    public static List<Integer>  parametrizedSquareMethod(List<Integer> list, Function<Integer, Integer > function){
       return list.stream().map(function).collect(Collectors.toList());
    }
}
