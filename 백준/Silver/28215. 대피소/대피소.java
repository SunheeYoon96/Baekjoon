import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, K, answer;
    static Loc houses[];
    
    static class Loc {
        int x, y;
        
        public Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        houses = new Loc[N];

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(tokens.nextToken());
            int y = Integer.parseInt(tokens.nextToken());
            houses[i] = new Loc(x,y);
        }

        answer = Integer.MAX_VALUE;
        
        makeCombination(0, 0, new boolean[N]);

        System.out.println(answer);

    }

    private static void makeCombination(int cnt, int start, boolean[] visited) {
        
        if(cnt==K){
            int value = calcMaxDistanceFromCamps(visited);
            answer = Math.min(answer, value);
        }

        for (int i = start; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                makeCombination(cnt+1, start+1, visited);
                visited[i] = false;
            }
        }
    }

    private static int calcMaxDistanceFromCamps(boolean[] visited) {
        int val = 0;
        List<Loc> selected = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if(visited[i]){
                selected.add(houses[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            Loc nowHouse = houses[i];
            int dist = Integer.MAX_VALUE;
            for (int j = 0; j < K; j++) {
                Loc nowCamp = selected.get(j);
                dist = Math.min(dist, Math.abs(nowHouse.x-nowCamp.x)+Math.abs(nowHouse.y-nowCamp.y));
            }
            val = Math.max(val, dist);
        }
        
        return val;
        
    }
}