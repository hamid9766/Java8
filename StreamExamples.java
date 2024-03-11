package Java8.in28Minutes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static String thirstLarget(String[] arr){
        String  f = "",s ="", t ="";
        for(String word : arr){
            if(word.length()>f.length()){
                t = s;
                s= f;
                f =s;
            }else if(word.length()>s.length()){
                t = s;
                s= word;
            } else if (word.length()>t.length()) {
                t = word;
            }

        }
        return t;
    }
    public static void main(String[] args) {
        int[] arr = {12,9,13,4,6,2,4,12,15};
        List<Integer> list = Arrays.asList(15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet<>();

        System.out.println("Number of Elements -> " + Stream.of(12,9,13,4,6,2,4,12,15).count());
        System.out.println("Array sum -> " + Arrays.stream(arr).max());
        System.out.println("Min in Array -> " + Arrays.stream(arr).min());
        System.out.println("Max in Array -> " + Arrays.stream(arr).max());
        System.out.println("Avg in Array -> " + Arrays.stream(arr).average());

        System.out.println(IntStream.iterate(2,e-> e+2).limit(10).peek(System.out::print).sum());
        IntStream.iterate(2,e-> e+2).limit(10).forEach(System.out::println);

        System.out.println("Multiply numbers by 2 till limit and collect in  list " + IntStream.iterate(2,e-> e*2).limit(8).boxed().collect(Collectors.toList()));

        list.stream().filter(i -> !set.add(i)).forEach(System.out::println);
        System.out.println(thirstLarget(new String[]{"coder","byte","code"}));

        int a = list.stream().sorted(Collections.reverseOrder()).distinct().limit(3).skip(2).findFirst().get();
        System.out.println(a);

        String s1 = 10 + 20 + "";
        String s2 = ""+ 10 + 20;
        System.out.println(s1 + " " +s2);

        List<String> listStartsWithOne = list.stream().map(n-> n + "").filter( i-> i.startsWith("1")).collect(Collectors.toList());
        System.out.println("Find out all the numbers starting with 1 ->" + listStartsWithOne);

        Set<Integer> set1 = new HashSet<>();
        list.stream().filter(i -> !set.add(i)).forEach(System.out::println);
        System.out.println("find duplicate elements given integers list ->");
    }
}
