import java.util.Scanner;

public class Ice_Throne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        //贪心算法
        while(len-- > 0){
            int temp = scanner.nextInt();
            int xy = temp/150;
            int x = temp % 150 / 50;
            if (x > xy){
                x = xy;
            }
            System.out.println(xy);
            System.out.println(x);
            System.out.println(temp-150*xy-50*x);
        }
        //DP
//        int[] value = {0, 150, 200, 350};
//        int[] dp = new int[10000];
//        while (len-- > 0) {
//            int temp = scanner.nextInt();
//            for (int i = 0; i < 3; ++i) {
//                for (int j = 1; j <= temp; ++j) {
//                    if (j >= value[i]) {
//                        dp[j] = Math.max(dp[j], dp[j - value[i]] + value[i]);
//                    }
//                }
//            }
//            System.out.println(temp - dp[temp]);
//        }
//
        scanner.close();
    }
}