import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, M, ans;
    static int deltas[][] = {{1,0},{0,-1},{-1,0},{0,1}};
    static char map[][];
    static Loc start;

    static class Loc {
        int x,y;

        public Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        map = new char[N][M]; //O(빈칸), I(도연이), P(사람), X(벽)

        for (int r = 0; r < N; r++) {
            String line = input.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c);
                if(map[r][c]=='I'){
                    start = new Loc(r,c);
                }
            }
        }

        ans = 0;
        bfs();

        System.out.println(ans==0 ? "TT" : ans);

    }

    private static void bfs() {
        Queue<Loc> que = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][M];
        que.add(start);
        visited[start.x][start.y] = true;

        while (!que.isEmpty()){
            Loc now = que.poll();
//            System.out.println(now.x + "," + now.y);

            for (int d = 0; d < 4; d++) {
                int nr = now.x + deltas[d][0];
                int nc = now.y + deltas[d][1];

                if(!isIn(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc]=='X') continue;

                que.add(new Loc(nr, nc));
                visited[nr][nc]=true;
                if(map[nr][nc]=='P') ans++;
            }
        }
    }

    private static boolean isIn(int nr, int nc){
        if(nr<0 || nr>=N || nc<0 || nc>=M) return false;
        return true;
    }
}