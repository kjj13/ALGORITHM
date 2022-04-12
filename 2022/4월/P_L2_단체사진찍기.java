package year2022.month04;

public class P_L2_단체사진찍기 {
	
	static public char[] arr;
	static public char[] tmp;
	static public boolean[] check;
	static public int answer;
    
    public static void main(String[] args) {
            int n = 2;
            String[] data1 = {"N~F=0", "R~T>2"};
            String[] data2 = {"M~C<2", "C~M>1"};

            System.out.println(solution(n, data1));
    }
    
    static public int solution(int n, String[] data) {
        answer = 0;
        tmp = new char[8];
        check = new boolean[8];
        arr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'}; 
        perm(0,data);   
        return answer;
    }
    
    static public void perm(int target, String[] data){
        if(target==8){
            String str = "";
            for(int i=0;i<8;i++){
                str += tmp[i];
            }
            if(strCheck(str,data)){
                answer++;
            }
            return;
        }
        
        for(int i=0;i<8;i++){
            if(check[i]) continue;
            check[i] = true;
            tmp[target] = arr[i];
            perm(target+1,data);
            check[target] = false;
        }
    }
    
    static public boolean strCheck(String str, String[] data){
        for(String s : data){
            int a = str.indexOf(s.charAt(0));
            int b = str.indexOf(s.charAt(2));
            char ch = s.charAt(3);
            int c = s.charAt(4) - '0' +1;
            int diff = Math.abs(a-b);
            
            if(ch == '='){
                if(diff != c) return false;
            }
            else if(ch == '>'){
                if(diff <= c) return false;
            }
            else if(ch == '<'){
                if(diff >= c) return false;
            }
        }
        return true;
    }
	
}
