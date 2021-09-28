package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHelper {

    public static List<Integer> someFibonacciNumbers() {
        return new ArrayList<>(Arrays.asList(1, 1, 2, 3, 5, 8, 13));
    }

    public static List<User> makeUserList() {
        return List.of(
            new User("Sheldon", "Cooper"),
            new User("Leonard", "Hofstadter"),
            new User("Raj", "Koothrappali"),
            new User("Howard", "Wolowitz")
        );
    }

    public static Map<String, ?> makeUserMap() {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "Iván");
        userMap.put("lastName", "López");
        userMap.put("age", 41);

        return userMap;
    }

    public static long currentTime() {
        return System.currentTimeMillis();
    }
}

















