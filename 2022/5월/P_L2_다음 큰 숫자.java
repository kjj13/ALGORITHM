class Solution {
    public int solution(int n) {
        int answer = n+1;
        int original = convert(n);
        
        while(true){
            if(original == convert(answer)){
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    public int convert(int num){
        int cnt = 1;
        while(true){
            if(num == 1)    break;
            if(num % 2 == 1) cnt++;
            num /= 2;
        }
        return cnt;
    }
}
