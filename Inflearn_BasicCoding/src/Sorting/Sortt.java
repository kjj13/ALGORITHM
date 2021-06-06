package Sorting;

import java.util.*;

public class Sortt {
    public int solve(String v1,String v2){
        String[] vv1 = v1.split("\\.");
        String[] vv2 = v2.split("\\.");

        int len = vv1.length > vv2.length ? vv1.length : vv2.length;

        for(int i=0;i<len;i++){
            Integer n1 = i > vv1.length-1 ? 0 : Integer.parseInt(vv1[i]);
            Integer n2 = i > vv2.length-1 ? 0 : Integer.parseInt(vv2[i]);

            int comp = n1.compareTo(n2);

            if(comp != 0)
                return n1.compareTo(n2);
        }
        return 0;
    }

    public class Interval{
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> solve2(List<Interval> intervals){
        List<Interval> result = new ArrayList<>();

        Collections.sort(intervals,(a,b) -> a.start - b.start);

        Interval before = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval cur = intervals.get(i);
            if(before.end >= cur.start){
                before.end = cur.end;
            }else{
                result.add(before);
                before = cur;
            }
        }

        if(!result.contains(before)){
            result.add(before);
        }

        return result;
    }

    public int solve3(int[] arr){
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : arr){
            pq.add(i);
        }

        while (pq.size() > 1){
            int twosum = pq.poll() + pq.poll();
            sum += twosum;
            pq.add(twosum);
        }

        return sum;
    }

    public List<String> solve4(String[] s,int k){
        List<String> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        for(String word:s){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)
        -> b.getValue() == a.getValue() ?
           a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.add(entry);
        }

        while (k>0){
            result.add(pq.poll().getKey());
            k--;
        }
        return result;
    }
}
