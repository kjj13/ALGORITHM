package Level1;

/**
 * - 체육복
 *
 * n	lost	reserve	return
 * 5	[2, 4]	[1, 3, 5]	5
 * 5	[2, 4]	[3]	4
 * 3	[3]	[1]	2
 */

import java.util.Arrays;

public class Main_10 {
    public static void main(String[] args) {
        int n = 3;
        int l[] = {3};
        int r[] = {1};

        System.out.println(solution(n,l,r));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n];
        Arrays.fill(student,1);

        for (int i : lost) {
            student[i-1]--;
        }
        for (int i : reserve) {
            student[i-1]++;
        }
        for(int i=0;i<n;i++){
            if(student[i] == 0){
                if(i == 0){
                    if(student[i+1] > 1){
                        student[i+1]--;
                        student[i]++;
                    }
                }else if(i == n-1){
                    if(student[i-1] > 1){
                        student[i-1]--;
                        student[i]++;
                    }
                }else{
                    if(student[i+1] > 1) {
                        student[i + 1]--;
                        student[i]++;
                    }
                    else if(student[i-1] > 1) {
                        student[i - 1]--;
                        student[i]++;
                    }
                }
            }
        }
        for (int i : student) {
            if(i>=1)
                answer++;
        }

        return answer;
    }
}
