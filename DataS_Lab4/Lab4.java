package DataS_Lab4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import DataS_Lab4.Stacks.FileCreate;
import DataS_Lab4.Stacks.*;
import DataS_Lab4.Queue.*;

public class Lab4 {

    public static void main(String[] args) {

        /*
         * Scanner input = new Scanner(System.in);
         * System.out.println("Enter a String");
         * String userInput = input.nextLine();
         * question1(userInput);
         */

        // question3();

        // (7 * 11) + 2.33 = 79.33
        // double thing = question4("3 4 5 6 7 + - * 3 / + =");//((3+4) * (5+6)) + 7/3
        question5();
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

        file.writeToFile("C R Y * S * M T A A * T E *");
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

    public static boolean checkIfZero(int value) {
        if (value == 0) {
            return false;
        } else
            return true;
    }

    public static double question4(String value) {
        MyStack<String> stack = new MyStack<String>();
        MyStack<Integer> answerStack = new MyStack<Integer>();
        stack.push(value);
        String[] temp = stack.pop().split(" ");
        int answerAdd = 0, answerminus = 0, answerMulti = 0;
        double answerdiv = 0;
        double finalanswer = 0;

        int value1 = 0, value2 = 0, count = 0;

        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("+")) {
                answerAdd += value1 + value2;
                value1 = 0;
                value2 = 0;
            } else if (temp[i].equals("-")) {
                answerminus += value1 - value2;
                value1 = 0;
                value2 = 0;
            } else if (temp[i].equals("*")) {
                answerMulti += value1 * value2;
                value1 = 0;
                value2 = 0;
            } else if (temp[i].equals("/")) {
                value1 = 1;
                value2 = 1;
                answerdiv += value1 / value2;

            } else if (temp[i].equals("=")) {

                if (temp[i - 1].equals("+")) {
                    finalanswer = answerAdd + answerMulti + answerdiv + answerminus;
                    return finalanswer;
                }
                if (temp[i - 1].equals("-")) {
                    finalanswer = answerAdd - answerMulti - answerdiv - answerminus;
                    return finalanswer;
                }
                if (temp[i - 1].equals("*")) {
                    if (answerMulti == 0) {
                        answerMulti = 1;
                    }
                    if (answerdiv == 0) {
                        answerdiv = 1;
                    }
                    finalanswer = answerAdd * answerMulti * answerdiv * answerminus;
                    return finalanswer;
                }
                if (temp[i - 1].equals("/")) {
                    if (answerMulti == 0) {
                        answerMulti = 1;
                    }
                    if (answerdiv == 0) {
                        answerdiv = 1;
                    }
                    finalanswer = (answerAdd / answerminus) / (answerdiv / answerMulti);
                    return finalanswer;
                }
            } else {
                if (count == 0) {
                    value1 = Integer.valueOf(temp[i]);
                    count = 1;
                } else {
                    value2 = Integer.valueOf(temp[i]);
                    count = 0;
                }
            }
        }
        return 0;
    }

    public static void question5() {
        FileCreate fileCreate = new FileCreate();

        MyStack<String> stack = new MyStack<String>();

        fileCreate.createFileString();
        fileCreate.writeToFileString(
                "Name:Dylan Age:60 AccountNumber:103 Transaction:Account\nName:Dylan2 Age:40 AccountNumber:103 Transaction:other\nName:Dylan3 Age:20 AccountNumber:103 Transaction:Account");
        stack = fileCreate.readFileString();

        String[] temp = new String[2];
        String[] temp2 = new String[2];
        String[] temp3 = new String[2];
        String[] temp4 = new String[2];

        int i = 0;

        Person[] people = new Person[23409867];
        while (!(stack.isEmpty())) {

            String currentChar = stack.pop();
            temp = currentChar.split(":");
            currentChar = stack.pop();
            temp2 = currentChar.split(":");
            currentChar = stack.pop();
            temp3 = currentChar.split(":");
            currentChar = stack.pop();
            temp4 = currentChar.split(":");
 
            people[i] = new Person(temp4[1], temp[1], Integer.parseInt(temp3[1]), Integer.parseInt(temp2[1]));
            i++;
        }

        Bank bank = new Bank();
        for (int j = 0; j < people.length; j++) {
            if(people[j] != null){
                bank.addQ(people[j]);
            }
        }
        bank.printElderQ();
        bank.printAccountQ();
        bank.printotherQ();

    }
}