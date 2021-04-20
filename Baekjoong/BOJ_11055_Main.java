/**
 * baekjoon 11055 : 오르막 수
 * DATE : 2021.04.19
 * DP문제
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11055_Main {

    static int dp[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        arr = new int[n];
        dp = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        dp[0] = arr[0];

        for(int i=1; i<n;i++){
            dp[i] = arr[i];
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    dp[i] = (dp[j] + arr[i]) > dp[i] ? (dp[j] + arr[i]) : dp[i];
                }
            }
        }

        Arrays.sort(dp);

        System.out.print(dp[n-1]);
    }
}
