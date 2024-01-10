import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int N, M, arr[], repres[];

    public static void main(String[] args) throws IOException{
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        arr = new int[N+1];
        repres = new int[N+1];

        makeset();

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int cmd = Integer.parseInt(tokens.nextToken());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());

            if(cmd==0){
                unionSet(a,b);
            }else{
                if(checkSet(a,b)){
                    output.append("YES").append("\n");
                }else{
                    output.append("NO").append("\n");
                }
            }
        }

        System.out.println(output);
    }

    private static boolean checkSet(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if(a==b){
            return true;
        }
        return false;
    }

    private static void unionSet(int a, int b) {
        a = findSet(repres[a]);
        b = findSet(repres[b]);

        if(a != b){
            if(a < b){
                repres[b] = a;
            }else{
                repres[a] = b;
            }
        }
    }

    private static int findSet(int a) {
        if(a==repres[a]){
            return a;
        }
        return repres[a] = findSet(repres[a]);
    }

    private static void makeset() {
        for (int i = 0; i <= N; i++) {
            repres[i] = i;
        }
    }
}