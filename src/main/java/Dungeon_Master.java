import java.util.*;

public class Dungeon_Master {
    public static class node{
        int x,y,z,step;
        node(int x,int y,int z,int step){
            this.x = x;
            this.y = y;
            this.z = z;
            this.step = step;
        }
    }
    public static int []dx = {-1,0,1,0,0,0};
    public static int []dy = {0,1,0,-1,0,0};
    public static int []dz = {0,0,0,0,1,-1};
    public static LinkedList<node> list = new LinkedList<>();
    public static char [][][]g = new char [31][31][31];
    public static boolean [][][]vis = new boolean [31][31][31];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int x = 0,y = 0,z = 0;
            if(L == 0 && R == 0 && C == 0) {
                return;
            }
            for(int i = 0;i < L;i ++) {
                for(int j = 0;j < R;j ++) {
                    String s = scanner.next();
                    g[i][j] = s.toCharArray();
                    for(int k = 0;k < C;k ++) {
                        if(g[i][j][k] == 'S') {
                            x = i;
                            y = j;
                            z = k;
                        }
                    }
                }
            }
            int ans = bfs(L,R,C,x,y,z);
            if(ans == -1) {
                System.out.println("Trapped!");
            }else {
                System.out.println("Escaped in "+ ans + " minute(s).");
            }
        }
    }
    static int bfs(int L,int R,int C,int x,int y,int z) {
        while(!list.isEmpty()) {
            list.pollFirst();
        }
        for(int i = 0;i < L;i ++) {
            for(int j = 0;j < R;j ++) {
                for(int k = 0;k < C;k ++) {
                    vis[i][j][k] = false;
                }
            }
        }
        vis[x][y][z] = true;
        list.add(new node(x,y,z,0));
        while(!list.isEmpty()) {
            node cur = list.pollFirst();
            if(g[cur.x][cur.y][cur.z] == 'E') {
                return cur.step;
            }
            for(int i = 0;i < 6;i ++) {
                int a = cur.x + dx[i];
                int b = cur.y + dy[i];
                int c = cur.z + dz[i];
                if(a >= 0 && a < L && b >= 0 && b < R && c >= 0 && c < C && !vis[a][b][c] && g[a][b][c] != '#') {
                    vis[a][b][c] = true;
                    list.add(new node(a,b,c,cur.step+1));
                }
            }
        }
        return -1;
    }
}