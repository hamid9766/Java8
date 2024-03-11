package Java8.in28Minutes;

import java.util.Arrays;
import java.util.Optional;

public class Java8Practise {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};

        Optional<Integer> mul = Arrays.stream(arr).reduce((a, b)-> a*b);
        System.out.println(mul);
    }
}
