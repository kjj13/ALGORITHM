import java.util.*;

class Solution {
    private static Map<String,Integer> map;
    
    public static boolean solution(String[] phone_book) {
        int size = phone_book.length;
        map = new HashMap<>();
        
        for(String str : phone_book){
            map.put(str,1);
        }
        
        for(int i=0;i<size;i++){
            for(int j=0;j<phone_book[i].length();j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        
        return true;
    }
}
