package LinkedList;

public class Node {
    private Object data;
    private Node next; //reference to next node


    public Node(Object data){
        this.data = data;
        this.next = null;
    }

    //getters and setters by Object Data
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    //getters and setter by Node next
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}