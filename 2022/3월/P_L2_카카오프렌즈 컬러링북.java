import java.util.*;

class Solution {
    int max;
    Queue<Node> Q;
    boolean[][] visit;
    
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    
    public int[] solution(int m, int n, int[][] picture) {
        max = Integer.MIN_VALUE;
        int cnt = 0;
        Q = new LinkedList<>();
        visit = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j] > 0 && !visit[i][j]){
                    Q.add(new Node(i,j));
                    visit[i][j] = true;
                    bfs(picture,m,n);
                    cnt++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = cnt;
        answer[1] = max;
        return answer;
    }
    
    public void bfs(int[][] p,int m,int n){
        int cnt = 1;
        while(!Q.isEmpty()){
            Node cur = Q.poll();
            for(int dir = 0; dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n ||
                  visit[nx][ny] || p[cur.x][cur.y] != p[nx][ny])
                    continue;
                Q.add(new Node(nx,ny));
                visit[nx][ny] = true;
                cnt++;
            }
        }
        max = Math.max(max,cnt);
    }
    
    public class Node{
        int x,y;
        
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
