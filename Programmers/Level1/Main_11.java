package Level1;

import java.util.Stack;

/**
 * - 크레인 인형뽑기 게임
 *
 * board	moves	result
 * [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
 */

public class Main_11 {
    public static void main(String[] args) {
        int b[][]={
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int m[] = {1,5,3,5,1,2,1,4};

        System.out.println(solution(b,m));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int idx = move -1;
            for(int i=0;i<board.length;i++){
                if(board[i][idx] > 0){
                    if(stack.isEmpty())
                        stack.push(board[i][idx]);
                    else{
                        if(stack.peek() == board[i][idx]){
                            stack.pop();
                            answer += 2;
                        }else
                            stack.push(board[i][idx]);
                    }
                    board[i][idx] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
