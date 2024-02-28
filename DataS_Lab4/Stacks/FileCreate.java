package DataS_Lab4.Stacks;

import java.io.*;
public class FileCreate {
    public void createFile(){
        try{
            File MyObj = new File("C:\\Users\\reald\\Code\\DataS_Lab4\\Code.txt");
            if(MyObj.createNewFile()){
                System.out.println("File is Created: "+MyObj.getName());
            }
            else
                System.out.println("File already dxists");
        }    
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void writeToFile(String thing){
        try{
            FileWriter myWriter = new FileWriter("C:\\Users\\reald\\Code\\DataS_Lab4\\Code.txt");
            myWriter.write(thing);
            myWriter.close();
            System.out.println("wrote to file");

        }catch(IOException e){
            e.printStackTrace();;
        }
    }
    public MyStack<Character> readFile(){
        MyStack<Character> stack = new MyStack<Character>();
        try(FileReader input = new FileReader("C:\\Users\\reald\\Code\\DataS_Lab4\\Code.txt");){
            int c;
            while((c = input.read())!= -1){
                stack.push((char)c);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return stack;
    }
    public void createFileString(){
        try{
            File MyObj = new File("C:\\Users\\reald\\Code\\DataS_Lab4\\Today.txt");
            if(MyObj.createNewFile()){
                System.out.println("File is Created: "+MyObj.getName());
            }
            else
                System.out.println("File already exists");
        }    
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void writeToFileString(String thing){
        try{
            FileWriter myWriter = new FileWriter("C:\\Users\\reald\\Code\\DataS_Lab4\\Today.txt");
            myWriter.write(thing);
            myWriter.close();
            System.out.println("wrote to file");

        }catch(IOException e){
            e.printStackTrace();;
        }
    }
    public MyStack<String> readFileString() {
        MyStack<String> stack = new MyStack<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\reald\\Code\\DataS_Lab4\\Today.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    stack.push(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stack;
    }
}
