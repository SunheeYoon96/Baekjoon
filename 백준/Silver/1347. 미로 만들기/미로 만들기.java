import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static int N;
    static String road;
    static boolean maze[][];
    static int deltas[][] = {{1,0},{0,-1},{-1,0},{0,1}}; //남서북동

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        road = input.readLine();
        int roadLen = road.length();

        //문자 최대길이 50 -> 그냥 빈배열 100*100 만들어도 두배임
        maze = new boolean[100][100];
        int maxX = 49;
        int maxY = 49;
        int minX = 49;
        int minY = 49;
        int nowX = 49;
        int nowY = 49;
        int dir = 0;
        maze[nowX][nowY] = true;

        for (int i = 0; i < roadLen; i++) {
            char c = road.charAt(i);
            if(c=='R'){
                dir = (dir+1)%4;
            } else if (c=='L') {
                dir = (dir+3)%4;
            }else {
                nowX += deltas[dir][0];
                nowY += deltas[dir][1];
                maze[nowX][nowY] = true;
                maxX = Math.max(maxX, nowX);
                maxY = Math.max(maxY, nowY);
                minX = Math.min(minX, nowX);
                minY = Math.min(minY, nowY);
            }
        }

        for (int i = minX; i <= maxX ; i++) {
            for (int j = minY; j <= maxY ; j++) {
                if(maze[i][j]) output.append(".");
                else output.append("#");
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}