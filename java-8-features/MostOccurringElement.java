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
//it is same as like , storing the element in hashmap , and get iterate over the hashmap and get the key
// based on the value count more than 1 or the maximum occurrence of the value in hashmap.
        System.out.println( mostFrequent.getKey());


    }
}
