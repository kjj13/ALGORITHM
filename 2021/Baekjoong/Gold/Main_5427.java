package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - 불
 *
 * Fdist[nx][ny] != -1 이 조건 생각해보기. -> 아마 불은 -1 인데 상근이는 비교할려고 할 경우 대비하는 것 같음..
 */

public class Main_5427 {
    static char[][] map;
    static int[][] Fdist;
    static int[][] Sdist;

    static Queue<Node> fire = new LinkedList<>();   // 불
    static Queue<Node> sang = new LinkedList<>();   // 상근

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());   // 열
            int n = Integer.parseInt(st.nextToken());   // 행
            map = new char[n][m];
            Fdist = new int[n][m];
            Sdist = new int[n][m];

            init(Fdist);
            init(Sdist);

            fire.clear();
            sang.clear();

            for(int j=0;j<n;j++){
                String s = br.readLine();
                for(int c=0;c<m;c++){
                    char ch = s.charAt(c);
                    map[j][c] = ch;
                    if(ch == '*') {
                        fire.add(new Node(j, c));
                        Fdist[j][c] = 0;
                    }
                    if(ch == '@') {
                        sang.add(new Node(j, c));
                        Sdist[j][c] = 0;
                    }
                }
            }

            F_bfs();
            S_bfs();

        }
    }

//    상근 탈출경로
    private static void S_bfs() {
        while (!sang.isEmpty()){
            Node cur = sang.poll();
            for(int dir = 0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {   // 탈출 조건
                    System.out.println(Sdist[cur.x][cur.y] + 1);
                    return;
                }
                if(map[nx][ny] == '#' || Sdist[nx][ny] >= 0) continue;
//                Fdist[nx][ny] != -1 이 조건 생각해보기. -> 아마 불은 -1 인데 상근이는 비교할려고 할 경우 대비하는 것 같음..
                if(Fdist[nx][ny] != -1 && Fdist[nx][ny] <= Sdist[cur.x][cur.y] + 1) continue;
                sang.add(new Node(nx,ny));
                Sdist[nx][ny] = Sdist[cur.x][cur.y] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

//    불 이동경로
    private static void F_bfs() {
        while (!fire.isEmpty()){
            Node cur = fire.poll();
            for(int dir = 0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(map[nx][ny] == '#' || Fdist[nx][ny] >= 0) continue;
                fire.add(new Node(nx,ny));
                Fdist[nx][ny] = Fdist[cur.x][cur.y] + 1;
            }
        }
    }

    private static void init(int[][] dist) {
        for (int[] ints : dist) {
            Arrays.fill(ints,-1);
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
