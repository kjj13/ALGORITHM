package Level1;

import java.util.ArrayList;
import java.util.List;

/**
 * - 모의고사
 * list -> array 변환하는 방법.
 * for문을 통해 변환.
 * ==== toArray() 함수는 안됨. ====
 *
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 */

public class Main_6 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};


        System.out.println(solution(a));
    }

    public static int[] solution(int[] answers) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[3];
        int Max = -1;
        int idx = 0;

        int[] solve1 = {1,2,3,4,5};
        int[] solve2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] solve3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i=0;i<answers.length;i++){
            int num = answers[i];
            if(num == solve1[i % 5])
                cnt[0]++;
            if(num == solve2[i % solve2.length])
                cnt[1]++;
            if(num == solve3[i % solve3.length])
                cnt[2]++;
        }

        Max = cnt[0] > cnt[1] ? cnt[0] : cnt[1];
        Max = Max > cnt[2] ? Max : cnt[2];

        for(int i=0;i<3;i++){
            if(Max == cnt[i]){
                ans.add(i+1);
            }
        }

        int[] answer = new int[ans.size()];
        for (Integer a : ans) {
            answer[idx++] = a;
        }

        return answer;
    }
}
