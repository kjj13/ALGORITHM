class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int x=3;x<=total/3;x++){
            if(total % x == 0){
                int y = total / x;
                int sum = x * 2 + y * 2 - 4;
                if(brown == sum){
                    answer[1] = x;
                    answer[0] = y;
                    break;
                }
            }
        }
        
        return answer;
    }
}
