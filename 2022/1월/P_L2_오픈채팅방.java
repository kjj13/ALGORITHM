import java.util.*;

class Solution {
    static HashMap<String,String> map;
    
    public String[] solution(String[] record) {
        map = new HashMap<>();
        int size = 0;
        int i = 0;
        
        for(String str : record){
            StringTokenizer st = new StringTokenizer(str," ");
            String a = st.nextToken();
            if(!a.equals("Change")) size++;
            if(a.equals("Change") || a.equals("Enter")){
                map.put(st.nextToken(),st.nextToken());
            }
        }
        String[] answer = new String[size];
        for(String str : record){
            StringTokenizer st = new StringTokenizer(str," ");
            String a = st.nextToken();
            String id = st.nextToken();
            if(a.equals("Enter")){
                answer[i++] = map.get(id) + "님이 들어왔습니다.";
            }else if(a.equals("Leave")){
                answer[i++] = map.get(id) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
