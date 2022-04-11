import java.util.*;

class Solution {
    static Queue<Node> Q;

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Q = new LinkedList<>();
        int size = priorities.length;

        for(int i=0;i<size;i++){
            Q.add(new Node(i,priorities[i]));
        }

        while(true){
            Node top = Q.peek();
            //answer++;
            boolean check = false;

            for(int i=0;i<size;i++){
                if(priorities[i] > top.priority){
                    Q.add(Q.poll());
                    check = true;
                    break;
                }
            }
            if(!check){
                boolean ch = false;
                while(!Q.isEmpty() && !ch){
                    Node curTop = Q.poll();
                    answer++;
                    if(curTop.idx == location){
                        // System.out.println(top.priority);
                        return answer;
                    }
                    for(int i=0;i<size;i++){
                        if(curTop.idx == i){
                            priorities[i] = 0;
                        }
                    }
                    for(int i=0;i<size;i++){
                        Node c = Q.peek();
                        if(priorities[i] > c.priority){
                            Q.add(Q.poll());
                            ch = true;
                            break;
                        }
                    }
                }
            }
        }
        // return answer;
    }

    private static class Node{
        int idx;
        int priority;

        public Node(int idx,int p){
            this.idx = idx;
            this.priority = p;
        }
    }
}
