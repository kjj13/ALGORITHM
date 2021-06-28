package Silver;

/**
 * - 안전영역
 * 물의 높이를 반복문으로해서 각각의 높이마다의 안전영역을 배열에 저장한 후
 * Collection.max 함수를 사용해서 최댓값 출력.
 *
 * + 방문체크할때 2차원 배열 or 3차원 배열 선택.
 * 1. 2차원 배열 : 반복문 하나 더 만들어서 false로 초기화 계속 해줘야함.
 * 2. 3차원 배열 : 건물 높이 최댓값만큼의 공간 더 사용해야함.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2468 {
    static int N;
    static int max = 0;
    static int min = 101;

    static List<Integer> arr = new ArrayList<>();   // 안전 영역의 갯수 저장 배열
    static int[][] map;
    static boolean[][][] visit; // 반복문 하나 더 만들어서 이차원 배열 초기화 하던지 3차원 배열로 할지

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                max = max > num ? max : num;
                min = min < num ? min : num;
            }
        }

        visit = new boolean[N][N][max+1];

        for(int idx=min-1;idx<=max;idx++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > idx && visit[i][j][idx] == false){
                        cnt++;
                        bfs(i,j,idx);
                    }
                }
            }
            arr.add(cnt);
        }
        int m = Collections.max(arr);
        System.out.println(m);
    }

    private static void bfs(int i, int j, int idx) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j));
        visit[i][j][idx] = true;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) continue;
                if(map[nx][ny] <= idx || visit[nx][ny][idx] == true) continue;
                Q.add(new Node(nx,ny));
                visit[nx][ny][idx] = true;
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
