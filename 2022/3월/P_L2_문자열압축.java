/*
    1 ~ 길이의 반까지 for문 돌려서 확인
    max 출력
*/
import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        int size = s.length();
        
        if(size == 1){
            return 1;
        }
        
        for(int i=1;i<=size/2;i++){
            int cnt = 1;
            String tmp = "";
            String right = "";
            String left = s.substring(0,i);
            
            for(int j=i;j<size;j+=i){
                if(j+i > size) right = s.substring(j);
                else right = s.substring(j,j+i);
                
                if(left.equals(right))  cnt++;
                else{
                    if(cnt != 1)    tmp+=cnt;
                    tmp += left;
                    left = right;
                    cnt = 1;
                }
            }
            if(cnt != 1)    tmp += cnt;
            tmp += left;
            min = Math.min(min,tmp.length());
        }
        
        return min;
    }
}
