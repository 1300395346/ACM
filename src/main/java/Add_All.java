import java.util.PriorityQueue;
import java.util.Scanner;

public class Add_All {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n != 0){
            PriorityQueue<Integer> heap = new PriorityQueue<>(n);
            for (int i = 0; i < n; ++i){
                heap.add(scanner.nextInt());
            }
            int sum = 0;
            while (!heap.isEmpty()){
                int x = heap.peek();
                heap.poll();
                int y = heap.peek();
                heap.poll();
                sum += x+y;
                if (!heap.isEmpty()){
                    heap.add(x+y);
                }
            }
            System.out.println(sum);
            n = scanner.nextInt();
        }
        scanner.close();
    }
}
