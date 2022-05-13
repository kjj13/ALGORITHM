import java.util.*;

class Solution {
    boolean[] visit;
    int answer;
    Queue<Integer> Q;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        visit = new boolean[n];
        Q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(!visit[i]){
                Q.add(i);
                visit[i] = true;
                answer++;
                bfs(computers);
            }
        }
        
        return answer;
    }
    
    public void bfs(int[][] com){
        while(!Q.isEmpty()){
            int from = Q.poll();
            for(int i=0;i<com.length;i++){
                if(visit[i] || com[from][i] == 0) continue;
                Q.add(i);
                visit[i] = true;
            }
        }
    }
}
