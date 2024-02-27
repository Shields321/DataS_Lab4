package DataS_Lab4;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Lab4 {

    public static void main(String[] args) {
        /*
         * Scanner input = new Scanner(System.in);
         * System.out.println("Enter a String");
         * String userInput = input.nextLine();
         */

        int thing = question4("7 5 + 8 2 - * =");
        System.out.println(thing);
    }

    public static void question1(String value) {
        MyStack<String> stack = new MyStack<String>();
        String[] temp = value.split(" ");

        for (int i = 0; i < temp.length; i++) {
            stack.push(temp[i]);
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void question2() {
        MyStack<Character> stack = new MyStack<Character>();
        MyStack<Character> stack2 = new MyStack<Character>();
        char[] array = new char[10];
        FileCreate file = new FileCreate();
        int count = 0;

        file.writeToFile("C R Y * S * M T A A * T E  *");
        stack = file.readFile();

        while (!(stack.isEmpty())) {
            if (stack.pop() == '*') {
                stack.pop();

                stack2.push(stack.pop());
                count++;

            }

        }
        for (int i = 0; i < count; i++) {
            array[i] = stack2.pop();
        }

        String temp = " ";
        for (int i = 0; i < count; i++) {
            temp += array[i] + " ";
        }
        question1(temp);
    }

    public static void question3() {
        FileCreate file = new FileCreate();
        file.writeToFile("[()}");

        MyStack<Character> stack = new MyStack<Character>();
        stack = file.readFile();

        int leftCount = 0, rightCount = 0;
        while (!(stack.isEmpty())) {
            char temp = stack.pop();
            if (temp == '(') {
                leftCount++;
            } else if (temp == ')') {
                rightCount++;
            } else if (temp == '[') {
                leftCount++;
            } else if (temp == ']') {
                rightCount++;
            } else if (temp == '{') {
                leftCount++;
            } else if (temp == '}') {
                rightCount++;
            }
        }
        if (leftCount > rightCount) {
            System.out.println("Right parenthesis missing");
            System.out.println("Extra left parenthesis");
        } else if (rightCount > leftCount) {
            System.out.println("Left parenthesis missing");
            System.out.println("Extra Right parenthesis");
        } else
            System.out.println("Left and right parentheses are balance");
    }
    public static boolean checkIfZero(int value){
        if(value == 0){
            return false;
        }
        else
            return true;
    }

    public static int question4(String value) {
        MyStack<String> stack = new MyStack<String>();
        stack.push(value);
        String[] temp = stack.pop().split(" ");
        int answerAdd=0,answerminus=0,answerMulti=0,answerdiv=0;
        int finalanswer=0;
        
        int value1=0,value2=0,count=0;;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i].equals("+")){
                answerAdd = value1 + value2;
                
            }
            else if(temp[i].equals("-")){
                answerminus = value1 - value2;
                
            }
            else if(temp[i].equals("*")){
                answerMulti = value1 * value2;
                
            }
            else if(temp[i].equals("/")){
                answerdiv = value1 / value2;
                
            }
            else if(temp[i].equals("=")){

                if(temp[i].equals("+")){
                    finalanswer = answerAdd+answerMulti+answerdiv+answerminus;
                    
                }
                else if(temp[i].equals("-")){
                    
                    
                }
                else if(temp[i].equals("*")){
                   if(checkIfZero(answerAdd)){
                        
                   }
                    
                }
                else if(temp[i].equals("/")){
                    
                    
                }
            }
            else{
                if(count==0){
                    value1 = Integer.valueOf(temp[i]);
                    count++;
                }else{
                    value2 = Integer.valueOf(temp[i]);
                    count = 0;
                }

                

            }
        }
        return 0;
        
    }
}