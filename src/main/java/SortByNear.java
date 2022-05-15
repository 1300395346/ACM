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
                for (int j = 0; j < len-1; ++j){
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

//    public static int ans;
//    public static int[] nums = new int[1008];
//    public static int[] tmp = new int[1008];
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int time = scanner.nextInt();
//        int temp = 1;
//        while (time-- > 0){
//            System.out.println("Scenario #"+temp+":");
//            temp++;
//            int len = scanner.nextInt();
//            for (int i = 0; i < len; ++i){
//                nums[i] = scanner.nextInt();
//            }
//            ans = 0;
//            Merge_sort(0,len-1);
//            System.out.println(ans);
//            System.out.println();
//        }
//    }
//
//    public static void Merge_sort(int left, int right){
//        if (left < right){
//            int mid = (left+right) >> 1;
//            Merge_sort(left,mid);
//            Merge_sort(mid+1,right);
//            Merge(left,mid,right);
//        }
//    }
//
//    public static void Merge(int left, int mid, int right){
//        int i = left;
//        int j = mid+1;
//        int k = left;
//        while (i <= mid && j <= right){
//            if (nums[i] > nums[j]){
//                tmp[k++] = nums[j++];
//                ans += mid-i+1;
//            } else {
//                tmp[k++] = nums[i++];
//            }
//        }
//        while (i <= mid){
//            tmp[k++] = nums[i++];
//        }
//        while (j <= right){
//            tmp[k++] = nums[j++];
//        }
//        if (right + 1 - left >= 0) System.arraycopy(tmp, left, nums, left, right + 1 - left);
//    }
}
