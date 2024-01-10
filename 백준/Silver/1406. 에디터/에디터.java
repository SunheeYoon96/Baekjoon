import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static ArrayDeque<String> origin, temp;
    static int N;

    public static void main(String[] args) throws IOException{
        String str = input.readLine();
        N = Integer.parseInt(input.readLine());

        origin = new ArrayDeque<>();
        temp = new ArrayDeque<>();

        for(char c : str.toCharArray()){
            origin.addLast(c+"");
        }

        String cmd;

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            cmd = tokens.nextToken();
            String value;

            if(cmd.equals("L")){
                if(origin.isEmpty()) continue;
                temp.addLast(origin.pollLast());
            }else if(cmd.equals("D")){
                if(temp.isEmpty()) continue;
                origin.addLast(temp.pollLast());
            }else if(cmd.equals("P")){
                value = tokens.nextToken();
                origin.addLast(value);
            }else if(cmd.equals("B")){
                origin.pollLast();
            }

        }

        while (!origin.isEmpty()){
            output.append(origin.pollFirst());
        }

        while (!temp.isEmpty()){
            output.append(temp.pollLast());
        }


        System.out.println(output);

    }
}