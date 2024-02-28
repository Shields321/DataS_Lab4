package DataS_Lab4.Queue;

public class Person {
    String name,Transaction;
    int age,accNumber;
    public Person(String name,String Transaction,int age,int accNumber){
        this.name = name;
        this.Transaction = Transaction;
        this.age = age;
        this.accNumber = accNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTransaction() {
        return Transaction;
    }
    public void setTransaction(String account) {
        this.Transaction = account;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAccNumber() {
        return accNumber;
    }
    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", Transaction=" + Transaction + ", age=" + age + ", accNumber=" + accNumber+ "]";
    }
    
}
