# Bits Equalizer

输入两个字符串，第一个字符串包括0,1，?,  第二个字符串只包括0和1，问由第一个字符串转换到第二个字符串最少多少个操作？

其中对S的操作有3个：

1. 可以把'?'变成1或者0

2. 可以把0变成1

3. 可以交换任意两个数字

2022/5/20

思路：统计两个字符串中1,0,?的个数，若第一个字符串1的个数多于第二个字符串，则不可能完成变换；若不多于第二个字符串，则统计两个字符串中0-1的个数和1-0的个数，取其最大的值加上？的个数就是答案

代码如下：

```java
import java.util.Scanner;

public class Bits_Equalizer {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int kase = 1; kase <= T; ++kase) {
            String u, v;
            u = cin.next();
            v = cin.next();
            int len = u.length();
            int sum0 = 0, sum1 = 0;
            for (int i = 0; i < len; ++i) {
                char ch1 = u.charAt(i);
                char ch2 = v.charAt(i);
                if (ch1 == '1') ++sum0;
                if (ch2 == '1') ++sum1;
            }
            System.out.print("Case " + kase + ": ");
            if (sum0 > sum1) {
                System.out.println("-1");
                continue;
            }
            sum0 = 0;
            sum1 = 0;
            int sum = 0;
            for (int i = 0; i < len; ++i) {
                char ch1 = u.charAt(i);
                char ch2 = v.charAt(i);
                if (ch1 == '0' && ch2 == '1') ++sum0;
                if (ch1 == '1' && ch2 == '0') ++sum1;
                if (ch1 == '?') ++sum;
            }
            System.out.println(Math.max(sum0, sum1) + sum);
        }
    }
}
```

结果：通过！

解析：当第一个字符串的1的个数小于第二个字符串的时候，若0-1的数量多于1-0的数量，那么执行操作3能够将1-0对全部消除，而0-1对会有多，然后执行操作1和操作2，完成变换我们能够发现实际变换次数为？的数量和0-1对的数量；反之亦然。
