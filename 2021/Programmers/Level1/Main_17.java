package Level1;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * - 두 개 뽑아서 더하기.
 *
 * TreeSet 자료구조 사용해서 중복제거 + 정렬을 하였다.
 * List<Integer> list = new ArrayList<>(set); => 이렇게 set자료구조를 list로 바꿀수 있음.
 * list -> array로 변환시 iterator 사용해서 변환도 가능.
 *
 * numbers	result
 * [2,1,3,4,1]	[2,3,4,5,6,7]
 * [5,0,2,7]	[2,5,7,9,12]
 */

public class Main_17 {
    public static void main(String[] args) {
        int n[] = {2,1,3,4,1};
        System.out.println(solution(n));
    }

    public static int[] solution(int[] numbers) {
        int[] answer;
        int size = numbers.length;
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);

        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
