package Level1;

/**
 * - 소수 만들기
 *
 * 1. 조합으로 풀어야 하는 줄 알고 있었는데
 *    구글링해보니 그냥 for문 3개를 통해 해결할 수 있었다. -> 그렇지만 시간 복잡도는 좋은 편은 아니다.
 *
 * 2. 조합으로 풀어보기. -> 재귀
 */

public class Main_8 {
    public static void main(String[] args) {
        int n[] = {1,2,7,6,4};
        System.out.println(solution(n));
    }
    public static int solution(int[] nums) {
        int answer = 0;

        for(int i=0;i<=nums.length-3;i++){
            for(int k=i+1;k<=nums.length-2;k++) {
                for (int j = k+1; j <= nums.length-1; j++) {
                    int sum = nums[i] + nums[k] + nums[j];
                    if (isPrime(sum))
                        answer++;
                }
            }
        }

        return answer;
    }

    private static boolean isPrime(int sum) {
        for(int i=2;i<sum;i++){
            if(sum % i == 0)
                return false;
        }
        return true;
    }
}
