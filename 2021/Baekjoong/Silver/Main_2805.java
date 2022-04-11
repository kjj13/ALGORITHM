package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - 나무 자르기.
 *
 * 이분탐색 문제 - 다시풀기.
 */

public class Main_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = max > tree[i] ? max : tree[i];
        }
        int start = 0;
        int end = max;

        while(start <= end){
            int mid = (start + end) /2;
            int sum = 0;

            for(int h : tree){
                if(h > mid){
                    sum += h - mid;
                }
            }

            if(sum >= M)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(end);


    }
}
