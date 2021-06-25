package Silver;

/**
 * 영역 구하기.
 * List 정렬할 경우 Collections.sort 사용하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2583 {
    static int cnt = 0;
    static List<Integer> size = new ArrayList<>();

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int ly = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken()) - 1;
            int rx = Integer.parseInt(st.nextToken()) - 1;

            for(int j=lx;j<=rx;j++){
                for(int c=ly;c<=ry;c++){
                    map[j][c] = -1;
                }
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 0) {
                    cnt++;
                    bfs(i, j, map);
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(size);
        for (Integer a : size) {
            System.out.print(a + " ");
        }
    }

    private static void bfs(int i,int j,int[][] map) {
        int subSize=0;
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j));
        map[i][j] = 1;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            subSize++;
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(map[nx][ny] == 1 || map[nx][ny] == -1)   continue;
                Q.add(new Node(nx,ny));
                map[nx][ny] = 1;    // 방문 체크
            }
        }
        size.add(subSize);
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
