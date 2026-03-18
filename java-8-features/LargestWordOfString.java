import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LargestWordOfString {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("elephant", "apple", "banana");

        String str = "i am good programmer";

        System.out.println(" largest word in a string -> "+words.stream().max(Comparator.comparing(String::length)).get());

        System.out.println(" Smallest word in a string -> " + words.stream().min(Comparator.comparing(String::length)).get());

        System.out.println("second largest word ---> " +Arrays.stream(str.split("\\s"))
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .skip(1)
                .findFirst()
                .orElse(""));

        System.out.println("second largest word length ---> " + Arrays.stream(str.split("\\s"))
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0));

        System.out.println("largest word length ---> " + Arrays.stream(str.split("\\s"))
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(0));

        System.out.println("largest word ---> " + Arrays.stream(str.split("\\s")).sorted(Comparator.comparing(String::length).reversed())
                .findFirst().orElse(""));
        
       //Swap values without third variable
        int a = 25;
        int b = 65;

        a = a+ b;
        b = a- b;

        a = a- b;

        System.out.println("swap of values "+ a + " "+ b );


        String newStr = "java";

       String result = Arrays.stream(newStr.split(""))
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() >1)
               .map(Map.Entry::getKey)
                .findFirst()
               .orElse(null);

        System.out.println(result);

    }
}
