import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    private static final int[] father = new int[10001];
    private static final int[] inNumber = new int[10001];
    public static int cnt;
    public static int T = 0;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            int x = (int) in.nval;
            in.nextToken();
            int y = (int) in.nval;
            if (x == -1 && y == -1){
                break;
            }
            T++;
            if (x == 0 && y == 0){
                out.print(String.format("Case %d is a tree.\n",T));
                out.flush();
                continue;
            }
            Arrays.fill(inNumber,0);
            for (int i = 1; i <= 10000; ++i){
                father[i] = i;
            }
            cnt = 0;
            boolean answer = true;
            HashSet<Integer> set = new HashSet<>();
            set.clear();
            while (x != 0 && y != 0){
                set.add(x);
                set.add(y);
                inNumber[y]++;
                int fx = find(x);
                int fy = find(y);
                father[fy] = fx;
                in.nextToken();
                x = (int) in.nval;
                in.nextToken();
                y = (int) in.nval;
            }
            int sum = 0;
            int root = 0;
            for (int i : set){
                if (inNumber[i] > 1){
                    answer = false;
                } else if (inNumber[i] == 1){
                    sum++;
                } else if (inNumber[i] == 0){
                    root++;
                }
            }
            if (answer){
                if (root != 1 || sum != set.size()-1){
                    answer = false;
                }
                int c = 0;
                for (int i : set){
                    if (i == find(i)){
                        c++;
                        if (c > 1){
                            answer = false;
                            break;
                        }
                    }
                }
            }
            if (answer){
                out.print(String.format("Case %d is a tree.\n",T));
                out.flush();
            } else {
                out.print(String.format("Case %d is not a tree.\n",T));
            }
            out.flush();
        }
    }

    private static int find(int x){
        return father[x] == x ? x : (father[x] = find(father[x]));
    }
}
