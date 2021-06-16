package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS 문제.
 * 그림.
 */

public class Main_1926 {
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1}; // 상하좌우 네 방향을 의미

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] str = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        int cnt = 0;    // 그림 갯수
        int max = 0;    // 제일 큰 크기

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++) {
                str[i][j] = Integer.parseInt(st.nextToken());
                vis[i][j] = false;
            }
        }

        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(str[i][j] == 1 && vis[i][j] == false){
                    cnt++;
                    int depth = bfs(str,vis,i,j);
                    max = max > depth ? max : depth;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    private static int bfs(int[][] str, boolean[][] vis , int i, int j) {
        Queue<Node> Q = new LinkedList<>();
        int depth = 0;
        Q.add(new Node(i,j));
        vis[i][j] = true;

        while (!Q.isEmpty()){
            Node cur = Q.peek();
            Q.poll();
            depth++;
            for (int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= str.length || ny < 0 || ny >= str[0].length) continue;
                if(vis[nx][ny] == true || str[nx][ny] != 1) continue;
                vis[nx][ny] = true;
                Q.add(new Node(nx,ny));
            }
        }
        return depth;
    }
}


