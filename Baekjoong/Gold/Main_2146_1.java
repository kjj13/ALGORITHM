package Gold;

/**
 * - 다리 만들기
 *  일단 구글링해서 풀었음.
 *
 *  해결 과정
 *  1. 섬마다 번호를 부여하기.
 *  2. 섬마다 bfs 실시해서 최단거리 구하면서 바로 비교해서 더 작은걸 변수(result)에 저장.
 *      2-1. 섬 가장자리에서 시작해야함 -> 조건 : map[nx][ny]가 현재 섬 번호가 아니어야함.
 *      2-2. map[nx][ny]가 바다인 경우와 다른 섬인 경우 나눠서 생각.
 *  3. 변수(result)를 출력.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2146_1 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int landNum = 2; // 섬 번호 나누기
    static int result = Integer.MAX_VALUE;

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
                if(map[i][j] == 1 && visit[i][j] == false) {
                    map[i][j] = landNum;
                    find_island(i, j);
                }
            }
        }
        init(visit);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] >= 2 && !visit[i][j]){
                    bfs(i,j);
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(int i, int j) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j,0));
        visit[i][j] = true;
        int currentLandNum = map[i][j];
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(visit[nx][ny] || map[nx][ny] == currentLandNum)   continue;  // 방문했거나 같은 섬인 경우 -> 나가
                if(map[nx][ny] == 0){   // 바다 인 경우
                    Q.add(new Node(nx,ny,cur.depth+1));
                    visit[nx][ny] = true;
                }else{  // 다른 섬에 만난 경우
                    result = result < cur.depth ? result : cur.depth;
                }
            }
        }
        init(visit);
    }

    private static void init(boolean[][] visit) {
        for (boolean[] vis : visit) {
            Arrays.fill(vis,false);
        }
    }

    private static void find_island(int i, int j) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(i,j,0));
        visit[i][j] = true;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if(map[nx][ny] == 0 || visit[nx][ny])   continue;
                Q.add(new Node(nx,ny,0));
                visit[nx][ny] = true;
                map[nx][ny] = landNum;
            }
        }
        landNum++;
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
