
import java.io.*;
import java.util.*;

public class Test2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: H, W
        String[] line1 = br.readLine().split(" ");
        int H = Integer.parseInt(line1[0]);
        int W = Integer.parseInt(line1[1]);

        // 입력: N (별도의 줄!)
        int N = Integer.parseInt(br.readLine());

        // H x W 그리드 초기화
        char[][] grid = new char[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(grid[i], '.');
        }

        // N개의 단어 배치
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            int r = Integer.parseInt(info[0]) - 1;
            int c = Integer.parseInt(info[1]) - 1;
            int direction = Integer.parseInt(info[2]);
            String word = info[3];

            if (direction == 0) {
                // 아래 방향
                for (int j = 0; j < word.length(); j++) {
                    grid[r + j][c] = word.charAt(j);
                }
            } else {
                // 오른쪽 방향
                for (int j = 0; j < word.length(); j++) {
                    grid[r][c + j] = word.charAt(j);
                }
            }
        }

        // 출력
        for (int i = 0; i < H; i++) {
            System.out.println(new String(grid[i]));
        }
    }
}
