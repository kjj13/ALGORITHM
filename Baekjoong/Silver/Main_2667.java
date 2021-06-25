package Silver;

/**
 * 단지번호 붙이기.
 * bfs를 시작하는 조건에서 방문했을 경우는 제외하는거 주의하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667 {
    static int[][] map;
    static boolean[][] visit;

    static int cnt = 0;
    static List<Integer> size = new ArrayList<>();

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        map = new int[M][M];
        visit = new boolean[M][M];

        for(int i=0;i<M;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
                visit[i][j] = false;
            }
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1 && visit[i][j] == false){
                    cnt++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(size);
        for (Integer a : size) {
            System.out.println(a);
        }
    }

    private static void bfs(int i, int j) {
        int subSize = 0;
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j));
        visit[i][j] = true;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            subSize++;
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length)  continue;
                if(map[nx][ny] == 0 || visit[nx][ny] == true)   continue;
                Q.add(new Node(nx,ny));
                visit[nx][ny] = true;
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
