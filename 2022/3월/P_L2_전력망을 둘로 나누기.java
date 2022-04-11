import java.util.*;

class Solution {
    static int cnt,min;         // 이어진 송전탑 갯수, 정답
    static List<Integer> list;  // 이어진 송전탑 갯수 기록용
    static boolean[][] adj;     // 인접행렬
    static boolean[] visit;     // 방문 체크
    
    public static int solution(int n, int[][] wire) {
        adj = new boolean[n+1][n+1];
        min = Integer.MAX_VALUE;
        
        make_adj(n,wire);
        
        // 로직 시작
        for(int i=0;i<n-1;i++){
            list = new ArrayList<>();
            int from = wire[i][0];
            int to = wire[i][1];
            visit = new boolean[n+1];
            adj[from][to] = false;
            adj[to][from] = false;
            
            for(int j=1;j<n+1;j++){
                if(visit[j]) continue;
                cnt = 0;
                list.add(dfs(j,n));
                // System.out.println(j + " " + cnt);
            }
            adj[from][to] = true;
            adj[to][from] = true;
            int diff = Math.abs(list.get(0) - list.get(1));
            min = min < diff ? min : diff;       
        }
        
        return min;
    }
    
    private static int dfs(int from,int n){
        visit[from] = true;
        cnt++;
        for(int i=1;i<n+1;i++){
            if(adj[from][i] && !visit[i]){
                dfs(i,n);
            }
        }
        return cnt;
    }
    
    private static void make_adj(int n, int[][] wire){
        for(int i=0;i<n-1;i++){
            int from = wire[i][0];
            int to = wire[i][1];
            adj[from][to] = true;
            adj[to][from] = true;
        }
    }
}
