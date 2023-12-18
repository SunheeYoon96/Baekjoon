import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M, map[][], newMap[][];
    static int deltas[][] = {{1,0},{0,-1},{-1,0},{0,1}};
    static boolean visited[][];

    static class Loc {
        int r,c;
        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        map = new int[N][M];
        newMap = new int[N][M];
        visited = new boolean[N][M];
        Loc start = null;

        for (int r = 0; r < N; r++) {
            tokens = new StringTokenizer(input.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(tokens.nextToken());
                if(map[r][c]==2){
                    start = new Loc(r,c);
                }
            }
        }

        bfs(start);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(!visited[r][c] && map[r][c]==1){
                    output.append(-1).append(" ");
                }else{
                    output.append(newMap[r][c]).append(" ");
                }
            }
            output.append("\n");
        }

        System.out.println(output);

    }

    private static void bfs(Loc start) {
        int sr = start.r;
        int sc = start.c;
        Queue<Loc> queue = new ArrayDeque<>();
        queue.add(start);
        visited[sr][sc] = true;

        while (!queue.isEmpty()){
            Loc now = queue.poll();

            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];

//                System.out.println(nr);

                if(isIn(nr,nc)){
                    if(!visited[nr][nc]){
                        if(map[nr][nc]==1){
                            visited[nr][nc] = true;
                            queue.add(new Loc(nr, nc));
                            newMap[nr][nc] = newMap[now.r][now.c] +1;
                        }
                    }
                }




            }
        }

    }

    private static boolean isIn(int nr, int nc) {
        if(nr<0 || nr>=N || nc<0 || nc>=M) return false;
        return true;
    }
}