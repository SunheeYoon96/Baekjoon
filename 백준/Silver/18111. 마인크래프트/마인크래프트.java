import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 풀이방법 : 완전탐색 (0부터 최대층까지 다 해보고 최소시간 경우 층을 배열에 담아 놓기?)
 *
 */

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M, B, map[][];
    static int deltas[][] = {{1,0},{0,-1},{-1,0},{0,1}};

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        B = Integer.parseInt(tokens.nextToken());

        map = new int[N][M];
        int max = Integer.MIN_VALUE;

        for (int r = 0; r < N; r++) {
            tokens = new StringTokenizer(input.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(tokens.nextToken());
                max = Math.max(max, map[r][c]);
            }
        }

        int time = Integer.MAX_VALUE; //걸린 최소 시간
        int floor = 0;

        //0층부터 최대층까지 전부 다 해본다. 그리고 최소시간이 나올 때마다 기억해두기?
        for (int i = 0; i <= max; i++) {
            int totalTime = 0;
            //맵 복사해서 사용
            int tmpMap[][] = copy(map);
            int blocks = B;

             for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if(tmpMap[r][c]==i) {
                        continue;
                    } else if(tmpMap[r][c] < i) {
                        int gap = i-tmpMap[r][c];
                        blocks -= gap;
                        totalTime += gap;
                        tmpMap[r][c] = i;
                    } else if (tmpMap[r][c] > i) {
                        int gap = tmpMap[r][c]-i;
                        blocks += gap;
                        totalTime += 2*gap;
                        tmpMap[r][c] = i;
                    }

                }
             }

             if(blocks < 0) break; //다 돌았는데 block 이 음수개 -> 할 수 없는 경우의 수를 했다.

            if(time > totalTime) {
                time = totalTime;
                floor = i;
            }else if(time == totalTime){
                floor = i;
            }
        }

        output.append(time).append(" ").append(floor);
        System.out.println(output);

    }

    private static int[][] copy(int[][] map) {
        int newMap[][] = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                newMap[r][c] = map[r][c];
            }
        }
        return newMap;
    }
}