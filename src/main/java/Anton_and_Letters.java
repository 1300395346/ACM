import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Anton_and_Letters {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int len = input.length();
        for (int i = 0; i < len; ++i) {
            if (Character.isLetter(input.charAt(i))) {
                set.add(input.charAt(i));
            }
        }
        System.out.println(set.size());
    }
}