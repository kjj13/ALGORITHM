class Solution {
    public long solution(int price, int money, int count) {
        long answer = (long) money;
        
        for(int i=1;i<=count;i++){
            answer -= price * i;
        }
        
        answer = answer > 0 ? 0 : answer;

        return Math.abs(answer);
    }
}
