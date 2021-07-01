package Gold;

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

    }

    private static void init(boolean[][] visit) {
        for (boolean[] vis : visit) {
            Arrays.fill(vis,false);
        }
    }

//    섬 체크하면서 Queue 배열 arround 채우기. -> 섬 주변 좌표.
    private static void find_island(int i,int j) {
        Queue<Node> around0 = new LinkedList<>();    // around 큐 배열에 넣을 큐.
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j));
        visit[i][j] = true;
    }

    private static class Node{
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
