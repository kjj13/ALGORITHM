package String_1;

public class String4 {

    public static void main(String[] args) {
        String4 a = new String4();
        String s = "bbbb";

        System.out.println(a.solve(s));
    }

    private int start, end;
    private int len = -1;

    public String solve(String s) {
        int len1 = s.length();
        if (len1 < 2)
            return s;

        for (int i = 0; i < len1 - 1; i++) {
            findSubstring(s, i, i, "odd"); //
            findSubstring(s, i, i + 1, "even"); //
        }
        return s.substring(start, end + 1);
    }

    private void findSubstring(String s, int left, int right, String str) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (len < right - left - 1) {
            start = left + 1;
            end = right - 1;
            len = right - left - 1;
        }

    }
}
//
//    //2
//    public String longestPalindrome_dp(String s) {
//        return res;
//    }
//    public void print(boolean[][] dp) {
//
//    }
