package LinkedList;

public class LinkedList {
    private Node head;
    private int count;

    public LinkedList (){
        this.count = 0;
        this.head = null;
    }

    public void push(Object Data){
        Node node = new Node(Data);

        if(this.head == null){
            this.head = node;
        }
        else{
            Node current = this.head;
            while(current.getNext() != null){
                current = current.getNext();
            }

            current.setNext(node);
        }
        this.count++;
    }


    public Object getElementAt(int index){
        if (index >= 0 && index<this.count){
            Node node = this.head;
            for(int i = 0;i<index && node != null; i++ ){
                node = node.getNext();
            }
            return node.getData();
        }

        return null;
    }

    public boolean isEmpty(){
        if (this.head != null){
            return false;
        }
        else{
            return true;
        }
    }

    public int size(){
        return this.count;
    }

}