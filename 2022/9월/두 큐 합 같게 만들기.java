import java.util.*;

class Solution {
    Queue<Integer> Q1,Q2;
    int cnt;
    long sum1,sum2;
    
    public int solution(int[] queue1, int[] queue2) {
        int cnt = 0;
        
        Q1 = new LinkedList<>();
        Q2 = new LinkedList<>();
        sum1 = 0;
        sum2 = 0;
        for(int i=0;i<queue1.length;i++){
            Q1.add(queue1[i]);
            Q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        while(true){
            if(sum1 == sum2)    break;
            if(cnt > (queue1.length + queue2.length) * 2){
            // if(Q1.isEmpty() || Q2.isEmpty()){
                cnt = -1;
                break;
            }
            cnt++;
            
            if(sum1 > sum2){
                int num = Q1.poll();
                Q2.add(num);
                sum1 -= num;
                sum2 += num;
            }else{
                int num = Q2.poll();
                Q1.add(num);
                sum2 -= num;
                sum1 += num;
            }
        }
        
        
        return cnt;
    }
}
