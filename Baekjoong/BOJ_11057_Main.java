/**
 * baekjoon 11057 : 오르막 수
 * DATE : 2021.04.06
 * DP문제
 */

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057_Main {

    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int sum = 0;

        dp = new int [N+1][10];
        for(int i=0;i<10;i++){
            dp[1][i] = 1;
        }
        if(N>1) {
            for (int i = 2; i < N + 1; i++) {
                for (int j = 0; j < 10; j++) {
                    for(int k=0;k<=j;k++) {
                        dp[i][j] += dp[i-1][k];
                    }
                    dp[i][j] %= 10007;
                }
            }
        }
        for(int i=0;i<10;i++){
            sum += dp[N][i];
        }
        System.out.println(sum % 10007);
    }
}
