import java.util.Scanner;

public class Tokitsukaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        while (times-- > 0){
            int n = scanner.nextInt();
            String s = scanner.next();
            char last = ' ';
            int x = 0;
            int y = 0;
            for (int i = 0; i < s.length(); i += 2){
                if (s.charAt(i) != s.charAt(i+1)){
                    x++;
                } else {
                    if (last != s.charAt(i)){
                        y++;
                    }
                    last = s.charAt(i);
                }
            }
            System.out.println(x+" "+Math.max(1,y));
        }
    }
}
