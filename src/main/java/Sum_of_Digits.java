import java.util.Scanner;

public class Sum_of_Digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        char[] chars = nums.toCharArray();
        int ans = 0;

        while (chars.length > 1) {
            int num = 0;
            for (char ch : chars) {
                num += (int) ch - 48;
            }
            nums = Integer.toString(num);
            chars = nums.toCharArray();
            ans++;
        }
        System.out.println(ans);
        scanner.close();
    }
}