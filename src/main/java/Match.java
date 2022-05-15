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
