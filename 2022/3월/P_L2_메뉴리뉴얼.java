package month03;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class P_L2_메뉴리뉴얼 {
	static int N,R;
	static boolean[] check;
	static char[] arr;
	static List<String> result;
    // PriorityQueue<Node>[] list;
	static PriorityQueue<Node> pq;
	static Map<String, Integer> map;
    
    public static void main(String[] args) {
		String[] orders = {
				"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
		};
		int[] course = {2,3,4};
		
		String[] ssss = solution(orders, course);
		
		System.out.println(Arrays.toString(ssss));
	}
    
    public static class Node implements Comparable<Node>{
        String str;
        int count;
        
        public Node(String str,int count){
            this.str = str;
            this.count = count;
        }
        
        public int compareTo(Node other){
            return other.count - this.count;
        }
    }
    
    public static String[] solution(String[] orders, int[] course) {
        
        result = new ArrayList<>();
        
        for(int num:course){
            R = num;
            pq = new PriorityQueue<>();
            map = new HashMap<>();
            for(String str : orders){
                // System.out.println("문자열 : " + str + " num : " + num);
                N = str.length();
                if(N < num)    continue;
                arr = str.toCharArray();
                Arrays.sort(arr);
                // System.out.println(Arrays.toString(arr));
                check = new boolean[N];
                comb(0,0,orders);
            }
//            if(pq.isEmpty()) continue;
            
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                result.add(cur.str);
                if(!pq.isEmpty() && cur.count > pq.peek().count){
                    break;
                }
            }
        }
        
        Collections.sort(result);
        
        String[] answer = new String[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public static void comb(int target,int cnt,String[] orders){
        if(cnt == R){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            List<Character> cList = new ArrayList<>();
            for(int i=0;i<N;i++){
                if(check[i]){
                    sb.append(arr[i]);
                }
            }
            if(map.containsKey(sb.toString())) return;
            map.put(sb.toString(), 1);
            for(String str : orders){
            	int a = 0;
            	for (int i=0;i<sb.length();i++) {
					char ch = sb.charAt(i);
					if(str.contains(ch+"")){
	                    a++;
	                }
				}
                if(a == R)	count++;
            }
            if(count >= 2){
//            	pq.add(new Node("sss", 4));
                pq.add(new Node(sb.toString(),count));
            }
            return;
        }
        if(target == N){
            return;
        }
        
        check[target] = true;
        comb(target+1,cnt+1,orders);
        check[target] = false;
        comb(target+1,cnt,orders);
    }
}
