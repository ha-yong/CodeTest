
import java.util.*;

public class Test1 {

    public static boolean canAccommodate(int[][] passengers, int n) {
        Map<Integer, Integer> changes = new TreeMap<>();

        for (int[] p : passengers) {
            int count = p[0];
            int pickup = p[1];
            int dropoff = p[2];

            changes.put(pickup, changes.getOrDefault(pickup, 0) + count);
            changes.put(dropoff, changes.getOrDefault(dropoff, 0) - count);
        }

        int current = 0;
        for (int change : changes.values()) {
            current += change;
            if (current > n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 테스트 데이터
        int[][] passengers = {
            {2, 1, 5},
            {3, 3, 7}
        };
        int n = 4;

        boolean result = canAccommodate(passengers, n);
        System.out.println("결과: " + result);  // 결과: false
    }
}
