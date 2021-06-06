/**
 * getOrDefault(ch,0) : ch가 존재할 경우 map.get(ch)값 리턴
 *                     ch 존재하지 않을 경우 디폴트인 0 리턴!
 * containsKey(ch) : ch 존재하면 true
 *                   ch 존재하지 않으면 false
 */

package Map;

import java.util.HashMap;
import java.util.Map;

public class Map1 {
    public static void main(String[] args) {
        String s = "inflearninlove";
        System.out.println(solve(s));
    }
    public static int solve(String s){
        char[] str = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();

////        containsKey 사용해서 푸는법
//        for(char ch:s.toCharArray()){
//            if(!map.containsKey(ch)){
//                map.put(ch,1);
//            }else{
//                map.put(ch,map.get(ch)+1);
//            }
//        }

/**********        이 위에 부분을 getOrDefault 사용하면 한줄로 가능하다.!!  *********/

//        getOrDefault 사용해서 푸는법
        for(int i=0;i<str.length;i++){
            map.put(str[i],map.getOrDefault(str[i],0)+1);
        }
        for(int i=0;i<str.length;i++){
            if(map.get(str[i]) == 1){
                return i;
            }
        }

        return -1;
    }

    public static void print(Map<Character,Integer> map){
        for(Character key:map.keySet()){
            System.out.println("key : " + key + " value : " + map.get(key));
        }
    }
}
