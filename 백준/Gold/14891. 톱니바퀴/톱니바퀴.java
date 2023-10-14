import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    //K(회전횟수)<=100
    //N극:0 S극:1
    //톱니바퀴 자석순서(12시부터 시계방향으로) : 01234567
    //회전방향 : 시계(1) 반시계(-1)
    //톱니바퀴 번호 0 1 2 3
    static int K, order[][], dirs[];
    static Gear gears[];
    static final int N=0, S=1, CLOCKWISE=1, COUNTERCLOCKWISE=-1; //시계방향, 반시계방향

    public static class Gear {
        int num, status[];

        public Gear(int num, int[] status) {
            this.num = num;
            this.status = status;
        }

        void rotateRight(){
            int newStatus [] = new int[8];
            for (int i = 0; i < 8; i++) {
                int idx = (i+1)%8;
                newStatus[idx] = this.status[i];
            }
            this.status = newStatus;
        }

        void rotateLeft(){
            int newStatus [] = new int[8];
            for (int i = 0; i < 8; i++) {
                int idx = (i-1+8)%8;
                newStatus[idx] = this.status[i];
            }
            this.status = newStatus;
        }

    }


    public static void main(String[] args) throws IOException {
        gears = new Gear[4];

        for (int i = 0; i < 4; i++) {
            String line = input.readLine();
            int tempStatus[] = new int[8];

            for (int j = 0; j < 8; j++) {
                tempStatus[j] = line.charAt(j)-'0';
            }
            gears[i] = new Gear(i, tempStatus);
        }

        K = Integer.parseInt(input.readLine());
        order = new int[K][2];

        for (int i = 0; i < K; i++) {
            tokens = new StringTokenizer(input.readLine());
            int gearNum = Integer.parseInt(tokens.nextToken()) -1;
            int dir = Integer.parseInt(tokens.nextToken());
            order[i][0] = gearNum;
            order[i][1] = dir;
        }
        //입력완료

        //주어진 횟수만큼 톱니바퀴 회전시키기
        for (int i = 0; i < K; i++) {
            int nowGearNum = order[i][0];
            int nowDir = order[i][1];

            dirs = new int[4]; //4개의 톱니바퀴가 움직여야 할 방향
            dirs[nowGearNum] = nowDir;
            checkRotate(nowGearNum);
            rotate();
        }

        //점수 계산하기
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if(gears[i].status[0]==1){
                answer += (int)Math.pow(2,i);
            }
        }

        System.out.println(answer);

    }

    private static void rotate() {
        for (int i = 0; i < 4; i++) {
            if(dirs[i] == 1) {
                gears[i].rotateRight();
            }else if(dirs[i] == -1){
                gears[i].rotateLeft();
            }
        }

    }

    private static void checkRotate(int nowGearNum){
        //현재를 기준으로 왼쪽 톱니바퀴 회전 방향 확인
        for (int i = nowGearNum-1; i >=0 ; i--) {
            if(gears[i].status[2] != gears[i+1].status[6]){
                dirs[i] = -dirs[i+1];
            }else{
                //회전을 안하면 그대로 놔둔다.
                break;
            }
        }
        //현재를 기준으로 오른쪽 톱니바퀴 회전 방향 확인
        for (int i = nowGearNum+1; i <4 ; i++) {
            if(gears[i].status[6] != gears[i-1].status[2]){
                dirs[i] = -dirs[i-1];
            } else {
                break;
            }

        }

    }

}
