# Cleaning Shifts

农夫大卫有一片菜园，同时他有n条狗（1 ≤ n ≤ 25000）来看守。他的每条狗有固定的工作时间，并且一定能在工作时间内好好看守菜园。他把一天的时间分为t个时间段(1 ≤ t ≤ 1000000)，分别是从1到t，希望每个时间段都至少有一条狗看守菜园。请你为这些狗分配工作，计算最少需要几条不同的狗，才能让每个时间段都至少有一条狗有看守菜园。注意，有可能不论怎么安排，都无法实现这个目标。

思路：

- 贪心
- 按奶牛空闲时间开始的时间进行排序,在开始时间满足小于等于一个起始时间(起始时间初始化为1)的条件下尽量选择结束时间较靠后的点
- 选择好一个结束时间最靠后的区间后,将起始时间更新为结束时间+1,然后循环重复如上的判断

代码如下：

```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        Job[] jobs = new Job[N];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(in.nextInt(), in.nextInt());
        }

        Arrays.sort(jobs);//对jobs进行排序，下面重写了排序的方法，首先从小到大排开始时间，当开始时间相同时从大到小排序结束时间

        int beginTime = 1;
        int endTime = -1;
        int count = 1;


        for (int i = 0; i < jobs.length; i++) {
            int s = jobs[i].beginTime;
            int e = jobs[i].endTime;

            if (i == 0 && s > 1) {//不存在从1开始工作的狗
                break;
            }

            if (s <= beginTime) {//用于在选定好初始时间后选择一个结束时间尽可能靠后的
                endTime = Math.max(endTime, e);
            } else {
                count++;//更新区间
                beginTime = endTime + 1;
                if (s <= beginTime) {//用于在选定好初始时间后选择一个结束时间尽可能靠后的
                    endTime = Math.max(endTime, e);
                } else {//当前区间的初始时间与选定区间的结束时间不相邻，即无解
                    break;
                }
            }

            if (endTime >= T) {//完成了一天的工作
                break;
            }
        }

        if (endTime < T) {//无解
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static class Job implements Comparable<Job> {
        int beginTime;
        int endTime;

        public Job(int beginTime, int endTime) {
            this.beginTime = beginTime;
            this.endTime = endTime;
        }

        //重写了排序的方法，开始时间升序，当开始时间相同时，结束时间降序排列
        @Override
        public int compareTo(Job o) {
            int res = beginTime - o.beginTime;
            if (res == 0) {
                return endTime - o.endTime;
            } else {
                return res;
            }
        }

        //重写此方法，用于测试排序过后的序列是否正确
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return beginTime + " " + endTime;
        }

    }
}
```


