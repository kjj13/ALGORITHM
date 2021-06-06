package DataStructure;

class Node{
    private String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.data = null;
        this.next = null;
    }

    public String getData() {
        return data;
    }
}

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }
// 맨 마지막에 삽입
    public void insert(String data){
        Node newNode = new Node(data);

//        연결리스트가 비어있다면
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
//            연결리스트가 비어있지 않다면
            tail.next = newNode;
            tail = newNode;
        }
    }

//    중간에 삽입
    public void insert(String str,String data){
        Node newNode = new Node(data);
        Node cur = head;

        while (cur != null){
            if(cur.getData().equals(str)){
                newNode.next = cur.next;
                cur.next = newNode;
                break;
            }else{
                cur = cur.next;
            }
        }
    }

//    맨 마지막 노드 삭제
    public void delete(){
        if(head != null) {
            Node preNode = head;
            Node temp = head.next;

//            노드가 하나밖에 없을 경우
            if(temp == null){
                preNode = null;
                tail = null;
            }else{
//                노드가 여러개일 경우
//                마지막 노드까지 반복
                while (temp.next != null){
                    preNode = temp;
                    temp = temp.next;
                }
//                마지막 노드 삭제하고 preNode를 마지막 노드로 설정하고
//                tail 노드도 preNode로 설정
                preNode.next = null;
                tail = preNode;
            }
        }else{
            return;
        }
    }

//    중간 노드 삭제
    public void delete(String str){
        if(head != null) {
            Node preNode = head;
            Node temp = head.next;

            if(preNode.getData().equals(str)){
                head = temp;
                preNode.next = null;
            }else{
                while (temp != null){
                    if(temp.getData().equals(str)){
                        preNode.next = temp.next;
                        temp.next = null;
                        break;
                    }else {
                        preNode = temp;
                        temp = temp.next;
                    }
                }
            }
        }else{
            return;
        }
    }

    public void printList(){
        Node temp = head;

        while (temp != null){
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insert("sun");
        linkedList.insert("mon");
        linkedList.printList();

        System.out.println("------------------");
        linkedList.insert("sun","jjoong");
        linkedList.printList();

        System.out.println("------------------");
        linkedList.delete("mon");
        linkedList.printList();

    }
}
