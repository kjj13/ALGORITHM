package Level1;

/**
 * - 키패드 누르기(카카오 인턴십)
 *
 * numbers	hand	result
 * [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
 * [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
 */

public class Main_2 {
    public static void main(String[] args) {
        int[] n = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(solution(n,hand));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] keypad = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,0,11}
        };

        Node Lnode = new Node(3,0);
        Node Rnode = new Node(3,2);

        int Lresult = 0;
        int Rresult = 0;

        for (int num : numbers) {
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(num == keypad[i][j]) {
                        if (keypad[i][j] == 1 || keypad[i][j] == 4 || keypad[i][j] == 7) {
                            sb.append("L");
                            Lnode = new Node(i, j);
                        } else if (keypad[i][j] == 3 | keypad[i][j] == 6 || keypad[i][j] == 9) {
                            sb.append("R");
                            Rnode = new Node(i, j);
                        } else {
                            int lx = Lnode.x < i ? -(Lnode.x - i) : Lnode.x - i;
                            int ly = Lnode.y < j ? -(Lnode.y - j) : Lnode.y - j;
                            int rx = Rnode.x < i ? -(Rnode.x - i) : Rnode.x - i;
                            int ry = Rnode.y < j ? -(Rnode.y - j) : Rnode.y - j;

                            Lresult = lx + ly;
                            Rresult = rx + ry;

                            if (Lresult < Rresult) {
                                sb.append("L");
                                Lnode = new Node(i, j);
                            } else if (Lresult > Rresult) {
                                sb.append("R");
                                Rnode = new Node(i, j);
                            } else {
                                if (hand.equals("right")) {
                                    sb.append("R");
                                    Rnode = new Node(i, j);
                                } else {
                                    sb.append("L");
                                    Lnode = new Node(i, j);
                                }
                            }
                        }
                    }
                }
            }
        }

        return sb.toString();
    }

    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
