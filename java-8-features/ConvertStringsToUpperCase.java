import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringsToUpperCase {
    public static void main(String[] args) {
        List<String> strings = List.of("java", "python", "javascript");

        //way1
      List<String> result1 =  strings.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result1);
      //way2

        List<String> result2 =  strings.stream().map( i -> i.toUpperCase()).collect(Collectors.toList());
        System.out.println(result2);

    }
}
