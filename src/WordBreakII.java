
import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        System.out.println(wordBreak(s, wordDict));
        // ["cat sand dog", "cats and dog"]
    }

    public static List<String> wordBreak(String s, String[] wordDict) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordDict));
        Map<Integer, List<String>> memo = new HashMap<>();  // ★ DP 메모

        return dfs(s, 0, wordSet, memo);
    }

    private static List<String> dfs(String s, int start, Set<String> wordSet, Map<Integer, List<String>> memo) {
        if (start == s.length()) {
            return Arrays.asList("");  // 빈 문자열
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                // ★ 재귀: start부터 end까지 단어 + end부터 결과들
                List<String> sublist = dfs(s, end, wordSet, memo);
                for (String sub : sublist) {
                    result.add(word + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }

        memo.put(start, result);
        return result;
    }

}
