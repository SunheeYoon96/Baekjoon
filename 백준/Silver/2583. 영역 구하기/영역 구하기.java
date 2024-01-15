import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int M, N, K, map[][];
    static int deltas[][] = {{1,0},{0,-1},{0,1},{-1,0}};
    static List<Integer> spaces;
    static boolean visited[][];

    static class Loc {
        int r, c;
        Loc(int r, int c){
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        M = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        map = new int[M][N];

        for (int i = 0; i < K; i++) {
            tokens = new StringTokenizer(input.readLine());
            int x1 = Integer.parseInt(tokens.nextToken());
            int y1 = Integer.parseInt(tokens.nextToken());
            int x2 = Integer.parseInt(tokens.nextToken());
            int y2 = Integer.parseInt(tokens.nextToken());

            for (int c = y1; c <y2; c++) {
                for (int r = x1; r < x2; r++) {
                    map[c][r] = 1;
                }
            }
        }

        spaces = new ArrayList<>();
        visited = new boolean[M][N];

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if(visited[r][c]) continue;
                if(map[r][c]==0){
                    int value = bfs(r,c);
                    spaces.add(value);
                }
            }
        }

        output.append(spaces.size()).append("\n");

        Collections.sort(spaces);
        for(int area : spaces){
            output.append(area).append(" ");
        }

        System.out.println(output);

    }

    private static int bfs(int r, int c) {
        Queue<Loc> queue = new ArrayDeque<>();
        int size = 1;
        queue.add(new Loc(r,c));
        visited[r][c] = true;

        while (!queue.isEmpty()){
            Loc now = queue.poll();

            for (int d = 0; d < deltas.length; d++) {
                int nr = now.r + deltas[d][0];
                int nc = now.c + deltas[d][1];

                if(!isIn(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc]==0){
                    queue.add(new Loc(nr, nc));
                    visited[nr][nc] = true;
                    size++;
                }
            }
        }

        return size;
    }

    private static boolean isIn(int nr, int nc) {
        if(nr<0 || nr>=M || nc<0 || nc>=N) return false;
        return true;
    }
}