import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    static int[][] map;
    static boolean[][] visit;

    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            Arrays.fill(visit[i],false);
            for(int j=0;j<M;j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);
    }

    private static void bfs(int x, int y) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(x,y,1));
        visit[x][y] = true;

        while (!Q.isEmpty()){
            Node cur = Q.peek();
            Q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(map[nx][ny] == 0 || visit[nx][ny] == true)   continue;
                if(nx == map.length-1 && ny == map[0].length-1){
                    System.out.println(cur.depth + 1);
                    return;
                }
                Q.add(new Node(nx,ny,cur.depth + 1));
                visit[nx][ny] = true;
            }
        }
    }

    private static class Node{
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
