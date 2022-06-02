class Solution {
    boolean solution(String s) {
        s.toLowerCase();
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // String ch = String.valueOf(s.charAt(i)).toLowerCase();
            
            if(ch == 'p'){
                pCnt++;
            }else if(ch == 'y'){
                yCnt++;
            }
        }
        answer = pCnt == yCnt ? true : false;

        return answer;
    }
}
