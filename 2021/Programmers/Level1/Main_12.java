package Level1;

/**
 * - 음양 더하기
 *
 * absolutes	signs	result
 * [4,7,12]	[true,false,true]	9
 * [1,2,3]	[false,false,true]	0
 */

public class Main_12 {
    public static void main(String[] args) {
        int a[] = {4,7,12};
        boolean s[] = {true,false,true};

        System.out.println(solution(a,s));
    }
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0;i<absolutes.length;i++){
            if(signs[i]) {    //true
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
