
import java.util.Arrays;

public class Test5 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int amount = 28;
        System.out.println(coinChange(coins, amount));  // 예상: 4
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);     // ★ 불가능 초기값!
        dp[0] = 0;                       // ★ 0원은 0개!

        for (int coin = 0; coin < coins.length; coin++) {
            for (int w = coins[coin]; w <= amount; w++) {
                dp[w] = Math.min(dp[w], dp[w - coins[coin]] + 1);
            }
        }

        // 여기에 DP 코드 작성!
        return dp[amount];
    }
}
