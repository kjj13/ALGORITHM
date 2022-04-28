import java.util.*;

class Solution {
    List<List<Integer>> adj;
    boolean[] visit;
    Queue<Integer> Q;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        adj = new ArrayList<List<Integer>>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        visit = new boolean[n+1];
        Q = new LinkedList<>();
        
        for(int i=0;i<edge.length;i++){
            int from = edge[i][0];
            int to = edge[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        Q.add(1);
        visit[1] = true;
        
        answer = bfs();
        
        return answer;
    }
    
    public int bfs(){
        int cnt = 0;
        while(!Q.isEmpty()){
            int size = Q.size();
            cnt = size;
            for(int i=0;i<size;i++){
                int cur = Q.poll();
                for(int next : adj.get(cur)){
                    if(visit[next]) continue;
                    Q.add(next);
                    visit[next] = true;
                }
            }
        }
        return cnt;
    }
}
