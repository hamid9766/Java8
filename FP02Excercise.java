package Java8.in28Minutes;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP02Excercise {

    public static void main(String[] args) {
        List<Course> courseList = List.of(
                new Course("Spring Boot", "Framework", 93, 20000),
                new Course("AWS", "Cloud", 96, 25000),
                new Course("Spring", "Framework", 92, 10000),
                new Course("Azure", "Cloud", 91, 18000),
                new Course("Docker", "Cloud", 94, 20000)
        );

        Predicate<Course> scoreGreaterThan95 = course -> course.getReviewScore()>95;


        // allMatch, noneMatch, anyMatch
        System.out.println("All Match " + courseList.stream().allMatch(getCoursePredicate()));
        System.out.println("Any Match " + courseList.stream().anyMatch(getCoursePredicate()));
        System.out.println("None Match " + courseList.stream().noneMatch(getCoursePredicate()));

        Comparator<Course> comparingByNoOfStudentAndReviews
                = Comparator.comparing(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();
        System.out.println("Comparing By NoOfStudent And Reviews -> " + courseList.stream().sorted(comparingByNoOfStudentAndReviews).collect(Collectors.toList()));

        // findFirst, findAny
        Optional<Course> firstCourse = courseList.stream().findFirst();
        Optional<Course> findAnyCourse = courseList.stream().filter(scoreGreaterThan95).findAny();
        System.out.println(findAnyCourse);

        System.out.println();
        System.out.println("Grouping Course by Category -> "+courseList.stream().collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println();

        System.out.println("Grouping Course by Category & there count -> "+
                courseList.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

        System.out.println("Grouping and Mapping "+courseList.stream().
                collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName,Collectors.toList()))));
    }


    private static Predicate<Course> getCoursePredicate() {
        return course -> course.getReviewScore() > 99;
    }
}
