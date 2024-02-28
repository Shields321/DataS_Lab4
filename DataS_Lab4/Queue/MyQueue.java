package DataS_Lab4.Queue;

import DataS_Lab4.LinkedList.LinkedList;

public class MyQueue<T> {
    private LinkedList<T> elements;

    public MyQueue() {
        elements = new LinkedList<>();
    }

    // Add an element to the end of the queue
    public Object enqueue(T element) {
        return elements.addFirst(element);
    }

    // Remove and return the element at the front of the queue
    public Object dequeue() throws EmptyQueueException {
        if (!(isEmpty())) {
            throw new EmptyQueueException();
        }

        return elements.delFirst();
    }

    // Return the element at the front of the queue without removing it
    public Object peek() throws EmptyQueueException {
        if (!(isEmpty())) {
            throw new EmptyQueueException();
            
        }
        return elements.getFirst();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Return the size of the queue
    public int size() {
        return elements.size();
    }

}
