import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N;
    static int board[][];
    static int deltas[][] = {{-2,-1},{-2,1},{0,2},{2,1},{2,-1},{0,-2}};

    static class Point{
        int r, c, cnt ;
        Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        board = new int[N][N];

        Point start, end;
        tokens = new StringTokenizer(input.readLine());
        start = new Point(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), 0);
        end = new Point(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), 0);

        int answer = bfs(start, end);
        System.out.println(answer);


    }

    static int bfs(Point start, Point end){
        Queue<Point> queue = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][N];
        queue.add(start);
        visited[start.r][start.c] = true;

        while (!queue.isEmpty()){
            Point now = queue.poll();

            if(now.r== end.r && now.c== end.c) return now.cnt;

            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];

                if(!isIn(nr, nc)) continue;
                if(visited[nr][nc]) continue;

                queue.add(new Point(nr, nc, now.cnt+1));
                visited[nr][nc] = true;
            }

        }

        return -1;
    }

    private static boolean isIn(int nr, int nc) {
        if(nr<0 || nr>=N || nc<0 || nc>=N) return false;
        return true;
    }
}