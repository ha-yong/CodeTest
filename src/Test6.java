
import java.util.*;

public class Test6 {

    public static boolean canCompleteRequests(int[][] requests, int capacity) {
        // TreeMap<Floor, WeightChange>
        // TODO: fromFloorで+weight, toFloorで-weight
        TreeMap<Integer, Integer> elevationMap = new TreeMap<>();
        int currentWeight = 0;

        for (int[] data : requests) {
            int weight = data[0];
            int fromFloor = data[1];
            int toFloor = data[2];

            elevationMap.put(fromFloor, elevationMap.getOrDefault(fromFloor, 0) + weight);
            elevationMap.put(toFloor, elevationMap.getOrDefault(toFloor, 0) - weight);

        }
        // TODO: 各階をスキャンして容量チェック
        for (int value : elevationMap.values()) {
            currentWeight += value;
            if (capacity < currentWeight) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] requests = {{60, 2, 5}, {70, 3, 7}};
        int capacity = 100;
        System.out.println(canCompleteRequests(requests, capacity)); // false
    }
}
