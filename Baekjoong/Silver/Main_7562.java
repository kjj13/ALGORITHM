package Silver;

/**
 * - 나이트의 이동.
 * 방문한 곳은 다시 갈 수 없는지 알 수 없어서 방문체크를 안했더니 틀렸다..
 * bfs문제는 그냥 방문체크는 무조건 해야겠다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {
    static int dx[] = {-1,-2,-2,-1,1,2,2,1};
    static int dy[] = {2,1,-1,-2,-2,-1,1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int I = Integer.parseInt(br.readLine());
            int[][] map = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()," ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            if(startX == endX && startY == endY)
                System.out.println(0);
            else
                bfs(startX,startY,endX,endY,map);
        }
    }

    private static void bfs(int startX, int startY, int endX, int endY, int[][] map) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(startX,startY,0));
        map[startX][startY] = 1;

        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir=0;dir<8;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] == 1) continue;
                if(nx == endX && ny == endY){
                    System.out.println(cur.depth+1);
                    return;
                }
                Q.add(new Node(nx,ny,cur.depth+1));
                map[nx][ny] = 1;
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
