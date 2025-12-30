
import java.util.*;

public class Test7 {

    public static int minMeetingRooms(int[][] intervals) {
        // TODO: Sweep Line으로 해결!
        // 힌트: start:+1, end:-1
        TreeMap<Integer, Integer> roomMap = new TreeMap<>();

        for (int[] time : intervals) {
            int start = time[0];
            int end = time[1];

            roomMap.put(start, roomMap.getOrDefault(start, 0) + 1);
            roomMap.put(end, roomMap.getOrDefault(end, 0) - 1);
        }

        int sum = 0;
        int result = 0;
        for (int cnt : roomMap.values()) {
            sum += cnt;
            result = Math.max(result, sum);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals)); // 2
    }
}
