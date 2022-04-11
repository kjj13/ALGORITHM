package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택의 활용
 * 반례 찾기가 너무 어려웠음,,
 */

public class Main_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(-1);
            }else if(c == '['){
                stack.push(-3);
            }else if(c == ')' || c == ']'){
                if(stack.isEmpty()){    // 스택이 비어 있는 경우.
                    System.out.println(0);
                    return;
                }
                while (!stack.isEmpty()){
                    int pop1 = stack.pop();
                    if(pop1 == -1){
                        if(c == ')') {  // '()'인 경우
                            stack.push(2);
                            break;
                        }else{  // '(]'인 경우
                            System.out.println(0);
                            return;
                        }
                    }else if(pop1 == -3){
                        if(c == ']') {  // '[]' 인 경우
                            stack.push(3);
                            break;
                        }
                        else{   // '(]' 인 경우
                            System.out.println(0);
                            return;
                        }
                    }else{
                        if(!stack.isEmpty()){
                            int pop2 = stack.pop();
                            if(pop2 == -1){
                                if(c == ')') {  // '( 숫자 )' 인 경우
                                    stack.push(2 * pop1);
                                    break;
                                }
                                else {  // '[ 숫자 )' 인 경우
                                    System.out.println(0);
                                    return;
                                }
                            }else if(pop2 == -3){
                                if(c == ']') {  // '[ 숫자 ]' 인 경우
                                    stack.push(3 * pop1);
                                    break;
                                }
                                else {  // '( 숫자 ]' 인 경우
                                    System.out.println(0);
                                    return;
                                }
                            }else{  // '숫자 숫자' 인 경우
                                stack.push(pop1 + pop2);
                            }
                        }else{  // 스택이 빈 경우
                            System.out.println(0);
                            return;
                        }
                    }
                }
            }else{  // 괄호가 아닌 값이 입력에 있는 경우.
                System.out.println(0);
                return;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()){
            int pop = stack.pop();
            if(pop == -1 || pop == -3){ // 스택에 '(' or '['이 남아있는 경우
                System.out.println(0);
                return;
            }else   // 남은 숫자들 더하기.
                ans += pop;
        }
        System.out.println(ans);
    }
}
