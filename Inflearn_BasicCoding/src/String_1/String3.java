package String_1;

public class String3 {
    public static void main(String[] args) {
        String str[] = {"test", "teacher", "abst"};
        System.out.println(new String3().solve(str));
    }
    public String solve(String[] strs){
        String str = strs[0];

        for(int i=1;i<strs.length;i++){
            while (strs[i].indexOf(str) != 0){
                str = str.substring(0,str.length()-1);
            }
        }
        return str;
    }
}
