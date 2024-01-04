import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M, count[];
    static Move[] board;

    static class Move {
        int type, start, end;

        public Move(int type, int start, int end){
            this.type = type; //0->사다리, 1->뱀
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        board = new Move[101];

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken());
            Move ladder = new Move(0,start, end);
            board[start] = ladder;
        }

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken());
            Move ladder = new Move(1, start,end);
            board[start] = ladder;
        }

        count = new int[101];
        bfs();

        System.out.println(count[100]);


    }

    private static void bfs() {
        Queue<Integer> que = new ArrayDeque<>();
        boolean visited[] = new boolean[101];
        que.add(1);
        visited[1] = true;

        while (!que.isEmpty()){
            int now = que.poll();

            if(now==100) return;

            for (int i = 0; i < 7; i++) {
                int target = now + i;

                if(target > 100) continue;
                if(visited[target]) continue;

                if(board[target] != null){
                    if(!visited[board[target].end]){
                        que.add(board[target].end);
                        visited[target] = true; //주사위로 온 곳 방문체크
                        visited[board[target].end] = true; //사다리나 뱀으로 이동한 곳 방문체크
                        count[board[target].end] = count[now] + 1;
                    }
                } else {
                  que.add(target);
                  visited[target] = true;
                  count[target] = count[now] + 1;
                }

            }
        }

    }
}