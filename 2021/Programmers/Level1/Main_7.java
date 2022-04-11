package Level1;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * array	commands	return
 * [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 */

public class Main_7 {
    public static void main(String[] args) {

    }
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<commands.length;i++){
            List<Integer> list = new ArrayList<>();

            int a = commands[i][0] - 1; // -> i
            int b = commands[i][1]; // -> j
            int k = commands[i][2]; // -> k
            for(int z = a;z < b;z++){
                list.add(array[z]);
            }
            Collections.sort(list);
            ans.add(list.get(k-1));
        }

        int[] answer = new int[ans.size()];
        int idx = 0;

        for (Integer a : ans) {
            answer[idx++] = a;
        }
        return answer;
    }
}
