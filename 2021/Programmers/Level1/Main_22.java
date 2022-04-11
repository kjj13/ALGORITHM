package Level1;

import java.util.ArrayList;
import java.util.List;

/**
 * -같은 숫자는 싫어
 *
 * arr	answer
 * [1,1,3,3,0,1,1]	[1,3,0,1]
 * [4,4,4,3,3]	[4,3]
 */

public class Main_22 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        int[] result = solution(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int []arr) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        int num = arr[0];
        list.add(num);

        for (int i=0;i<arr.length;i++) {
            if(num == arr[i])
                continue;
            else{
                num = arr[i];
                list.add(num);
            }
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
