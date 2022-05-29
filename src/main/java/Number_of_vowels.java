import java.util.Scanner;

public class Number_of_vowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int temp = n;
        int[][] ans = new int[5][n];
        scanner.nextLine();
        while (n-- > 0){
            String str = scanner.nextLine();
            int len = str.length();
            for (int i = 0; i < len; ++i){
                if (str.charAt(i) == 'a'){
                    ans[0][n]++;
                }
                if (str.charAt(i) == 'e'){
                    ans[1][n]++;
                }
                if (str.charAt(i) == 'i'){
                    ans[2][n]++;
                }
                if (str.charAt(i) == 'o') {
                    ans[3][n]++;
                }
                if (str.charAt(i) == 'u'){
                    ans[4][n]++;
                }
            }
        }
        for (int i = temp-1; i >= 0; --i){
            System.out.println("a:"+ans[0][i]);
            System.out.println("e:"+ans[1][i]);
            System.out.println("i:"+ans[2][i]);
            System.out.println("o:"+ans[3][i]);
            if (i == 0){
                System.out.println(i);
                System.out.print("u:"+ans[4][i]);
            } else {
                System.out.println("u:"+ans[4][i]);
            }
        }
        scanner.close();
    }
}
