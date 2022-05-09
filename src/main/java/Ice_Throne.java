import java.util.Scanner;

public class Ice_Throne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] value = {0, 150, 200, 350};
        int[] dp = new int[10000];
        while (len-- > 0) {
            int temp = scanner.nextInt();
            for (int i = 0; i < 3; ++i) {
                for (int j = 1; j <= temp; ++j) {
                    if (j >= value[i]) {
                        dp[j] = Math.max(dp[j], dp[j - value[i]] + value[i]);
                    }
                }
            }
            System.out.println(temp - dp[temp]);
        }

        scanner.close();
    }
}