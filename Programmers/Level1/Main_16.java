package Level1;

import java.util.*;

/**
 * - 실패율
 *
 * Collections.sort를 활용해서 map의 value 정렬하는 방법 제대로 알기.
 *
 *  List<Integer> keySetList = new ArrayList<>(fail.keySet());
 *  : fail이라는 Map 자료구조의 Key 값만 모아서 List를 만듦.
 *  Collections.sort(keySetList, (o1,o2) -> fail.get(o2).compareTo(fail.get(o1)));
 *  : 위에서 만들어진 List인 keySetList를 fail Map자료구조의 value값을 기준으로 정렬.!!
 *
 * N	stages	result
 * 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
 * 4	[4,4,4,4,4]	[4,1,2,3]
 */

public class Main_16 {
    public static void main(String[] args) {
        int s[]  = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(solution(5,s));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer, Double> fail = new HashMap<>();
        int size = stages.length;


        for (int stage : stages) {
            if(stage > N)
                continue;
            map.put(stage,map.getOrDefault(stage,0) + 1);
        }

        for(int i=1;i<=N;i++){
            double failRate = 0;
            if(map.containsKey(i)) {
                failRate = (double)map.get(i) / (double)size;
                size -= map.get(i);
            }
            else{
                failRate = 0;
            }
            fail.put(i,failRate);
        }

        List<Integer> keySetList = new ArrayList<>(fail.keySet());

        Collections.sort(keySetList, (o1,o2) -> fail.get(o2).compareTo(fail.get(o1)));

        int idx = 0;
        for (Integer key : keySetList) {
            answer[idx++] = key;
        }

        return answer;
    }
}
