import java.util.Scanner;

public class Oil_Deposits {
    public static int[][] dfs;
    public static char[][] input;
    public static int n, m;
    public static int[][] move = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {-1, -1},
            {1, 1},
            {-1, 1},
            {1, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            if (n == 0 || m == 0) {
                break;
            }
            input = new char[n][m];
            dfs = new int[n][m];
            for (int i = 0; i < n; ++i) {
                input[i] = scanner.next().toCharArray();
            }
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (dfs[i][j] == 0 && input[i][j] == '@') {
                        sum++;
                        dfs[i][j] = 1;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(sum);
        }
        scanner.close();
    }

    public static void dfs(int x, int y) {
        for (int[] ints : move) {
            int xx = x + ints[0];
            int yy = y + ints[1];
            if (xx >= 0 && xx < n && yy >= 0 && yy < m && input[xx][yy] == '@' && dfs[xx][yy] == 0) {
                dfs[xx][yy] = 1;
                dfs(xx, yy);
            }
        }
    }
}
