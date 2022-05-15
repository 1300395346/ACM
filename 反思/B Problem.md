# B Problem

求A^B的最后三位数表示的整数。  
说明：A^B的含义是“A的B次方”

输入数据包含多个测试实例，每个实例占一行，由两个正整数A和B组成（1<=A,B<=10000），如果A=0, B=0，则表示输入数据的结束，不做处理。

思路：利用快速幂算法，进行幂运算的同时保证只保留后三位，即mod1000

代码如下：

```java
import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            if (A==0 && B == 0){
                break;
            }
            System.out.println(fast(A,B,1000));
        }
    }

    public static int fast(int A, int B, int mod){
        int ans = 1;
        while (B != 0){
            if (B % 2 == 1){
                ans *= A;
                ans %= mod;
            }
            B /= 2;
            A *= A;
            A %= mod;
        }
        return ans;
    }
}
```

结果：通过！
