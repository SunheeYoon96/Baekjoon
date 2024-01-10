import com.sun.org.apache.xpath.internal.operations.Neg;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int answer;

    public static void main(String[] args) throws IOException{
        String origin = input.readLine();

        Stack<Character> stack = new Stack<>();
        answer = 0;
        int val = 1;

        for (int i = 0; i < origin.length(); i++) {
            char now = origin.charAt(i);

            if(now=='(') {
                stack.push(now);
                val *= 2;
            } else if (now=='[') {
                stack.push(now);
                val *= 3;
            } else if (now==')') {
                if(stack.isEmpty() || stack.peek()!='('){
                    answer = 0;
                    break;
                }
                if(origin.charAt(i-1)=='('){
                    answer += val;
                }
                stack.pop();
                val /= 2;
            } else if (now==']') {
                if(stack.isEmpty() || stack.peek()!='['){
                    answer = 0;
                    break;
                }
                if(origin.charAt(i-1)=='['){
                    answer += val;
                }
                stack.pop();
                val /= 3;
            }
        }

        if(!stack.isEmpty()) {
            answer = 0;
        }

        System.out.println(answer);

    }
}