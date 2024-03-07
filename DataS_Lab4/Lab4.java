package DataS_Lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import DataS_Lab4.Stacks.*;
import DataS_Lab4.Queue.*;

public class Lab4 {

    public static void main(String[] args) {
        System.out.print("Question 1 = ");
        question1("Live and Let Live");
        System.out.println("");
        System.out.print("question 2 = ");
        question2();
        System.out.println("question 3 = ");
        question3();
        int[] temp = new int[3];
        temp[0] = question4("3 4 + =");
        temp[1] = question4("7 5 + 8 2 - * =");
        temp[2] = question4("3 4 5 6 7 + - * 3 / + =");
        System.out.println("Questions 4 answers are \nA = " + temp[0] + "\nB = " + temp[1] + "\nC = " + temp[2]);
        System.out.println("Question 5");
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
        String dir = System.getProperty("user.dir");
        MyStack<Character> stack = new MyStack<Character>();
        try (FileReader input = new FileReader(dir + "\\DataS_Lab4\\Code.txt");) {

            int c;
            while ((c = input.read()) != -1) {
                stack.push((char) c);
            }
            while (!stack.isEmpty()) {
                char ch = stack.pop();
                if (ch == '*') {
                    stack.pop();
                    System.out.print(stack.pop());
                }
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void question3() {
        String dir = System.getProperty("user.dir");
        MyStack<Character> stack = new MyStack<Character>();
        try (FileReader input = new FileReader(dir + "\\DataS_Lab4\\Code2.txt");) {
            int c;
            while ((c = input.read()) != -1) {
                stack.push((char) c);
            }
            int leftCount = 0, rightCount = 0;
            int roundCountright = 0, roundCountleft = 0, curlcountRight = 0, curlcountLeft = 0, squareCountRight = 0,
                    squareCountLeft = 0;
            while (!(stack.isEmpty())) {
                char temp = stack.pop();
                if (temp == '(') {
                    leftCount++;
                    roundCountleft++;
                } else if (temp == ')') {
                    rightCount++;
                    roundCountright++;
                } else if (temp == '[') {
                    leftCount++;
                    squareCountLeft++;
                } else if (temp == ']') {
                    rightCount++;
                    squareCountRight++;
                } else if (temp == '{') {
                    leftCount++;
                    curlcountLeft++;
                } else if (temp == '}') {
                    rightCount++;
                    curlcountRight++;
                }
            }
            if (leftCount > rightCount) {
                System.out.println("Right parenthesis missing");
                System.out.println("Extra left parenthesis");
            } else if (rightCount > leftCount) {
                System.out.println("Left parenthesis missing");
                System.out.println("Extra Right parenthesis");
            } else if ((roundCountright < roundCountleft) || (curlcountRight < curlcountLeft)
                    || (squareCountRight < squareCountLeft)) {
                System.out.println("Right parenthesis missing");
                System.out.println("Extra left parenthesis");
            } else if ((roundCountright > roundCountleft) || (curlcountRight > curlcountLeft)
                    || (squareCountRight > squareCountLeft)) {
                System.out.println("Left parenthesis missing");
                System.out.println("Extra Right parenthesis");
            } else {
                System.out.println("Left and right parentheses are balance");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int question4(String value) {
        MyStack<String> stack = new MyStack<String>();
        int num1 = 0;
        int num2 = 0;
        int result = 0;

        String[] temp = value.split(" ");

        for (int i = 0; i < temp.length; i++) {

            if (temp[i].equals("+")) {
                num2 = Integer.valueOf(stack.pop());
                num1 = Integer.valueOf(stack.pop());
                result = num1 + num2;
                stack.push(String.valueOf(result));

            } else if (temp[i].equals("-")) {
                num2 = Integer.valueOf(stack.pop());
                num1 = Integer.valueOf(stack.pop());
                result = num1 - num2;
                stack.push(String.valueOf(result));

            } else if (temp[i].equals("*")) {
                num2 = Integer.valueOf(stack.pop());
                num1 = Integer.valueOf(stack.pop());
                result = num1 * num2;
                stack.push(String.valueOf(result));

            } else if (temp[i].equals("/")) {
                num2 = Integer.valueOf(stack.pop());
                num1 = Integer.valueOf(stack.pop());
                result = num1 / num2;
                stack.push(String.valueOf(result));

            } else if (temp[i].equals("=")) {

                return Integer.valueOf(stack.pop());

            } else {
                stack.push(String.valueOf(temp[i]));
            }
        }
        return 0;
    }

    public static void question5() {
        String dir = System.getProperty("user.dir");
        MyStack<String> stack = new MyStack<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(dir + "\\DataS_Lab4\\Today.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    stack.push(word);
                }
            }

            String[] temp = new String[2];
            String[] temp2 = new String[2];
            String[] temp3 = new String[2];
            String[] temp4 = new String[2];

            int i = 0;
            
            Person[] people = new Person[10000];
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
                if (people[j] != null) {
                    bank.addQ(people[j]);
                }
            }
            bank.printElderQ();
            bank.printAccountQ();
            bank.printotherQ();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
