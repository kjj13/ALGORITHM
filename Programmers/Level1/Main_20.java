package Level1;

import java.util.Stack;

/**
 * - 다트게임
 *
 * if(c == '1' && dartResult.charAt(i+1) == '0'){
 *   stack.push(10);
 *   i++;    <= 이 부분 때문에 틀렸었음.
 * }
 *
 * 예제	dartResult	answer	설명
 * 1	1S2D*3T	37	11 * 2 + 22 * 2 + 33
 * 2	1D2S#10S	9	12 + 21 * (-1) + 101
 * 3	1D2S0T	3	12 + 21 + 03
 * 4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
 * 5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
 * 6	1T2D3D#	-4	13 + 22 + 32 * (-1)
 * 7	1D2S3T*	59	12 + 21 * 2 + 33 * 2
 */

public class Main_20 {
    public static void main(String[] args) {
        String r = "10S10S10S";
        System.out.println(solution(r));
    }
    public static int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            int num = -100;
            if(c == 'S' || c == 'D' || c == 'T' || c == '*' || c == '#'){
                int n = -100;
                int b = -100;
                switch (c){
                    case 'S':
                        break;
                    case 'D':
                        n = stack.pop();
                        stack.push(n*n);
                        break;
                    case 'T':
                        n = stack.pop();
                        stack.push(n*n*n);
                        break;
                    case '*':
                        n = stack.pop();
                        if(!stack.isEmpty()){
                            b = stack.pop();
                            stack.push(b * 2);
                        }
                        stack.push(n * 2);
                        break;
                    case '#':
                        n = stack.pop();
                        stack.push(n * -1);
                        break;
                }
            }else{
                if(c == '1' && dartResult.charAt(i+1) == '0'){
                    stack.push(10);
                    i++;    // 이 부분 때문에 틀렸음.
                }
                else
                    stack.push(c - '0');
            }
        }

        for (Integer i : stack) {
            answer += i;
        }

        return answer;
    }
}
