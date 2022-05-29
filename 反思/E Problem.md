# E Problem

Background  
Raymond Babbitt drives his brother Charlie mad. Recently Raymond counted 246 toothpicks spilled all over the floor in an instant just by glancing at them. And he can even count Poker cards. Charlie would love to be able to do cool things like that, too. He wants to beat his brother in a similar task.  

Problem  
Here's what Charlie thinks of. Imagine you get a sequence of N numbers. The goal is to move the numbers around so that at the end the sequence is ordered. The only operation allowed is to swap two adjacent numbers. Let us try an example:  

Start with: 2 8 0 3  
swap (2 8) 8 2 0 3  
swap (2 0) 8 0 2 3  
swap (2 3) 8 0 3 2  
swap (8 0) 0 8 3 2  
swap (8 3) 0 3 8 2  
swap (8 2) 0 3 2 8  
swap (3 2) 0 2 3 8  
swap (3 8) 0 2 8 3  
swap (8 3) 0 2 3 8

So the sequence (2 8 0 3) can be sorted with nine swaps of adjacent numbers. However, it is even possible to sort it with three such swaps:  

Start with: 2 8 0 3  
swap (8 0) 2 0 8 3  
swap (2 0) 0 2 8 3  
swap (8 3) 0 2 3 8

The question is: What is the minimum number of swaps of adjacent numbers to sort a given sequence?Since Charlie does not have Raymond's mental capabilities, he decides to cheat. Here is where you come into play. He asks you to write a computer program for him that answers the question. Rest assured he will pay a very good prize for it.

思路：该题目实际上就是计算排序过程中交换的次数

归并排序代码如下：

```java
import java.util.Scanner;

public class SortByNear {
    public static int ans;
    public static int[] nums = new int[1008];
    public static int[] tmp = new int[1008];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        int temp = 1;
        while (time-- > 0){
            System.out.println("Scenario #"+temp+":");
            temp++;
            int len = scanner.nextInt();
            for (int i = 0; i < len; ++i){
                nums[i] = scanner.nextInt();
            }
            ans = 0;
            Merge_sort(0,len-1);
            System.out.println(ans);
            System.out.println();
        }
    }

    public static void Merge_sort(int left, int right){
        if (left < right){
            int mid = (left+right) >> 1;
            Merge_sort(left,mid);
            Merge_sort(mid+1,right);
            Merge(left,mid,right);
        }
    }

    public static void Merge(int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int k = left;
        while (i <= mid && j <= right){
            if (nums[i] > nums[j]){
                tmp[k++] = nums[j++];
                ans += mid-i+1;
            } else {
                tmp[k++] = nums[i++];
            }
        }
        while (i <= mid){
            tmp[k++] = nums[i++];
        }
        while (j <= right){
            tmp[k++] = nums[j++];
        }
        if (right + 1 - left >= 0) System.arraycopy(tmp, left, nums, left, right + 1 - left);
    }
}
```

结果：通过！

冒泡排序代码：

```java
import java.util.Scanner;

public class SortByNear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        int temp = 1;
        while (time-- > 0){
            System.out.println("Scenario #"+temp+":");
            temp++;
            int len = scanner.nextInt();
            int[] nums = new int[len];
            for (int i = 0; i < len; ++i){
                nums[i] = scanner.nextInt();
            }
            int res = 0;
            for (int i = 0; i < len-1; ++i){
                for (int j = 0; j < len-1; ++i){
                    if (nums[j] > nums[j+1]){
                        int flag = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = flag;
                        res++;
                    }
                }
            }
            System.out.println(res);
            System.out.println();
        }
    }
}
```

结果：通过！
