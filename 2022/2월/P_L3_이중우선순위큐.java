import java.util.*;

class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        for(String str : operations){
            StringTokenizer st = new StringTokenizer(str," ");
            char c = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            if(c == 'I'){
                maxHeap.add(num);
                minHeap.add(num);
            }else{
                if(num == 1 && !maxHeap.isEmpty()){
                    int maxNum = maxHeap.peek();
                    maxHeap.remove(maxNum);
                    minHeap.remove(maxNum);
                }else if(num == -1 && !minHeap.isEmpty()){
                    int minNum = minHeap.peek();
                    maxHeap.remove(minNum);
                    minHeap.remove(minNum);
                }
            }
        }
        
        if(maxHeap.isEmpty() || minHeap.isEmpty()){
            return answer;
        }else{
            int max = maxHeap.poll();
            int min = minHeap.poll();
            if(max > min){
                answer[0] = max;
                answer[1] = min;
            }
            return answer;
        }
    }
}
