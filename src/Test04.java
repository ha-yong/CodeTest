import java.util.*;
public class Test04 {
  
  public static void main(String[] args) {
    String[] lines = getStdin();

    int n = Integer.parseInt(lines[0].split(" ")[0]); // 村人の数
    int q = Integer.parseInt(lines[0].split(" ")[1]);// 聞き取り調査の回数
    int[] age = new int[n + 1]; // 村人の年齢
    Arrays.fill(age, -101); // 年齢の初期値を -101 に設定

    // 聞き取り調査の結果を反映する
    for (int i = 0; i < q; i++) {
        int a = Integer.parseInt(lines[i+1].split(" ")[0]);
        int b = Integer.parseInt(lines[i+1].split(" ")[1]);
        int c = Integer.parseInt(lines[i+1].split(" ")[2]);

        // 年齢の差が矛盾する場合は、-1 を出力して終了する
        if(c > 0){
            if (age[a] != -101 && age[b] != -101) {
                if (Math.abs(age[a] - age[b]) != c) {
                    System.out.println("-1");
                    return;
                }
            } else if (age[a] != -101) {
                age[b] = age[a] + c;    
            } else if (age[b] != -101) {
                age[a] = age[b] - c;
            } else {
                age[a] = 0;
                age[b] = c;
            }
        }else if(c < 0){
            if (age[a] != -101 && age[b] != -101) {
                if (Math.abs(age[a] - age[b]) != Math.abs(c)) {
                    System.out.println("-1");
                    return;
                }
            } else if (age[a] != -101) {
                age[b] = age[a] + c;    
            } else if (age[b] != -101) {
                age[a] = age[b] - c;
            } else {
                age[a] = -c;
                age[b] = 0;
            }
        }else {
            // b と同じ年齢ということは a と b は同じ年齢ということ
            if (age[a] != -101 && age[b] != -101 && age[a] != age[b]) {
                // a の年齢が既に決まっていて、b と年齢が異なる場合は存在しない
                System.out.println("-1");
                return;
            }
            age[a] = age[b];
        }
      }

      // 最年少者と最年長者の年齢差の最小値を求める
      int minAgeDiff = Integer.MAX_VALUE;
      int minAge = Integer.MAX_VALUE;
      int maxAge = 0;
      for (int i = 1; i <= n; i++) {
        if(age[i] != -101){
            if (age[i] < minAge) {
                minAge = age[i];
            }
            if (age[i] > maxAge) {
                maxAge = age[i];
            }
        }
      }
      minAgeDiff = maxAge - minAge;

      if(minAgeDiff > 100){
        System.out.println("-1");
        return;
      }
      System.out.println(minAgeDiff);
  }

  private static String[] getStdin() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> lines = new ArrayList<>();
    while (scanner.hasNext()) {
      lines.add(scanner.nextLine());
    }
    return lines.toArray(new String[lines.size()]);
  }
}
