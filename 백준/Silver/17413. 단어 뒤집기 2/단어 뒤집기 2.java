import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static String str;

    public static void main(String[] args) throws IOException {
        str = input.readLine();

        int idx = 0;
        boolean flag = false;
        Stack<Character> stack = new Stack<>();

        while (idx < str.length()){
            char ch = str.charAt(idx);
            if(ch=='<'){
                if(stack.isEmpty()){
                    output.append(ch);
                    flag=true;
                } else{
                    while (!stack.isEmpty()) {
                        output.append(stack.pop());
                    }
                    output.append(ch);
                    flag=true;
                }
            }else if(ch=='>'){
                output.append(ch);
                flag=false;
            } else if (ch==' ' && !flag) {
                while (!stack.isEmpty()) {
                    output.append(stack.pop());
                }
                output.append(" ");
            } else {
                if(flag){
                    output.append(ch);
                }else{
                    stack.push(ch);
                }
            }
            idx++;
        }

        if(!stack.isEmpty()){
            while (!stack.isEmpty()) {
                output.append(stack.pop());
            }
        }

        System.out.println(output);
    }
}