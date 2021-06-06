package String_1;

import java.util.Arrays;

public class Stringg {
    private static int len = -1;
    private static int start;
    private static int end;

    public static void main(String[] args) {
        String s = "bababas";

        System.out.println(solve(s));
    }
    public static String solve(String s){
        for(int i=0;i<s.length()-1;i++){
            findSubstring(s,i,i);
            findSubstring(s,i,i+1);
        }
        return s.substring(start,end +1);
    }

    public static void findSubstring(String s,int left, int right) {
        //while문 순서 주의! left, right에 관한 조건이 먼저 나와야함..
        while (left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        if(len < right - left -1){
            start = left +1 ;
            end = right - 1;
            len = right - left -1;
        }
    }
}
