import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        
        int[] day = new int[len];
        List<Integer> list = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        
        for(int i=0;i<len;i++){
            int a = (100 - progresses[i]) % speeds[i];
            int b = (100 - progresses[i]) / speeds[i];
            int num = a == 0 ? b : b+1;
            if(Q.size() == 0){
                Q.add(num);
                continue;
            }
            if(Q.peek() < num){
                list.add(Q.size());
                Q.clear();
            }
            Q.add(num);
        }
        
        if(!Q.isEmpty()){
            list.add(Q.size());
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
