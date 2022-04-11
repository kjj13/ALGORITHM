import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = -1;
        int len = land.length;
        int[][] DP = new int[len][4];
        for(int i=0;i<4;i++){
            DP[0][i] = land[0][i];
        }
        // 초기 설정 완료

        for(int i=1;i<len;i++){
            for(int j=0;j<4;j++){
                int max = -1;
                for(int k=0;k<4;k++){
                    if(j != k){ // 다른 열인 경우
                        max = Math.max(max,DP[i-1][k]);
                    }
                }
                DP[i][j] = land[i][j] + max;
                if(i == len-1){
                    answer = Math.max(answer,DP[i][j]);
                }
            }
        }

        return answer;
    }
}
