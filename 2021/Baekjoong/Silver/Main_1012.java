package Silver;

/**
 * 1로 구성된 영역의 갯수 세기 -> 완전 탐색 이용 -> BFS 활용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012 {
    static int[][] map;
    static boolean[][] visit;

    static int dx[]= {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int c=0;c<T;c++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());   // 가로
            int N = Integer.parseInt(st.nextToken());   // 세로
            int K = Integer.parseInt(st.nextToken());   // 배추 갯수

            map = new int[M][N];
            visit = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && visit[i][j] == false) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    private static void bfs(int i, int j) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j));
        visit[i][j] = true;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir = 0;dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(map[nx][ny] == 0 || visit[nx][ny] == true)   continue;
                Q.add(new Node(nx,ny));
                visit[nx][ny] = true;
            }
        }
    }

    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
