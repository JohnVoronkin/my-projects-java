package other;

import java.util.HashMap;
import java.util.Map;

/**
 * перебор Map
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Integer> fruits = new HashMap<>();

        fruits.put("pineapple", 100);
        fruits.put("banana", 15);
        fruits.put("mango", 60);
        fruits.put("papaya", 20);
        fruits.put("orange", 25);
        fruits.put("lemon", 7);

        fruits.forEach((key, value) -> System.out.println(key + " == " + value));
    }

}
