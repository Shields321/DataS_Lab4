package DataS_Lab4.LinkedList;

public class Nodes {
   
    Object element; //Defining the element as an element. 
    Nodes next; //Defining next as a node. 
    
    public Nodes(Object o){ //Constructor for the node.
        element = o;
        next=null;
    }

   //Getter for the element. 
    public Object getElement() {
        return element;
    }

   //Setter for element. 
    public void setElement(Object element) {
        this.element = element;
    }

   //Getter for the next.
    public Nodes getNext() {
        return next;
    }
   //Setter for the next.
    public void setNext(Nodes next) {
        this.next = next;
    }
}
