
import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        String s = "catsandog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        System.out.println(wordBreak(s, wordDict));  // true
    }

    public static boolean wordBreak(String s, String[] wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // ★ 단어 사전 → Set으로 O(1) 조회
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }

        for (int i = 1; i <= s.length(); i++) {
            // ★ i까지 오는 모든 시작점 j 확인
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // 하나만 찾으면 OK
                }
            }
        }
        return dp[s.length()];
    }

}
