import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, dpMax[][], dpMin[][];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());

        dpMax = new int[N][3];
        dpMin = new int[N][3];

        for (int i = 0; i < N; i++) {
           tokens = new StringTokenizer(input.readLine());
           int x1 = Integer.parseInt(tokens.nextToken());
           int x2 = Integer.parseInt(tokens.nextToken());
           int x3 = Integer.parseInt(tokens.nextToken());

           if(i==0){
               //dpMax 초기화
               dpMax[0][0] = x1;
               dpMax[0][1] = x2;
               dpMax[0][2] = x3;
               //dpMin 초기화
               dpMin[0][0] = x1;
               dpMin[0][1] = x2;
               dpMin[0][2] = x3;
           }else{
               dpMax[i][0] = Math.max( dpMax[i-1][0], dpMax[i-1][1] ) + x1;
               dpMax[i][1] = Math.max( Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2] ) + x2;
               dpMax[i][2] = Math.max( dpMax[i-1][1], dpMax[i-1][2] ) + x3;
               dpMin[i][0] = Math.min( dpMin[i-1][0], dpMin[i-1][1] ) + x1;
               dpMin[i][1] = Math.min( Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2] ) + x2;
               dpMin[i][2] = Math.min( dpMin[i-1][1], dpMin[i-1][2] ) + x3;
            }
        }

        output.append(Math.max(Math.max(dpMax[N-1][0], dpMax[N-1][1]), dpMax[N-1][2])).append(" ");
        output.append(Math.min(Math.min(dpMin[N-1][0], dpMin[N-1][1]), dpMin[N-1][2]));

        System.out.println(output);



    }
}