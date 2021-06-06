package String_1;

public class String2 {
    public static void main(String[] args) {
//        String s = "in(f(lea)r)n)";
        String s = "(a(b(c)d)";
        System.out.println(solve(s));
    }

    public static String solve(String str){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        char[] CharStr = str.toCharArray();
        int openBrace = 0;

        for(int i=0;i<CharStr.length;i++){
            if(openBrace ==0 && CharStr[i] == ')') {
                continue;
            }else if(CharStr[i] == '('){
                openBrace++;
            }else if(CharStr[i] == ')'){
                openBrace--;
            }
            sb.append(CharStr[i]);
        }

        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i) == '(' && openBrace-- >0) continue;
            else sb1.append(sb.charAt(i));
        }

        return sb1.reverse().toString();
    }
}
