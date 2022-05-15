import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ToZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        while (count-- > 0){
            int len = scanner.nextInt();
            int ans = 0;
            Set<Integer> set = new HashSet<>();
            int[] nums = new int[len];
            for (int i = 0; i < len; ++i){
                nums[i] = scanner.nextInt();
                if (nums[i] > 0){
                    ans++;
                }
                set.add(nums[i]);
            }
            Arrays.sort(nums);
            if (nums[0] == 0){
                System.out.println(ans);
            } else {
                if (set.size() == len){
                    System.out.println(len+1);
                } else {
                    System.out.println(len);
                }
            }
        }
    }
}
