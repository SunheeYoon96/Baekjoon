import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    static int N; //방의 갯수
    static Long D; //전투력
    static PriorityQueue<Long> MonsterInfo, WeaponInfo;


    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        D = Long.parseLong(tokens.nextToken());

        MonsterInfo = new PriorityQueue<>();
        WeaponInfo = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(input.readLine());
            Long type = Long.parseLong(tokens.nextToken());
            Long power = Long.parseLong(tokens.nextToken());

            if(type==1){
                MonsterInfo.add(power);
            }else if(type==2) {
                WeaponInfo.add(power);
            }
        } //입력완

        boolean isGo = true;
        int maxRoomCnt = 0;

        for (int i = 0; i < N; i++) {
            if(MonsterInfo.size()==0){
                maxRoomCnt += WeaponInfo.size();
                break;
            }

            if(D > MonsterInfo.peek()){
                D += MonsterInfo.poll();
                maxRoomCnt++;
            }else {
                if(WeaponInfo.size()==0){
                    break;
                }else {
                    D *= WeaponInfo.poll();
                    maxRoomCnt++;
                }
            }

        }

        System.out.println(maxRoomCnt);


    }
}
