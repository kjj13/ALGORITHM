package Silver;

/**
 * 7569 - 토마토
 * BFS를 3차원으로 풀면 됨.
 * 문제 풀 때 행 열 헷갈리지 말기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {
    static int dx[] = {0,1,0,-1,0,0};
    static int dy[] = {1,0,-1,0,0,0};
    static int dz[] = {0,0,0,0,1,-1};

    static int[][][] tomato;

    static Queue<Node> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int M = Integer.parseInt(st.nextToken());   // 가로 - 열
        int N = Integer.parseInt(st.nextToken());   // 세로 - 행
        int H = Integer.parseInt(st.nextToken());   // 높이

        tomato = new int[N][M][H];

        int emptyCnt = 0;

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine()," ");
                for(int c=0;c<M;c++){
                    int num = Integer.parseInt(st.nextToken());
                    tomato[j][c][i] =num;
                    if(num == -1)
                        emptyCnt++;
                    if(num == 1)
                        Q.add(new Node(j,c,i,0));
                }
            }
        }

        if((M*N*H - emptyCnt) == Q.size()){ // (전체 갯수 - 빈 공간의 수) 가 큐에 들어있는 수(토마토 들어있음)와 같다면 이미 다 익어있음.
            System.out.println(0);
            return;
        }

        int depth = bfs(M,N,H);

//        BFS가 끝났는데도 안익은 토마토가 있을경우
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int c=0;c<M;c++){
                    if(tomato[j][c][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

//        토마토가 다 익게하는 최소 일수
        System.out.println(depth);
    }

    private static int bfs(int m,int n, int h) {
        int depth =0;
        while (!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir=0;dir<6;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int nz = cur.z + dz[dir];
                if(nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) continue;
                if(tomato[nx][ny][nz] == -1 || tomato[nx][ny][nz] == 1) continue;
                Q.add(new Node(nx,ny,nz,cur.depth+1));
                tomato[nx][ny][nz] = 1;
                depth = cur.depth + 1;
            }
        }
        return depth;
    }

    private static class Node{
        int x;
        int y;
        int z;
        int depth;

        public Node(int x, int y, int z, int depth) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.depth = depth;
        }
    }
}
