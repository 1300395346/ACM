# A Problem

Anton likes to play chess, and so does his friend Danik.

Once they have played *n* games in a row. For each game it's known who was the winner — Anton or Danik. None of the games ended with a tie.

Now Anton wonders, who won more games, he or Danik? Help him determine this.

思路：读取字符串，计算A和D出现的次数，然后判断输赢

代码如下：

```java
import java.util.Scanner;

public class Match {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int A = 0;
        int D = 0;
        String ans = scanner.next();
        for (int i = 0; i < len; ++i){
            if (ans.charAt(i) == 'A'){
                A++;
            } else{
                D++;
            }
        }
        if (A > D){
            System.out.println("Anton");
        } else if (D>A){
            System.out.println("Danik");
        } else {
            System.out.println("Friendship");
        }
        scanner.close();
    }
}
```

结果：通过
