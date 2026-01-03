
import java.io.*;
import java.util.*;

public class GroupCapacityCounter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int D = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(line2[i]);
        }

        String[] line3 = br.readLine().split(" ");
        long[] x = new long[D];  // ✅ long으로 변경!
        for (int i = 0; i < D; i++) {
            x[i] = Long.parseLong(line3[i]);  // ✅ Long.parseLong
        }

        Arrays.sort(a);

        long[] cumSum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            cumSum[i + 1] = cumSum[i] + a[i];
        }

        long result = 0;
        for (long people : x) {  // ✅ long으로 변경!
            int left = 0, right = N;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (cumSum[mid] <= people) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            result += left;
        }

        System.out.println(result);
    }
}
