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