package Level1;

import java.util.ArrayList;
import java.util.List;

/**
 * - 약수의 개수와 덧셈
 *
 * 1인 경우는 list의 크기가 0이 되므로 따로 처리해줬어야함.
 *
 * left	right	result
 * 13	17	43
 * 24	27	52
 */

public class Main_15 {
    public static void main(String[] args) {
        System.out.println(solution(1,2));
    }
    public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            if(i == 1){
                answer -= 1;
                continue;
            }
            if(cnt(i) % 2 == 0){
                answer += i;
            }else
                answer -= i;
        }

        return answer;
    }

    private static int cnt(int num) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<num;i++){
            if(num % i == 0 && !list.contains(i)) {
                list.add(i);
                if(i != num/i) {
                    list.add(num / i);
                }
            }
        }
        return list.size();
    }
}
