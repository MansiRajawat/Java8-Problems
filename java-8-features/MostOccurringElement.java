import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostOccurringElement {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "orange", "banana", "apple", "orange", "apple");

        Map.Entry<String, Long> mostFrequent =  words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting() ))
                .entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);

        System.out.println( mostFrequent.getKey());


    }
}
