import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static String origin, bomb;


    public static void main(String[] args) throws IOException {

        origin = input.readLine();
        bomb = input.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < origin.length(); i++) {
            stack.push(origin.charAt(i));

            if(stack.size() >= bomb.length()){
                boolean isBomb = true;
                StringBuffer tempStr = new StringBuffer();

                for (int j = 0; j <bomb.length(); j++) {
                    if(bomb.charAt(j)!=stack.get(stack.size()-bomb.length()+j)){
                        isBomb=false;
                        break;
                    }
                }

                if(isBomb){
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }

            }

        }

        StringBuilder answer = new StringBuilder();
        for(Character c : stack) {
            answer.append(c);
        }
        System.out.println(answer.length()==0? "FRULA" : answer.toString());



    }
}