package DataS_Lab4;

public class MyStack<T> {
    private Node top = null;

    class Node{
        T item;
        Node next;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        T item = top.item;
        top = top.next;
        return item;
    }
    public void push(T s){
        Node oldTop = top;
        top = new Node();
        top.item = s;
        top.next = oldTop;
    }
    public boolean isEmpty(){
        return top == null;
    }
        
    
}

