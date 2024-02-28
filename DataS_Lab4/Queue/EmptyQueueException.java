package DataS_Lab4.Queue;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("Queue is empty");
    }
}
