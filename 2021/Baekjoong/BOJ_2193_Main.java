/**
 * baekjoon 2193 : 이친수
 * DATE : 2021.04.07
 * DP문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193_Main {

    static long arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        arr = new long[n];
        arr[0] = 1;
        if(n>1)
            arr[1] = 1;
        if(n>2) {
            for (int i = 2; i < n; i++) {
                arr[i] = arr[i - 2] + arr[i - 1];
            }
        }
        System.out.println(arr[n-1]);
    }
}
