import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //벽을 최소 몇개 부셔서 이동할 수 있는가?
    //최단경로로 이동하라는 뜻이 아님!!! -> 이동하면서 최소 갯수로 벽을 부시는 경로대로 이동해야함.

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, M, map[][];
    static int deltas[][] = {{1,0},{0,-1},{-1,0},{0,1}};

    static class Loc implements Comparable<Loc>{
        int r, c, brokenWallCnt;
        public  Loc (int r, int c, int brokenWallCnt){
            this.r = r;
            this.c = c;
            this.brokenWallCnt = brokenWallCnt;
        }

        @Override
        public int compareTo(Loc o) {
            return this.brokenWallCnt - o.brokenWallCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        M = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            String str = input.readLine();
            for (int c = 0; c < M; c++) {
                int val = str.charAt(c)-'0';
                map[r][c] = val;
            }
        }

        int answer = bfs();
        System.out.println(answer);

    }

    private static int bfs() {
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        boolean visited[][] = new boolean[N][M];
        pq.add(new Loc(0,0,0));
        visited[0][0] = true;

        while (!pq.isEmpty()){
            Loc now = pq.poll();

            if(now.r==N-1 && now.c==M-1) return now.brokenWallCnt;

            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];

                if(!isIn(nr, nc)) continue;
                if(visited[nr][nc]) continue;

                if(map[nr][nc]==0){
                    pq.add(new Loc(nr, nc, now.brokenWallCnt));
                }else {
                    pq.add(new Loc(nr, nc, now.brokenWallCnt+1));
                }
                visited[nr][nc] = true;
            }
        }

        return 0;
    }

    private static boolean isIn(int nr, int nc) {
        if(nr<0 || nr>=N || nc<0 || nc>=M) return false;
        return true;
    }
}