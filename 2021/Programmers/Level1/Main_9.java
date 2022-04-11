package Level1;

/**
 * - 내적
 *
 * a	b	result
 * [1,2,3,4]	[-3,-1,0,2]	3
 * [-1,0,1]	[1,0,-1]	-2
 */

public class Main_9 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        int b[] = {-3,-1,0,2};

        System.out.println(solution(a,b));
    }
    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i=0;i<a.length;i++){
            int sum = a[i] * b[i];
            answer += sum;
        }

        return answer;
    }
}
