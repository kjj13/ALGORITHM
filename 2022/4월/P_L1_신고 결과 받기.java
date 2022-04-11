import java.util.*;

class Solution {
    Map<String,Integer> map;
    List<Set<Integer>> adj;
    int[] answer,arr;
    List<Integer> list;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        map = new HashMap<>();
        adj = new ArrayList<Set<Integer>>();
        list = new ArrayList<>();
        int len = id_list.length;
        
        arr = new int[len];
        answer = new int[len];
        
        for(int i=0;i<len;i++){
            adj.add(new HashSet<Integer>());
            map.put(id_list[i],i);
        }
        
        for(int i=0;i<report.length;i++){
            StringTokenizer st = new StringTokenizer(report[i]," ");
            String from = st.nextToken();
            String to = st.nextToken();
            int fromIdx = map.get(from);
            int toIdx = map.get(to);
            adj.get(fromIdx).add(toIdx);
        }
        
        for(int i=0;i<len;i++){
            for(int num : adj.get(i)){
                if(arr[num] >= k) continue;
                if(++arr[num] == k) 
                    list.add(num);
            }
        }
        
        for(int i=0;i<len;i++){
            for(int num : adj.get(i)){
                if(list.contains(num)){
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}
