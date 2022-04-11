package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택의 활용
 * 함수 안했다면 더 깔끔했을 것 같다.
 */

public class Main_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String str = br.readLine();
            if(str.length() %2 != 0){
                System.out.println("NO");
//                break;
            }
            else
                isVPS(str);
        }
    }
    public static void isVPS(String str){
        Stack<Character> stack = new Stack<>();
        boolean check = true;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(')
                stack.push('(');
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    check = false;
                    break;
                }
            }
        }
        if(!check)
            System.out.println("NO");
        else {
            if (!stack.isEmpty())
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
