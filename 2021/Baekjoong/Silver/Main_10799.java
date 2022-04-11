package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택의 활용 문제 (괄호쌍 응용)
 * '()' 일 경우 '))' 일 경우 구분해서 풀기.
 */

public class Main_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')'){
                stack.pop();
                if(str.charAt(i-1) == '(')
                    cnt += stack.size();
                else
                    cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}
