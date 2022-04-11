package Gold;

/**
 * - 빙산
 * 1. bfs를 통해 영역의 갯수(cnt) 체크. - 무한루프 안
 *  1-1. 종료 조건
 *      1) cnt == 0 : 0 출력 (다 녹은 경우)
 *      2) cnt >= 2 : cnt 출력 (영역이 2개 이상인 경우)
 *  1-2. 녹이기.
 *      0 < cnt < 2 인 경우.
 *      check 2차원 배열을 통해 주변의 1의 갯수를 저장.
 *      map - check 를 통해 녹은 빙산 표현. - 주의점. map이 0보다 작아지는 경우에서 0으로 하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573 {
    static int N,M;

    static int[][] map;
    static boolean[][] visit;
    static int[][] check;   // 주변의 1의 갯수.

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int yearCnt = 0;

        while (true){
            int cnt = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j] > 0 && visit[i][j] == false){
                        cnt++;
                        bfs(i,j);
                    }
                }
            }

            if(cnt == 0){
                System.out.println(0);
                break;
            }else if(cnt < 2){
                yearCnt++;
                meltICE();
            }else{
                System.out.println(yearCnt);
                break;
            }
        }
    }

    private static void meltICE() {
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                /**
                 * 이 부분에서 0보다 작아지는 경우를 신경쓰지 못해서 틀렸음..
                 */
                map[i][j] = (map[i][j] - check[i][j]) < 0 ? 0 : (map[i][j] - check[i][j]);
            }
        }
        for (boolean[] b : visit) {
            Arrays.fill(b,false);
        }
        for (int[] i : check) {
            Arrays.fill(i,0);
        }
    }

    private static void bfs(int i, int j) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j));
        visit[i][j] = true;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
                if(visit[nx][ny] == true)   continue;
                if(map[nx][ny] == 0){
                    check[cur.x][cur.y]++;
                    continue;
                }
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
