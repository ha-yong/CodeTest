
public class Test4 {

    public static void main(String[] args) {
        int[][] items = {{1, 6}, {2, 10}, {3, 12}};
        int W = 4;
        System.out.println(solution(items, W)); // 18
    }

    public static int solution(int[][] items, int W) {
        int N = items.length;
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {

                dp[i][w] = dp[i - 1][w];

                int weight = items[i - 1][0];
                int value = items[i - 1][1];

                if (w >= weight) {

                    dp[i][w] = Math.max(dp[i][w],
                            dp[i - 1][w - weight] + value);
                }
            }
        }
        return dp[N][W];
    }
}
