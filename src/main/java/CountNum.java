import java.util.Scanner;

public class CountNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0){
            int num = scanner.nextInt();
            int[] ans = new int[10];
            int i,j,k;
            for (i = 1; i <= num; i++){
                if (i < 10){
                    ans[i]++;
                }
                if (i >= 10){
                    j = i;
                    while (j != 0){
                        k = j % 10;
                        ans[k]++;
                        j /= 10;
                    }
                }
            }
            for (int temp = 0; temp < 10; ++temp){
                if (temp == 9){
                    System.out.println(ans[temp]);
                } else {
                    System.out.print(ans[temp]+" ");
                }
            }
        }
        scanner.close();
    }
}
