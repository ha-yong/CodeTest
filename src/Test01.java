import java.util.*;

public class Test01 {
  static double[][] distance;
  static double minDist = Double.MAX_VALUE;
  
  public static void main(String[] args) {
    // このコードは標準入力と標準出力を用いたサンプルコードです。
    // このコードは好きなように編集・削除してもらって構いません。
    // ---
    // This is a sample code to use stdin and stdout.
    // Edit and remove this code as you like.

    double[][] pos = new double[5][3];
    String[] lines = getStdin();
    for (int i = 0; i < 5; i++) {
        String[] splitLine = lines[i].split(" ");
        for (int j = 0; j < 3; j++) {
            pos[i][j] = Double.parseDouble(splitLine[j]);
        }
    }

    // 5つの宇宙船の座標について全ての順列を生成する
    List<int[]> permutations = new ArrayList<>();
    boolean[] used = new boolean[5];
    int[] path = new int[5];
    generatePermutations(permutations, used, path, 0);
    
    // 各順列について線路を作成して距離を計算し、最小値を探索する
    distance = new double[5][5];
    for (int i = 0; i < 5; i++) {
        for (int j = i + 1; j < 5; j++) {
            distance[i][j] = distance[j][i] = Math.sqrt(Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2) + Math.pow(pos[i][2] - pos[j][2], 2));
        }
    }
    for (int[] perm : permutations) {
        double dist = 0;
        for (int i = 0; i < 4; i++) {
            dist += distance[perm[i]][perm[i + 1]];
        }
        if (dist < minDist) {
            minDist = dist;
        }
    }
    System.out.printf("%.2f", minDist);

  }

  private static String[] getStdin() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> lines = new ArrayList<>();
    while (scanner.hasNext()) {
      lines.add(scanner.nextLine());
    }
    return lines.toArray(new String[lines.size()]);
  }

  // 順列を生成する再帰関数
  static void generatePermutations(List<int[]> permutations, boolean[] used, int[] path, int depth) {
      if (depth == 5) {
          permutations.add(Arrays.copyOf(path, 5));
          return;
      }
      for (int i = 0; i < 5; i++) {
          if (!used[i]) {
              used[i] = true;
              path[depth] = i;
              generatePermutations(permutations, used, path, depth + 1);
              used[i] = false;
          }
      }
  }
}
