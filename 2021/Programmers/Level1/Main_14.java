package Level1;

import java.util.Arrays;
import java.util.Collections;

/**
 * - 예산 (다시 풀기)
 *
 * 1.
 * 조합을 사용해서 풀려했으나, 시간초과 + 테스트 케이스 틀림.
 *
 * 2.
 * 오름차순으로 정렬 후 예산보다 합이 예산보다 커졌을 때 반복문 종료하고 반복 횟수 반환
 *
 * d	budget	result
 * [1,3,2,5,4]	9	3
 * [2,2,3,3]	10	4
 */

public class Main_14 {
    static int max = -1;

    public static void main(String[] args) {
        int d[] = {1,3,2,5,4};

        System.out.println(solution(d,9));
    }
    public static int solution(int[] d, int budget) {
//        int answer = 0;
//        int size = d.length;
//
//        boolean[] visited = new boolean[size];
//
//        for(int i=1;i<=d.length;i++) {
//            combination(d, visited,0,size,i,budget);
//        }
//
//        return max;
        Arrays.sort(d);
        int sum = 0;
        int cnt = 0;

        for (int i=0;i<d.length;i++) {
            if(sum + d[i]> budget){
                break;
            }
            sum += d[i];
            cnt++;
        }
        return cnt;
    }

    private static void combination(int[] d,boolean[] visited,int start,int size, int r,int budget){
        if(r == 0){
            int sum = 0;
            int cnt = 0;
            for(int i=0;i<size;i++){
                if(visited[i]){
                    sum += d[i];
                    cnt++;
                }
            }
            if(sum <= budget)
                max = max > cnt ? max : cnt;
        }

        for(int i=start;i<size;i++){
            visited[i] = true;
            combination(d,visited,i+1,size,r-1,budget);
            visited[i] = false;
        }
    }
}
