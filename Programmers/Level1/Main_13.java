package Level1;

import java.util.ArrayList;
import java.util.List;

/**
 * - 3진법 뒤집기
 *
 *  n	result
 * 45	7
 * 125	229
 */

public class Main_13 {
    public static void main(String[] args) {
        System.out.println(solution(45));
    }
    public static int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        while (n > 2){
            list.add(n%3);
            n /= 3;
        }
        list.add(n);

        for(int i=0;i<list.size();i++){
            int mul = 1;
            if(list.get(i) == 0)
                continue;
            for(int j=1;j<list.size()-i;j++){
                mul *= 3;
            }
            answer += (list.get(i) * mul);
        }

        return answer;
    }
}
