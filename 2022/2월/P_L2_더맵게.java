import java.util.*;

class Solution {
    static PriorityQueue<Node> pq;
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        pq = new PriorityQueue<>();
        
        for(int n : scoville){
            pq.add(new Node(n));
        }
        
        while(true){
            int num1 = pq.poll().num;
            if(num1 >= K){
                break;
            }else{
                if(pq.size() == 0){
                    return -1;
                }
                int num2 = pq.poll().num;
                int num = num1 + num2 * 2;
                pq.add(new Node(num));
            }
            answer++;
        }
        
        return answer;
    }
    
    private static class Node implements Comparable<Node>{
        int num;
        
        public Node(int num){
            this.num = num;
        }
        
        public int compareTo(Node other){
            return this.num - other.num;
        }
    }
}
