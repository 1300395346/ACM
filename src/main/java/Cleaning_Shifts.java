import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Cleaning_Shifts {
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

    //第二种实现方式，我原本的思路
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int T = scanner.nextInt();
//        Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
//        for (int i = 0; i < N; ++i){
//            int start = scanner.nextInt();
//            int end = scanner.nextInt();
//            if (map.containsKey(start)){
//                map.put(start,Math.max(map.get(start),end));
//            } else {
//                map.put(start,end);
//            }
//        }
//        int beginTime = 1;
//        int endTime = -1;
//        int count = 1;
//        int index = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int s = entry.getKey();
//            int e = entry.getValue();
//            if (index == 0 && s > 1){
//                break;
//            }
//            if (s <= beginTime) {
//                endTime = Math.max(endTime, e);
//            } else {
//                count++;
//                beginTime = endTime + 1;
//                if (s <= beginTime) {
//                    endTime = Math.max(endTime, e);
//                } else {
//                    break;
//                }
//            }
//            if (endTime >= T) {
//                break;
//            }
//            index++;
//        }
//
//        if (endTime < T){
//            System.out.println(-1);
//        } else {
//            System.out.println(count);
//        }
//    }
}