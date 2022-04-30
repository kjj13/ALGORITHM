import java.util.*;

class Solution {
    List<Character> list;
    int answer;
    String open = "([{";
    String close = ")]}";
    
    public int solution(String s) {
        answer = 0;
        list = new LinkedList<>();
        
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        
        // if(isCorrect(list)) answer++;
        
        for(int i=0;i<s.length();i++){
            list.add(list.remove(0));
            // print(list);
            if(isCorrect(list)) answer++;
        }
        
        
        return answer;
    }
    
    public void print(List<Character> list){
        for(char ch : list){
            System.out.print(ch + " ");
        }
        System.out.println();
    }
    
    public boolean isCorrect(List<Character> list){
        Stack<Character> stack = new Stack<>();
        for(char ch : list){
            // System.out.println(ch + " ");
            if(stack.isEmpty()){
                if(open.contains(ch+"")){
                    stack.push(ch);
                }else{
                    return false;
                }
            }else{
                if(open.contains(ch+"")){
                    stack.push(ch);
                }else{
                    if(ch == ')' && stack.peek() == '(')    stack.pop();
                    else if(ch == ']' && stack.peek() == '[') stack.pop();
                    else if(ch == '}' && stack.peek() == '{') stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
}
