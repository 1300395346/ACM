# Sum of Digits

Having watched the last Harry Potter film, little Gerald also decided to practice magic. He found in his father's magical book a spell that turns any number in the sum of its digits. At the moment Gerald learned that, he came across a number *n*. How many times can Gerald put a spell on it until the number becomes one-digit?

思路：读取输入，将其划分为字符数组，然后遍历每个字符将其相加后转为字符串，重复上述步骤知道字符数组长度为1，计算此过程的循环的次数。

代码如下：

```java
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
```
