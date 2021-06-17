package Gold;

/**
 * 따로따로 bfs 한다는 게 포인트. + dist 배열로 방문 체크와 이동거리
 *
 *  // 불의 이동거리보다 지훈이의 이동거리가 더 크거나 같을 경우. => 불이 먼저 번져서 이동 못함.
 *  if(dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1)  continue;
 *  이 부분이 중요.
 *  dist1[nx][ny] != -1 이 조건을 생각 못해서 계속 틀렸음..
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
    static int R;   // 행
    static int C;   // 열
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1}; // 상하좌우 네 방향을 의미
    static char[][] map;    // 입력으로 주어진 맵
//   dist를 통해 방문했는지 안했는지도 파악 가능. -> 초기화를 다 -1로 하기.
    static int[][] dist1;   // 불의 예상 거리
    static int[][] dist2;   // 지훈이 탈출 거리
    static Queue<pair> Q1 = new LinkedList<>();    // 불(F)
    static Queue<pair> Q2 = new LinkedList<>();    // 지훈(J)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        dist1 = new int[R][C];
        dist2 = new int[R][C];
        init(dist1);
        init(dist2);

        for(int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = str.charAt(j);
                if(str.charAt(j) == 'J'){
                    Q2.add(new pair(i,j));
                    dist2[i][j] = 0;
                }
                if(str.charAt(j) == 'F'){
                    Q1.add(new pair(i,j));
                    dist1[i][j] = 0;
                }
            }
        }

        bfs_F();    // 불 bfs
        bfs_J();    // 지훈 bfs
    }

    private static void bfs_J() {
        int max = 0;
        while (!Q2.isEmpty()) {
            pair cur = Q2.peek();
            Q2.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= R || ny <0 || ny >= C){  //탈출조건
                    System.out.println(dist2[cur.x][cur.y] + 1);
                    return;
                }
                if(dist2[nx][ny] >= 0 || map[nx][ny] == '#')  continue;   //  방문했을 경우 + 벽인 경우
                // 불의 이동거리보다 지훈이의 이동거리가 더 크거나 같을 경우. => 불이 먼저 번져서 이동 못함.
                if(dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.x][cur.y] + 1)  continue;
                dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
                Q2.add(new pair(nx,ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void bfs_F() {
        while (!Q1.isEmpty()) {
            pair cur = Q1.peek();
            Q1.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= R || ny <0 || ny >= C)   continue;
                if(dist1[nx][ny] >= 0 || map[nx][ny] == '#')  continue;   //  방문했을 경우 + 벽인 경우
                dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
                Q1.add(new pair(nx,ny));
            }
        }
    }

    private static void init(int[][] dist) {
        for (int[] ints : dist) {
            Arrays.fill(ints,-1);
        }
    }

    static class pair {
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}

