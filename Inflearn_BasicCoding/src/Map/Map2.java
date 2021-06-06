package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,5,5,5,5};
        int k = 2;
        System.out.println(solve(nums,k));
    }
    public static List<Integer> solve(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int i : map.keySet()) {
            arr[map.get(i)] = i;
        }
        for(int i=arr.length-1; i >=0 && k>0; i--){
            if(arr[i] > 0){
                result.add(arr[i]);
                k--;
            }
        }
        return result;
    }
}
