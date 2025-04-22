import java.util.List;

public class SumOfAllElements {
    public static void main(String[] args) {


        List<Integer> num = List.of(1,2,3,4,5);
        //way 1
        int sum = num.stream().map( i -> i.intValue()).reduce(0, (a,b) -> a+b );
        System.out.println(sum);
        //way 2
        int sum2 = num.stream().mapToInt(Integer :: intValue).sum();
        System.out.println(sum2);

        //way3
        int sum3 = num.stream().reduce(0, Integer::sum);
        System.out.println(sum3);
    }
}
