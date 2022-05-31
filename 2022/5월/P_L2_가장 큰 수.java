import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        
        for(int num:numbers){
            // list.add(num + "");
            list.add(String.valueOf(num));
        }
        
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String o1,String o2){
                return (o2+o1).compareTo(o1+o2);    // 앞뒤가 더 큰지 뒤앞이 더 큰지 비교
            }
        };
        
        Collections.sort(list,comp);
        
        if(list.get(0).equals("0")){
            return "0";
        }
        
        for(String str : list){
            answer += str;
        }
        
        return answer;
    }
    
}
