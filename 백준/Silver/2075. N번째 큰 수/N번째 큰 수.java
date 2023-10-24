import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int r = 0; r < N; r++) {
            tokens = new StringTokenizer(input.readLine());
            for (int c = 0; c < N; c++) {
                pq.offer(Long.parseLong(tokens.nextToken()));
            }
        }

        Long answer = 0L;

        for(int i=0 ; i<N; i++) {
            answer = pq.poll();
        }

        System.out.println(answer);


    }
}
