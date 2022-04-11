package String_1;

public class String1 {
    public static void main(String[] args) {
        String a = "123";
        String b = "888";
        System.out.println(solve(a,b));
    }

    public static String solve(String num1,String num2){
        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;
        int sum = 0, carry = 0;
        int n1 , n2;

        StringBuilder sb = new StringBuilder();

        while (num1Len>=0 && num2Len >= 0){
            n1 = num1.charAt(num1Len--) - '0';
            n2 = num2.charAt(num2Len--) - '0';

            sum = n1 + n2 + carry;
            carry = sum /10;
            sb.append(sum % 10);
        }
        if(carry != 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
