class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = (long) num;  // 오버플로우 항상 유의하기.!!
        while(true){
            if(answer == 500){
                answer = -1;
                break;
            }
            if(n == 1) break;
            if(n % 2 == 0){
                n /= 2;
            }else{
                n *= 3;
                n++;
            }
            answer++;
        }
        return answer;
    }
}
