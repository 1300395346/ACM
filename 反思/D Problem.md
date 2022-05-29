# D Problem

Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).  

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ want to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

思路：二分+贪心，让左边界为第一个房子，右边界为最后一个房子，然后间隔就是两者之间的二分距离，遍历所有房子的位置，当放牛的房子距离牛的位置的间隔大于此间隔，就将插入牛的数量加一，同时是令牛的位置为此房间的位置，继续判断。当放入牛的数量大于等于有的牛的数量时，返回true，则令left = mid，否则令right = mid，当其不满足循环条件时，left值一定就是最大的最小间隔。

代码如下：

```java
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
```

结果：通过！！


