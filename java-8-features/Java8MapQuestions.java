import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8MapQuestions {
    public static void main(String[] args) {
        /*Given a map of string, List<Integer> , use streams to get map of string, max of the list of integers*/
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("Dev", Arrays.asList(1000, 2000));
        map.put("Devbrat", Arrays.asList(3000, 4000));

        Map<String, Integer> result =
                map.entrySet().stream().collect(Collectors.toMap(x -> x.getKey() , y -> y.getValue().stream()
                        .max(Integer::compare).orElse(null)));

        System.out.println("max integer.... " +result);
        /* to print the above input */
        System.out.println(map.entrySet().stream().collect(Collectors.toMap(x -> x.getKey() , y -> y.getValue())));

    /* print the maximum number in a list */

        List<Integer> list = Arrays.asList(1,10,8,16,20,27);

        System.out.println(" max number " +list.stream().max(Integer::compare).orElse(null));

    }
}
