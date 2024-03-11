package Java8.in28Minutes;

import java.util.*;
import java.util.stream.Collectors;

public class FlatMapExamples {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "AWS", "Kubernetes", "Docker", "Azure", "API" , "Microservices");
        List<String> courses2 = List.of("Spring", "AWS", "Kubernetes", "Docker", "Azure", "API" , "Microservices");
        List<Integer> numberList = List.of(43,9,1,1,1,2,24,24,7,28,5,5,18);

        System.out.println("Joining List ->" + courses.stream().collect(Collectors.joining(" ")));

        System.out.println("Split all word present inside courseList -> " + courses.stream().map(course -> course.split(""))
                .flatMap(Arrays::stream).collect(Collectors.toList()));

        System.out.println("Split distinct word present inside courseList -> " + courses.stream().map(course -> course.split(""))
                .flatMap(Arrays::stream).distinct().collect(Collectors.toList()));

        System.out.println("Join Each of Element in first list with other list ->" + courses.stream()
                .flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
                .collect(Collectors.toList()));

        // Find 5 highest without optional
        int j = numberList.stream().sorted(Collections.reverseOrder()).distinct().limit(5).skip(4).findFirst().get();
        System.out.println(j);

        // Find 5 highest with optional
        Optional<Integer> i = numberList.stream().sorted(Collections.reverseOrder()).distinct().limit(5).skip(4).findFirst();
        System.out.println(i);

        System.out.println('j'+'a'+'v'+'a');

        Optional<Integer> sum2 = numberList.stream().reduce((a,b) -> a+b);
        int sum3 = numberList.stream().reduce(0,Integer::sum);
        System.out.println(sum2);

       double avg = numberList.stream().mapToInt(e-> e).average().getAsDouble();
        System.out.println("Average of list ->" + avg);

        double squareFilterAvg = numberList.
                stream().
                map(e -> e*e).
                filter(e-> e>100).
                mapToInt(e-> e).average().
                getAsDouble();

        System.out.println("Square the Number then Filter and then find Average -> " +squareFilterAvg);

        List<Integer> startsWith2 = numberList.
                stream().
                map(e -> String.valueOf(e)).
                filter(e -> e.startsWith("2")).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println("List of Numbers that starts with 2 -> "+startsWith2);

        Set<Integer> duplicateFreqList = numberList.
                stream().
                filter(e -> Collections.frequency(numberList,e)>2).
                collect(Collectors.toSet());

        System.out.println("Find Duplicate in List and print ->" + duplicateFreqList);

        int maxNumber = numberList.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Find Maximum ->" + maxNumber);

        List<Integer> ascList = numberList.stream().sorted().collect(Collectors.toList());
        System.out.println(ascList);

        Optional<Integer> opt = numberList.stream().sorted(Collections.reverseOrder()).limit(5).skip(4).findFirst();
        System.out.println("Find the 5th highest Number in a list -> " +opt);

    }






}
