package basic;

/**
 * BFS 기본 형식.!!!
 */

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] board = {{1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}; // 1이 파란 칸, 0이 빨간 칸에 대응

        boolean[][] vis = new boolean[502][502];
        int n = 7, m = 10; // n = 행의 수, m = 열의 수
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1}; // 상하좌우 네 방향을 의미
        Queue<Pair> Q = new LinkedList<>();

        vis[0][0] = true; // (0, 0)을 방문했다고 명시
        Q.add(new Pair(0,0)); // 큐에 시작점인 (0, 0)을 삽입.
        while (!Q.isEmpty()) {
            Pair cur = Q.peek();
            Q.poll();
            System.out.print("(" + cur.first + ", " + cur.second + ") => ");
            for (int dir = 0; dir < 4; dir++) { // 상하좌우 칸을 살펴볼 것이다.
                int nx = cur.first + dx[dir];
                int ny = cur.second + dy[dir]; // nx, ny에 dir에서 정한 방향의 인접한 칸의 좌표가 들어감
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위 밖일 경우 넘어감
                if (vis[nx][ny] || board[nx][ny] != 1) continue; // 이미 방문한 칸이거나 파란 칸이 아닐 경우
                vis[nx][ny] = true; // (nx, ny)를 방문했다고 명시
                Q.add(new Pair(nx,ny));
            }

        }
    }
}

class Pair{
    Integer first;
    Integer second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}
