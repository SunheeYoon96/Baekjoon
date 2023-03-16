import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 뱀의 이동방식 : 머리 이동, 꼬리 사라짐
 * 90도씩 방향전환
 * 
 * [풀이과정]
 * 
 * [입력]
 * [출력] 
 * 
 * @author 윤선희
 * @since 
 * @see
 * @performance
 * @category #
 */

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, map[][], appleCnt, dirCnt, dirInfo[][], answer;
	static final int changeTime=0, direction=1;
	static int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static ArrayDeque<SnakePoint> snake;
	
	static class SnakePoint{
		int x,y;

		public SnakePoint(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		N = Integer.parseInt(input.readLine());
		appleCnt = Integer.parseInt(input.readLine());
		
		map = new int[N][N];
		
		//사과정보 입력
		for(int i=0; i<appleCnt; i++) {
			//사과없는 곳:0 , 사과 있는곳:1
			tokens = new StringTokenizer(input.readLine());
			int appleR = Integer.parseInt(tokens.nextToken())-1;
			int appleC = Integer.parseInt(tokens.nextToken())-1;
			map[appleR][appleC] = 1;
		}
		
		dirCnt = Integer.parseInt(input.readLine());
		dirInfo = new int[dirCnt][2];
		
		//방향정보 입력
		for (int i = 0; i < dirCnt; i++) {
			tokens = new StringTokenizer(input.readLine());
			int t = Integer.parseInt(tokens.nextToken());
			String dir = tokens.nextToken();
			dirInfo[i][changeTime] = t;
			
			if(dir.equals("L")) { //왼쪽회전일 경우:0
				dirInfo[i][direction] = 0;
			}else if(dir.equals("D")) { //오른쪽회전일 경우:1
				dirInfo[i][direction] = 1;
			}
		}
		//입력완료
		
		//뱀 이동시작
		moveSnake();
		
		System.out.println(answer);

	}
	
	private static void moveSnake() {
		//1.준비물
		snake = new ArrayDeque<>();
		int time=0;
		int d =0; //시작방향
		int chageidx=0;
		
		//초기화 및 뱀의 시작지점 큐에 담기
		snake.offer(new SnakePoint(0, 0));
		map[0][0] = -1; //뱀이 있는 곳:-1
		
		while (true) {
			time++;
			SnakePoint current = snake.peekFirst();
			int nr = current.x + deltas[d][0];
			int nc = current.y + deltas[d][1];
			
			//1. 벽에 부딪히면 종료
			if(!isIn(nr, nc)) break;
			
			//2. 몸통끼리 부딪히면 종료
			if(map[nr][nc]==-1) break;
			
			//3. 위 상황에 해당하지 않으면 뱀이동 (큐에 머리넣기)
			//3-1. 이동위치에 사과가 있으면 사과 먹기
			if(map[nr][nc]==1) {
				map[nr][nc]=-1;
				snake.offerFirst(new SnakePoint(nr, nc));
			}
			//3-2. 이동위치에 사과 없으면 꼬리 자르기(큐에서 꼬리빼기)
			else {
				map[nr][nc]=-1;
				snake.offerFirst(new SnakePoint(nr, nc));
				SnakePoint rear = snake.pollLast();
				map[rear.x][rear.y]=0;
			}
			
			//방향정보를 다 썻으면 다음 반복으로 넘어감
			if(chageidx ==dirInfo.length) continue;
			
			if(time==dirInfo[chageidx][changeTime]) {
				//왼쪽 90도 전환 상 좌 하 우 3 2 1 0 순
				if(dirInfo[chageidx][direction]==0) {
					d = (d+3) % 4;
				}
				//오른쪽 90도 전환 우 하 좌 상 0 1 2 3 순
				else {
					d = (d+1) % 4;
				}
				chageidx++;
			}
			
		}
		
		answer = time;
	}

	private static boolean isIn(int nr, int nc) {
		if(nr<0 || nr>=N || nc<0 || nc>=N) return false;
		return true;
	}

	private static String instr="6\r\n" + 
			"3\r\n" + 
			"3 4\r\n" + 
			"2 5\r\n" + 
			"5 3\r\n" + 
			"3\r\n" + 
			"3 D\r\n" + 
			"15 L\r\n" + 
			"17 D";

}