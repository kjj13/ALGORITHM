import java.util.*;

class Solution {
    List<Node> arr;
    
    public String[] solution(String[] files) {
        arr = new ArrayList<>();
        
        
        for(String file:files){
            int endTail = headDfs(file,0);
            int endNum = numDfs(file,endTail);
            int len = file.length();
            String head = file.substring(0,endTail);
            String numStr = file.substring(endTail,endNum);
            int number = Integer.parseInt(file.substring(endTail,endNum));
            String tail = file.substring(endNum,len);
            arr.add(new Node(head,number,tail,numStr));
        }
        
        arr.sort(Comparator.comparing(Node::getHead).thenComparing(Node::getNumber));
        String[] answer = new String[arr.size()];
        
        for(int i=0;i<arr.size();i++){
            Node cur = arr.get(i);
            answer[i] = cur.head + cur.numStr + cur.tail;
        }
        
        
        // System.out.println(Integer.parseInt("010"));
        
        return answer;
    }
    
    public int headDfs(String file,int idx){
        char ch = file.charAt(idx);
        if(ch >= '0' && ch <= '9')
            return idx;
        return headDfs(file,idx+1);
    }
    
    public int numDfs(String file,int idx){
        if(idx == file.length())
            return idx;
        char ch = file.charAt(idx);
        if(ch >= '0' && ch <= '9')
            return numDfs(file,idx+1);
        return idx;
    }
    
    private class Node{
        String head;
        int number;
        String tail;
        String numStr;
        
        public String getHead(){
            return this.head.toLowerCase();
        }
        
        public int getNumber(){
            return this.number;
        }
        
        public Node(String head,int number,String tail,String numStr){
            this.head = head;
            this.number= number;
            this.tail = tail;
            this.numStr = numStr;
        }
    }
}
