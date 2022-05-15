import java.util.Arrays;
import java.util.Scanner;

public class CowLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int cows = scanner.nextInt();
        int[] stalls = new int[len];
        for (int i = 0; i < len; ++i){
            stalls[i] = scanner.nextInt();
        }
        Arrays.sort(stalls);
        int left = stalls[0];
        int right = stalls[len-1];
        while (right - left > 1){
            int mid = (right+left)/2;
            if (check(mid,len,stalls,cows)){
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

    public static boolean check(int mid, int len, int[] stalls, int cows){
        int cowNum = 1;
        int cowLocation = stalls[0];
        for (int i = 1; i < len; ++i){
            if (stalls[i] - cowLocation >= mid){
                cowNum++;
                cowLocation = stalls[i];
            }
            if (cowNum >= cows){
                return true;
            }
        }
        return false;
    }
}
