
public class Lps {

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));  // 4
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // 1. 길이 1은 무조건 회문
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 2. 긴 구간부터 계산 (i 뒤→앞)
        for (int i = n - 2; i >= 0; i--) {  // i=n-2부터!
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2; 
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];  // 전체 문자열 LPS
    }

}
