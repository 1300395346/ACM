import java.util.Arrays;
import java.util.Scanner;

public class Vanya_and_Lanterns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double l = scanner.nextDouble();
        double[] a = new double[n];
        double r = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextDouble();
        }
        Arrays.sort(a);
        for (int i = 1; i < n; ++i) {
            r = Math.max(r, a[i] - a[i - 1]);
        }
        r = Math.max(a[0], r / 2);
        r = Math.max(l - a[n - 1], r);
        System.out.printf("%.9f%n", r);
    }
}