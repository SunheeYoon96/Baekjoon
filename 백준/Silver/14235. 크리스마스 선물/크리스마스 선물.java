import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N;
    static PriorityQueue<Integer> sleigh;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        sleigh = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            String line = input.readLine();

            if(line.equals("0")){
                if(sleigh.isEmpty()) {
                    output.append(-1).append("\n");
                } else {
                    output.append(sleigh.poll()).append("\n");
                }
            }else {
                tokens = new StringTokenizer(line);
                tokens.nextToken();
                while (tokens.hasMoreElements()){
                    sleigh.add(Integer.parseInt(tokens.nextToken()));
                }
            }
        }

        System.out.println(output);


    }
}