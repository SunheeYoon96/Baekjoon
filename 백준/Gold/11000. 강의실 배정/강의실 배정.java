import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, lectures[][];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        lectures = new int[N][2];

        for (int i=0; i<N; i++ ){
            tokens = new StringTokenizer(input.readLine());
            lectures[i][0] = Integer.parseInt(tokens.nextToken());
            lectures[i][1] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(lectures, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        //pq를 만든다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0][1]);

        //배열을 순회
        for (int i = 1; i < lectures.length; i++) {
            if(pq.peek()<= lectures[i][0]) {
                pq.poll();
            }
            pq.offer(lectures[i][1]);
        }

        System.out.println(pq.size());


    }
}
