package Gold;

/**
 * - 적록색약
 * 일반인과 적록색약으로 나눠서 BFS 돌림.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
    static char[][] map;
    static boolean[][] N_visit;
    static boolean[][] D_visit;

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        N_visit = new boolean[N][N];
        D_visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = s.charAt(j);
                N_visit[i][j] = false;
                D_visit[i][j] = false;
            }
        }
        int normal = 0;
        int diff = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!N_visit[i][j]){
                    normal++;
                    N_bfs(i,j);
                }
                if(!D_visit[i][j]){
                    diff++;
                    D_bfs(i,j);
                }
            }
        }

        System.out.println(normal + " " + diff);
    }

//    적록색약 인 경우
    private static void D_bfs(int i,int j) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j));
        D_visit[i][j] = true;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(map[cur.x][cur.y] != 'B') {  // 현재 색이 파란색이 아닌경우
                    if (map[nx][ny] == 'B' || D_visit[nx][ny] == true) continue;    // R,G는 같은 색으로 취급하므로 B만나면 같은 영역 아닌걸로.
                }else{  // 현재 색이 파란색인 경우.
                    if(map[cur.x][cur.y] != map[nx][ny] || D_visit[nx][ny] == true) continue;   // 현재 색과 다른걸 만나면 같은 영역이 아닌걸로.
                }
                Q.add(new Node(nx, ny));
                D_visit[nx][ny] = true;
            }
        }
    }

//    일반인인 경우
    private static void N_bfs(int i, int j) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j));
        N_visit[i][j] = true;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(map[cur.x][cur.y] != map[nx][ny] || N_visit[nx][ny] == true) continue;
                Q.add(new Node(nx,ny));
                N_visit[nx][ny] = true;
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
