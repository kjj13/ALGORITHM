package Level1;

/**
 * - 가운데 글자 가져오기
 *
 * subString으로 풀 수도 있음.
 *
 * s	return
 * "abcde"	"c"
 * "qwer"	"we"
 */

public class Main_19 {
    public static void main(String[] args) {
        String str = "a";
        System.out.println(solution(str));
    }
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int half = s.length() / 2;

        if(s.length() % 2 == 1){
            sb.append(s.charAt(half));
        }else{
            sb.append(s.charAt(half-1));
            sb.append(s.charAt(half));
        }
        return sb.toString();
    }
}
