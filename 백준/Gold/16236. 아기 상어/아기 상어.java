import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, sea[][], time;
    static int deltas[][] = {{1,0},{0,1},{0,-1},{-1,0}};
    static Shark babyShark;

    static class Loc {
        int x, y, dist;
        public Loc (int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static class Shark {
        int x, y, size, cnt;
        public Shark (int x, int y, int size, int cnt) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.cnt = cnt;
        }
    }

    static class Fish implements Comparable<Fish> {
        int x, y, size, dist;
        public Fish (int x, int y, int size, int dist) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if(this.dist==o.dist){
                if(this.x==o.x){
                    return this.y - o.y;
                } else {
                    return this.x - o.x;
                }
            }
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        sea = new int[N][N];

        for (int r = 0; r < N; r++) {
            tokens = new StringTokenizer(input.readLine());
            for (int c = 0; c < N; c++) {
                int val = Integer.parseInt(tokens.nextToken());
                if(val==9){
                    babyShark = new Shark(r,c,2,0);
                    val = 0;
                }
                sea[r][c] = val;
            }
        }

        time = 0;

        simulation(babyShark);

        System.out.println(time);

    }

    private static void simulation(Shark babyShark) {
        while (true){
            //0. 아기상어 커질 수 있니?
            if(babyShark.cnt == babyShark.size){
                babyShark.size += 1;
                babyShark.cnt = 0;
            }

            //1. 먹을 수 있는 물고기 확인
            PriorityQueue<Fish> fishes = new PriorityQueue<>();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(sea[r][c]!=9 && sea[r][c]!=0){
                        if(sea[r][c] < babyShark.size){
                            int dist = calcDist(r,c, babyShark);
                            if(dist > -1){
                                fishes.add(new Fish(r, c, sea[r][c], dist));
                            }
                        }
                    }
                }
            }//

            if(fishes.isEmpty()) break;

            //이동 + 먹기
            Fish now = fishes.poll();
            babyShark.x = now.x;
            babyShark.y = now.y;
            babyShark.cnt += 1;
            sea[now.x][now.y] = 0;

            //시간흐름
            time += now.dist;

//            printArr();
//            System.out.println("time"+ time);
//            System.out.println();

        }



    }

    private static int calcDist(int r, int c, Shark babyShark) {
        Queue<Loc> que = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][N];
        que.add(new Loc(babyShark.x, babyShark.y, 0));
        visited[babyShark.x][babyShark.y] =true;
        int dist = -1;

        while (!que.isEmpty()){
            Loc current = que.poll();

            if(current.x==r && current.y==c) return current.dist;

            for (int d = 0; d < deltas.length; d++) {
                int nr = current.x + deltas[d][0];
                int nc = current.y + deltas[d][1];

                if(!isIn(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(babyShark.size >= sea[nr][nc]){
                    que.add(new Loc(nr, nc, current.dist+1));
                    visited[nr][nc] = true;
                }

            }
        }

        return dist;
    }

    private static boolean isIn(int nr, int nc){
        if(nr<0 || nr>=N || nc<0 || nc>=N) return false;
        return true;
    }

    private static void printArr(){
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(sea[i]));
        }
    }
}