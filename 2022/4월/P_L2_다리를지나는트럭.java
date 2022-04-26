package year2022.month04;

import java.util.LinkedList;
import java.util.Queue;

public class P_L2_다리를지나는트럭 {
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] {7,4,5,6}));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> Q = new LinkedList<>();
        int answer = 0;
        int curW = 0;
        int cnt = 0;
        int idx = -1;
        
        while(true){
        	if(idx == truck_weights.length-1) {
            	answer += bridge_length;
            	break;
            }
            if(cnt == truck_weights.length) break;
            if(Q.size() == bridge_length){
                int n = Q.poll();
                if(n != 0) {
                	curW -= n;
                	cnt++;
                }
            }
            if(curW + truck_weights[idx+1] <= weight){
                Q.add(truck_weights[++idx]);
                curW += truck_weights[idx];
            }else{
                Q.add(0);
            }
            
            answer++;
        }
        
        return answer;
    }
}
