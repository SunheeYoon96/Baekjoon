import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N, M, lierCnt, lierNums[], answer;
    static List<Integer> parties[], peopleInParties[];
    static boolean canLieGrup[];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        canLieGrup = new boolean[M];
        parties = new List[M];
        peopleInParties = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            peopleInParties[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        }

        tokens = new StringTokenizer(input.readLine());
        lierCnt = Integer.parseInt(tokens.nextToken());
        lierNums = new int[lierCnt];
        for (int i = 0; i < lierCnt; i++) {
            lierNums[i] = Integer.parseInt(tokens.nextToken());
        }

        for (int i = 0; i < M; i++) {
            tokens = new StringTokenizer(input.readLine());
            int cnt = Integer.parseInt(tokens.nextToken());
            for (int j = 0; j < cnt; j++) {
                int person = Integer.parseInt(tokens.nextToken());
                parties[i].add(person);
                peopleInParties[person].add(i);
            }
        }

        //입력값으로 주어지는 파티의 구성원들 과
        //특정 사람이 참여하는 파티 모두 저장해놓고
        //둘다 dfs 를 해야함.
        for(int x : lierNums){
            dfs(x);
        }

        for (int i = 0; i < canLieGrup.length; i++) {
            if (!canLieGrup[i]) {
                answer++;
            }
        }

        System.out.println(answer);



    }

    private static void dfs(int x) {
        for (int i = 0; i < peopleInParties[x].size(); i++) {
            int party = peopleInParties[x].get(i);
            if(!canLieGrup[party]){
                canLieGrup[party] = true;

                for (int j = 0; j < parties[party].size(); j++) {
                    int person = parties[party].get(j);
                    dfs(person);
                }
            }
        }

    }
}