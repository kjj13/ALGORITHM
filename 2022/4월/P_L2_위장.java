import java.util.*;

class Solution {
    boolean[] check;
    int size,answer;
    
    public int solution(String[][] clothes) {
        answer = 1;
        size = clothes.length;
        check = new boolean[size];
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<size;i++){
            String kind = clothes[i][1];
            map.put(kind,map.getOrDefault(kind,0)+1);
        }
        
        for(String key : map.keySet()){
            answer *= map.get(key) + 1;
        }
        
        // comb(0,clothes);
        
        return answer-1;
    }
    
    public void comb(int target,String[][] clothes){
        if(target == size){
            Map<String,String> map = new HashMap<>();
            boolean correct = true;
            for(int i=0;i<size;i++){
                if(check[i]){
                    String kind = clothes[i][1];
                    if(map.containsKey(kind)){
                        correct = false;
                        break;
                    }else{
                        map.put(kind,clothes[i][0]);
                    }
                }
            }
            if(correct) answer++;
            return;
        }
        
        check[target] = true;
        comb(target+1,clothes);
        check[target] = false;
        comb(target+1,clothes);
    }
}
