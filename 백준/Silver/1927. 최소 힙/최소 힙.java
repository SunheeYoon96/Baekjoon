import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(input.readLine());
            if(value==0){
                if(pq.isEmpty()){
                    output.append(0).append("\n");
                }else {
                    output.append(pq.poll()).append("\n");
                }
            }else {
                pq.add(value);
            }
        }

        System.out.println(output);

    }
}