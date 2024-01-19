import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int A, B;

    static class Number {
        long num;
        int cnt;
        public Number (long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        A = Integer.parseInt(tokens.nextToken());
        B = Integer.parseInt(tokens.nextToken());
        int answer = 0;

        if(B<A){
            answer = -1;
        }else{
            answer = bfs(A);
        }

        System.out.println(answer);
    }

    private static int bfs(int a) {
        Queue<Number> queue = new ArrayDeque<>();
        queue.add(new Number(a, 1));
        int value = -1;

        while (!queue.isEmpty()){
            Number now = queue.poll();

            if(now.num == B) return now.cnt;

            long tmp1 = now.num*2;
            long tmp2 = now.num*10 + 1;

            if(tmp1<=B) queue.add(new Number(tmp1, now.cnt+1));
            if(tmp2<=B) queue.add(new Number(tmp2, now.cnt+1));
        }

        return value;
    }
}