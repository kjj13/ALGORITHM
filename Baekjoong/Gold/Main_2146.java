package Gold;

/**
 * 잘못된 풀이법.
 *
 * - 다리 만들기
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2146 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static List<Queue> around = new ArrayList<>();

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 1 && visit[i][j] == false)
                    find_island(i,j);
            }
        }
        init(visit);

        System.out.println();
    }

    private static void init(boolean[][] visit) {
        for (boolean[] vis : visit) {
            Arrays.fill(vis,false);
        }
    }

//    섬 체크하면서 Queue 배열 around 채우기. -> 섬 주변 좌표.
    private static void find_island(int i,int j) {
        Queue<Node> around0 = new LinkedList<>();    // around 큐 배열에 넣을 큐.
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j));
        visit[i][j] = true;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(map[nx][ny] == 0){
                    Node curr = new Node(nx,ny);
                    if(!around0.contains(curr))
                        around0.add(curr);
                    continue;
                }
                if(visit[nx][ny])   continue;
                Q.add(new Node(nx,ny));
                visit[nx][ny] = true;
            }
        }
        around.add(around0);
    }

    static class Node{
        int x;
        int y;
        int depth;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
