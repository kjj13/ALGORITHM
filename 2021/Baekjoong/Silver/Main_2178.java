package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문자 -> 숫자 : str.charAt(j) - '0';
 * 문제 : 미로탐색 -> 최소 경우의 수 구하기.
 * BFS방식으로 처음 시작하는 곳에서 부터의 거리를 통해 구하기.
 * => Node 클래스에 depth 추가 + 마지막 탈출 조건에서 depth 반환 or 출력
 */

public class Main_2178 {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j) - '0';
                visit[i][j] = false;
            }
        }

        System.out.println(bfs(map,visit,0,0));
    }

    private static int bfs(int[][] map, boolean[][] visit, int i, int j) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j,1));
        visit[i][j] = true;

        while (!Q.isEmpty()){
            Node cur = Q.peek();
            Q.poll();
            for (int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;   // 범위 벗어날 경우
                if(visit[nx][ny] == true || map[nx][ny] != 1)  continue;    // 방문했거나 길이 아닌 경우.
                if(nx == map.length-1 && ny == map[0].length-1)
                    return cur.depth+1;
                Q.add(new Node(nx,ny,cur.depth+1));
                visit[nx][ny] = true;
            }
        }
        return 1;
    }
}

