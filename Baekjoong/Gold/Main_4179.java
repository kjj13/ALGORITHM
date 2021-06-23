package Gold;
/**
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4179 {
    static int R;   // row
    static int C;   // column
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        int[][] dist1 = new int[R][C];
        int[][] dist2 = new int[R][C];

        for (int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = str.charAt(j);
                if(str.charAt(j) == 'J')
                    list.add(new Node(i,j,1));
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] == 'F')
                    list.add(new Node(i,j));
            }
        }
        if(R == 1 && C == 1){
            System.out.println(1);
            return;
        }
        bfs(map);
    }

    private static void bfs(char[][] map) {
        Queue<Node> Q = new LinkedList<>();
        for (Node node : list) {
            Q.add(node);
        }
        while (!Q.isEmpty()){
            Node cur = Q.peek();
            Q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx <0 || nx >= R || ny < 0 || ny >= C)   continue;
                if(map[nx][ny] == '#')  continue;
                if(map[cur.x][cur.y] == 'J'){
                    if(map[nx][ny] == 'F' || map[nx][ny] == 'J')  continue;
                    if(nx == 0 || nx == R-1 || ny == 0 || ny == C-1){   // 탈출조건
                        System.out.println(cur.depth + 1);
                        return;
                    }else{
                        Q.add(new Node(nx,ny,cur.depth+1));
                        map[nx][ny] = 'J';
                    }
                }
                if(map[cur.x][cur.y] == 'F'){
                    if(map[nx][ny] == 'F')  continue;
                    Q.add(new Node(nx,ny));
                    map[nx][ny] = 'F';
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}

class Node {
    int x;
    int y;
    int depth;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Node(int x, int y,int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
