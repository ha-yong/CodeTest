import java.util.*;
public class HellowWorld {
  
  public static void main(String[] args) {
	String[] lines = getStdin();

    int n = Integer.parseInt(lines[0].split(" ")[0]); // 村人の数
    int q = Integer.parseInt(lines[0].split(" ")[1]);// 聞き取り調査の回数
    int[] age = new int[n + 1]; // 村人の年齢
    Arrays.fill(age, -1); // 年齢の初期値を -1 に設定

    // 聞き取り調査の結果を反映する
    for (int i = 0; i < q; i++) {
        int a = Integer.parseInt(lines[i+1].split(" ")[0]);
        int b = Integer.parseInt(lines[i+1].split(" ")[1]);
        int c = Integer.parseInt(lines[i+1].split(" ")[2]);

        if (age[a] != -1 && Math.abs(age[a] - age[b]) != c) {
          // a の年齢が既に決まっていて、c と矛盾する場合は存在しない
          System.out.println("-1");
          return;
        }

        if (c == 0) {
          // b と同じ年齢ということは a と b は同じ年齢ということ
          if (age[a] != -1 && age[a] != age[b]) {
              // a の年齢が既に決まっていて、b と年齢が異なる場合は存在しない
              System.out.println("-1");
              return;
          }
          age[a] = age[b];
        } else {
          // b より c 歳年上なので a の年齢は b の年齢 + c
          int newAge = age[b] + c;
          if (newAge < 0 || newAge > 100) {
              // 年齢が範囲外の場合は存在しない
              System.out.println("-1");
              return;
          }
          if (age[a] != -1 && age[a] != newAge) {
              // a の年齢が既に決まっていて、c と矛盾する場合は存在しない
              System.out.println("-1");
              return;
          }
          age[a] = newAge;
        }
      }

      int minDiff = Integer.MAX_VALUE;
        int maxAge = -1;
        int minAge = 101;
        for (int i = 1; i <= n; i++) {
            if (age[i] == -1) {
                // 年齢が決まっていない村人がいる場合は存在しない
                System.out.println("-1");
                return;
            }
            maxAge = Math.max(maxAge, age[i]);
            minAge = Math.min(minAge, age[i]);
        }

        minDiff = maxAge - minAge;
        System.out.println(minDiff);
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
