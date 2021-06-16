package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 7576. 토마토 - 시작점이 여러개인 BFS문제
 * BFS의 특징
 *  : BFS를 돌때 큐에 쌓이는 순서는 반드시 거리순이다.!
 */

public class Main_7576 {
    static int n;
    static int m;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());   //6
        n = Integer.parseInt(st.nextToken());   //4

        int[][] tomato = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                int num = Integer.parseInt(st.nextToken());
                tomato[i][j] = num;
                visit[i][j] = false;
                if(num == 1)
                    list.add(new Node(i,j,0));
            }
        }
        System.out.println(bfs(tomato,visit));

    }

    private static int bfs(int[][] tomato,boolean[][] visit) {
        int depth = 0;
        Queue<Node> Q = new LinkedList<>();
        for (Node node : list) {
            Q.add(node);
            visit[node.x][node.y] = true;
        }

        while (!Q.isEmpty()){
            Node cur = Q.peek();
            Q.poll();
            depth = cur.depth;
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= n || ny <0 || ny >= m)   continue;
                if(visit[nx][ny] == true || tomato[nx][ny] != 0)    continue;
                Q.add(new Node(nx,ny,cur.depth+1));
                visit[nx][ny] = true;
                tomato[nx][ny] = 1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(tomato[i][j] == 0)
                    return -1;
            }
        }

        return depth;
    }
}
