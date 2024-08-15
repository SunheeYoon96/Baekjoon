import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static class Point {
        int num, r, c;
        Point(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }
    }

    static int N, K;
    static Point[] missions;
    static Map<Integer, Point> numPoints;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        missions = new Point[K];
        numPoints = new HashMap<>();

        for (int i = 0; i < K; i++) {
            tokens = new StringTokenizer(input.readLine());
            int num = Integer.parseInt(tokens.nextToken());
            int r = Integer.parseInt(tokens.nextToken()) - 1;
            int c = Integer.parseInt(tokens.nextToken()) - 1;
            missions[i] = new Point(num, r, c);
            numPoints.put(num, new Point(num, (num-1)/N, (num-1)%N));
        }

        for (int i = 0; i < K; i++) {
            // 이동할 숫자
            Point missionPoint = missions[i];
            Point currentPoint = numPoints.get(missionPoint.num);
            int moveR, moveC;
            int cnt = 0;

            // 열 바꾸기
            moveC = (missionPoint.c - currentPoint.c + N) % N;
            cnt += moveC;


            // 같은 행에 있는 숫자 회전
            for (Point p : numPoints.values()) {
                if (p.r == currentPoint.r) {
                    p.c = (p.c + moveC) % N;
                }
            }

            currentPoint.c = missionPoint.c;
            //System.out.println(currentPoint.num + " " + currentPoint.r + " "+ currentPoint.c);

            // 행 바꾸기
            moveR = (missionPoint.r - currentPoint.r + N) % N;
            cnt += moveR;


            // 같은 열에 있는 숫자 회전
            for (Point p : numPoints.values()) {
                if (p.c == currentPoint.c) {
                    p.r = (p.r + moveR) % N;
                }
            }

            currentPoint.r = missionPoint.r;
            //System.out.println(currentPoint.num + " " + currentPoint.r + " "+ currentPoint.c);

            numPoints.put(missionPoint.num, currentPoint);
            output.append(cnt).append("\n");
        }

        System.out.println(output);
    }
}