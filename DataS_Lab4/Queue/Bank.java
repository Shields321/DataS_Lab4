package DataS_Lab4.Queue;

public class Bank {
    MyQueue<Object> ElderQ = new MyQueue<>();
    MyQueue<Object> AccountQ = new MyQueue<>();
    MyQueue<Object> otherQueue = new MyQueue<>();

    public void addQ(Person people){
        if(people.getAge() > 50){
            ElderQ.enqueue(people);
        }
        else if(people.getTransaction().equalsIgnoreCase("account")){
            AccountQ.enqueue(people);
        }
        else{
            otherQueue.enqueue(people);
        }
    }
    public void printElderQ(){
        System.out.println(ElderQ.size());
    }
    public void printAccountQ(){
        System.out.println(AccountQ.size());
    }
    public void printotherQ(){
        System.out.println(otherQueue.size());
    }
}
