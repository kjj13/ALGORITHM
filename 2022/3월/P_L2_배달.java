import java.util.*;

class Solution {
    int size;
    PriorityQueue<Node> pq;
    List<List<Node>> adj;
    boolean[] visit;
    int[] DP;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        size = N + 1;
        pq = new PriorityQueue<>();
        adj = new ArrayList<List<Node>>();
        visit = new boolean[size];
        DP = new int[size];
        
        for(int i=0;i<size;i++){
            // adj.get(i) = new ArrayList<Node>();
            adj.add(new ArrayList<Node>());
            DP[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<road.length;i++){
            int from = road[i][0];
            int to = road[i][1];
            int time = road[i][2];
            adj.get(from).add(new Node(to,time));
            adj.get(to).add(new Node(from,time));
        }
        
        pq.add(new Node(1,0));
        DP[1] = 0;
        bfs();
        
        
        for(int i=0;i<size;i++){
            if(DP[i] <= K){
                answer++;
            }
        }

        return answer;
    }
    
    public void bfs(){
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(Node next : adj.get(cur.num)){
                if(visit[next.num]) continue;
                if(DP[next.num] > DP[cur.num] + next.time){
                    DP[next.num] = DP[cur.num] + next.time;
                    pq.add(next);
                }
            }
        }
    }
    
    public class Node implements Comparable<Node>{
        int num,time;
        
        public Node(int num,int time){
            this.num = num;
            this.time = time;
        }
        
        public int compareTo(Node other){
            return this.num - other.num;
        }
    }
}
