package Level1;

import java.util.HashMap;

/**
 * - 폰켓몬
 * nums	result
 * [3,1,2,3]	2
 * [3,3,3,2,2,4]	3
 * [3,3,3,2,2,2]	2
 */

public class Main_4 {
    public static void main(String[] args) {
        int n[] = {3,1,2,3};

        System.out.println(solution(n));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        if((nums.length / 2) <= map.size())
            return answer = nums.length/2;
        else
            return map.size();
    }
}
