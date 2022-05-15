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
