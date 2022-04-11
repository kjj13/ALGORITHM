package Level1;

/**
 * - 완주하지 못한 선수.
 */

import java.util.HashMap;
import java.util.Map;

public class Main_1 {
    public static void main(String[] args) {
        String[] p = {"mislav", "stanko", "mislav", "ana"};
        String[] c = {"stanko", "mislav", "ana"};

        System.out.println(solution(p,c));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for (String c : completion) {
            map.replace(c,map.get(c)-1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1)
                answer = entry.getKey();
        }

        return answer;
    }
}
