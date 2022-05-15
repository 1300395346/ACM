# F Problem

This is the hard version of the problem. The only difference between the two versions is that the harder version asks additionally for a minimum number of subsegments.

Tokitsukaze has a binary string s of length n, consisting only of zeros and ones, n is even.

Now Tokitsukaze divides s into the minimum number of contiguous subsegments, and for each subsegment, all bits in each subsegment are the same. After that, s is considered good if the lengths of all subsegments are even.

For example, if s is "11001111", it will be divided into "11", "00" and "1111". Their lengths are 2, 2, 4 respectively, which are all even numbers, so "11001111" is good. Another example, if s is "1110011000", it will be divided into "111", "00", "11" and "000", and their lengths are 3, 2, 2, 3. Obviously, "1110011000" is not good.

Tokitsukaze wants to make s good by changing the values of some positions in s. Specifically, she can perform the operation any number of times: change the value of si​ to '0' or '1' (1≤i≤n). Can you tell her the minimum number of operations to make s good? Meanwhile, she also wants to know the minimum number of subsegments that s can be divided into among all solutions with the minimum number of operations.

思路：由于它总是偶数，所以我们两个两个的比较，当两个字符不相同的时候，操作数加一；当两个字符相同时，若其与前一个字段不相同，则字段数加一，然后更新上一个字段，否则直接更新上一个字段。

代码如下：

```java
import java.util.Scanner;

public class Tokitsukaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        while (times-- > 0){
            int n = scanner.nextInt();
            String s = scanner.next();
            char last = ' ';
            int x = 0;
            int y = 0;
            for (int i = 0; i < s.length(); i += 2){
                if (s.charAt(i) != s.charAt(i+1)){
                    x++;
                } else {
                    if (last != s.charAt(i)){
                        y++;
                    }
                    last = s.charAt(i);
                }
            }
            System.out.println(x+" "+Math.max(1,y));
        }
    }
}
```

结果：通过！
