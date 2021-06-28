package Gold;

/**
 * 벽 부수고 이동하기.
 * visit를 3차원 배열로 해서 안 부신 경우와 벽을 한번 부신 경우로 나눠서 생각.
 * 다시 풀기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visit;   // 벽을 몇 번 깼는지에 따라 방문체크 다르게함.

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M][2];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(0,0,1,0));
        visit[0][0][0] = true;
        visit[0][0][1] = true;

        while (!Q.isEmpty()){
            Node cur = Q.poll();

            if(cur.x == N-1 && cur.y == M-1){
                System.out.println(cur.depth);
                return;
            }

            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)   continue;
//                  벽을 부시지 않은 경우 + 방문하지 않은 경우.
                if(cur.cnt == 0 && visit[nx][ny][0] == false){
//                    벽이 아닌 경우
                    if(map[nx][ny] == 0) {
                        Q.add(new Node(nx, ny, cur.depth + 1, cur.cnt));
                        visit[nx][ny][0] = true;
                    }else{  // 벽인 경우
                        Q.add(new Node(nx, ny, cur.depth + 1, cur.cnt + 1));
                        visit[nx][ny][1] = true;
                    }
                }else if(cur.cnt == 1 && visit[nx][ny][1] == false){    // 벽을 한번 부신 경우 + 방문하지 않은 경우
                    // 벽이 아닌 경우만 생각.
                    if(map[nx][ny] == 0) {
                        Q.add(new Node(nx, ny, cur.depth + 1, cur.cnt));
                        visit[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static class Node{
        int x;
        int y;
        int depth;
        int cnt;

        public Node(int x, int y, int depth, int cnt) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.cnt = cnt;
        }
    }
}
