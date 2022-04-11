import java.util.*;

class Solution {
    static int colLen,rowLen;
    static int[] arr;   // col 배열
    static boolean[] check;
    static List<String> candidate;
    
    public static int solution(String[][] relation) {
        int answer = 0;
        colLen = relation[0].length;
        rowLen = relation.length;
        arr = new int[colLen];
        for(int i=0;i<colLen;i++){
            arr[i] = i;
        }
        check = new boolean[colLen];
        candidate = new ArrayList<>();
        
        for(int i=1;i<=colLen;i++){
            comb(0,0,i,relation);
        }
        
        return candidate.size();
    }
    
    private static void comb(int target,int cnt,int R,String[][] relation){
        if(cnt == R){
            String str = "";
            String tmp = "";
            Set<String> set = new HashSet<>();
            for(int i=0;i<colLen;i++){
                if(check[i]){
                    str += arr[i];
                }
            }
            // 유일성 판단 로직
            for(int i=0;i<rowLen;i++){
                String s = "";
                for(int j=0;j<str.length();j++){
                    int n = str.charAt(j) - '0';
                    s += relation[i][n];
                }
                set.add(s);
            }
            if(set.size() == rowLen){   // 유일성 조건 충족하면
                /*
                    최소성 판단 로직
                    012 인 경우에는 02가 있는지 판단하기 위해
                */
                for(String cand : candidate){   
                    int count = 0;
                    for(int i=0;i<cand.length();i++){
                        char c = cand.charAt(i);
                        if(str.contains(c+"")){
                            count++;
                        }
                    }
                    if(count == cand.length()){
                        return;
                    }
                }
                candidate.add(str);
            }
            return;
        }
        if(target == colLen){
            return;
        }
        
        check[target] = true;
        comb(target+1,cnt+1,R,relation);
        check[target] = false;
        comb(target+1,cnt,R,relation);
    }
}
