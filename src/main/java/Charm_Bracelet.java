import java.util.Scanner;

public class Charm_Bracelet {
    public static void main(String[] args) {
        int[] result = new int[12881];
        int[] value = new int[3403];
        int[] weight = new int[3403];
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int limit = scanner.nextInt();
        for (int i = 0; i < num; ++i) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; ++i) {
            for (int j = limit; j >= weight[i]; j--) {
                int temp = result[j - weight[i]] + value[i];
                if (result[j] <= temp) {
                    result[j] = temp;
                }
            }
        }
        System.out.println(result[limit]);
    }
}