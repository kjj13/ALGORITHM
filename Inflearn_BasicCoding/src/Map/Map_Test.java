package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map_Test {

    public int solve1(String s){
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public List<Integer> solve2(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        //이렇게 하는 이유 : 같은 빈도수의 숫자가 여러개 있을 수 있으므로
        List<Integer>[] list = new List[nums.length + 1];
//        int[] arr = new int[nums.length+1];
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int key : map.keySet()) {
            int topFrequent = map.get(key);
            if (list[topFrequent] == null)
                list[topFrequent] = new ArrayList<>();
            list[topFrequent].add(key);
        }

        //
        for (int lastIndex = list.length - 1; lastIndex >= 0; lastIndex--) {
            if (list[lastIndex] != null) {
                for (int i = 0; i < list[lastIndex].size() && result.size() < k; i++)
                    result.add(list[lastIndex].get(i));
            }
        }
        return result;
    }
}
