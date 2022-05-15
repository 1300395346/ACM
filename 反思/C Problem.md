# C Problem

Tokitsukaze has a sequence a of length n. For each operation, she selects two numbers ai​ and aj​ (i 不等于 j; 1≤i,j≤n).

- If ai​=aj​, change one of them to 0.
- Otherwise change both of them to min(ai​,aj​).

Tokitsukaze wants to know the minimum number of operations to change all numbers in the sequence to 0. It can be proved that the answer always exists.

思路：实质上就是分类讨论，判断输入的数字中是否存在0，若存在0，则答案是数组长度减去数组中0的个数；若不存在0，则判断数组中是否有相同的数字，若有，则答案是数组的长度；若没有，则答案是数组长度+1；

代码如下：

```java
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
```

结果：通过！
