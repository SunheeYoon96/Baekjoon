import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String origin = input.readLine();

        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < origin.length(); i++) {
            char now = origin.charAt(i);

            if(now=='('){
                stack.push(now);
            } else if (now==')') {
                stack.pop();
                if(origin.charAt(i-1)=='('){
                    cnt += stack.size();
                }else{
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);


    }
}