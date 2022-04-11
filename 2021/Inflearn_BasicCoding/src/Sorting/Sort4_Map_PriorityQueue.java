package Sorting;

import java.util.*;

public class Sort4_Map_PriorityQueue {
    public static void main(String[] args) {
        String[] words = { "i", "study", "inflearn", "i", "study", "coding"};
        int k = 2;
        System.out.println(solve(words,k));
    }
    public static List<String> solve(String[] words,int k){
        List<String> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        for(String s:words){
            map.put(s,map.getOrDefault(s,0) +1 );
        }

        Queue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b) ->
                a.getValue() == b.getValue() ?
                a.getKey().compareTo(b.getKey()) : b.getValue()- a.getValue());

//        map 반복문 돌기 : keySet() 활용.
//        for(String key:map.keySet()){
//
//        }

//        map 반복문 돌기 : entrySet() 활용.
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            pq.add(entry);
        }

        while (k>0){
            result.add(pq.poll().getKey());
            k--;
        }

        return result;
    }
}
