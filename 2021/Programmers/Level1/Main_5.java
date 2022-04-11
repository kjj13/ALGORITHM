package Level1;

import java.util.Stack;

/**
 * - 신규 아이디 추천
 * 정규표현식 사용해서 다시 풀기.
 *
 * no	new_id	result
 * 예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
 * 예2	"z-+.^."	"z--"
 * 예3	"=.="	"aaa"
 * 예4	"123_.def"	"123_.def"
 * 예5	"abcdefghijklmn.p"	"abcdefghijklmn"
 */

public class Main_5 {
    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";

        System.out.println(solution(new_id));
    }

    public static String solution(String new_id) {
        String answer = "";

//        1단계
        answer = new_id.toLowerCase();
//        2단계
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<new_id.length();i++){
            char c = answer.charAt(i);
            if('a' <= c && c <= 'z')
                sb.append(c);
            if(0 <= c-'0' && c-'0' <= 9)
                sb.append(c);
            if(c == '-' || c == '_' || c == '.')
                sb.append(c);
        }
        answer = sb.toString();
//        3단계
        Stack<Character> stack = new Stack<>();
        sb = new StringBuilder();
        for(int i=0;i<answer.length();i++){
            char c = answer.charAt(i);
            if(c=='.'){
                if(!stack.isEmpty()){
                    if(stack.peek() == '.')
                        continue;
                }
                stack.push(c);
            }else
                stack.push(c);
        }

        for (Character c : stack) {
            sb.append(c);
        }
//        4단계
        if(sb.length() > 0) {
            if (sb.charAt(0) == '.')
                sb.deleteCharAt(0);
        }
        if(sb.length() > 0) {
            if (sb.charAt(sb.length() - 1) == '.')
                sb.deleteCharAt(sb.length() - 1);
        }
//        5단계
        if(sb.length() == 0)
            sb.append('a');
//        6단계
        if(sb.length() > 15){
            sb.delete(15,sb.length());
            if(sb.charAt(14) == '.')
                sb.deleteCharAt(14);
        }
//        7단계
        if(sb.length() <= 2){
            while (!(sb.length() >= 3)){
                sb.append(sb.charAt(sb.length()-1));
            }
        }
        answer = sb.toString();


        return answer;
    }
}
