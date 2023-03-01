import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드] 크기가 N*M인 지도 지도의 좌표는 r,c (r은 북쪽으로부터 떨어진 칸의 수, c는 서쪽으로부터 떨어진 칸의 수 주사위는 지도
 * 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 있음 !!가장 처음 주사위에는 모든면이 0으로 써있음!! 주사위는 범위
 * 밖으로 이동할 수 없음 범위밖으로 이동하는 명령은 무시하고 출력도 안함 지도==0 : 주사위 바닥면값을 지도에 복사 지도!=0 :
 * 주사위바닥면에 지도칸 값을 복사하고 지도칸은 0으로 변경
 * 
 * [풀이과정] 1. 주사위 전개도를 123456 으로 만들고 초기화 2. 모든 모든면을 0으로 설정 3. 명령어만큼 반복문 -- 3-1)
 * 어떤 방향의 명령인지 확인 -- 3-2) 해당방향 명령어 함수 실행 -- 3-3) 주사위 위치 이동 이 과정을 반복하는데, 범위 내에
 * 주사위가 존재할 때만 상단의 값을 출력한다.
 * 
 * [입력] 세로 N, 가로 M (1 ≤ N, M ≤ 20) 명령어 갯수 K (1 ≤ K ≤ 1,000) 지도의 각 칸에 쓰여 있는 수는 10
 * 미만의 자연수 또는 0이다. 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
 * 
 * [출력] 이동할 때마다 주사위의 윗 면에 쓰여 있는 수를 출력 범위밖으로 이동하는 주사위는 명령을 무시하고, 출력도 안한다.
 * 
 * @since 2023.03.01
 * @see https://www.acmicpc.net/problem/14499
 * @performance
 * @category #시뮬레이션
 */

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	//   2
	// 4 1 3  : 1-윗면
	//   5
	//   6 바닥
	static int N, M, K, r, c, map[][];
	static int dice[];
	static int deltas[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // 동서북남 (1 2 3 4)

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		r = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		// 처음 주사위 선언 및 초기화
		dice = new int[7]; // 주사위 1 2 3 4 5 6

		tokens = new StringTokenizer(input.readLine());
		for (int k = 0; k < K; k++) {
			int dir = Integer.parseInt(tokens.nextToken())-1;

			// 1. 주사위 이동
			r = r + deltas[dir][0];
			c = c + deltas[dir][1];

			// 1-1. 범위 밖으로 나가면
			if (!isIn(r, c)) {
				// 주사위 원위치로 다시 옮겨놓기 -> 무시하고 다음명령어 수행하게하기
				r -= deltas[dir][0];
				c -= deltas[dir][1];
				continue;
			}

			// 2. 명령 실행
			switch (dir) {
			case 0: //동
				moveRight();
				break;
			case 1: //서
				moveLeft();
				break;
			case 2: //북
				moveUp();
				break;
			case 3: //남
				moveDown();
				break;

			}//end switch
			
			// 3. 주사위의 바닥면 복사
			copyDiceBottom(r, c);
			
			// 4. 명령 수행 후 주사위 윗면 출력
			printDiceTop();

		}
		
		System.out.println(output);
		

	}

	//주사위 윗면 출력
	private static void printDiceTop() {
		output.append(dice[1]).append("\n");
		
	}

	//맵에 따른 주사위 바닥면 복사작업
	private static void copyDiceBottom(int nr, int nc) {
		if(map[nr][nc]==0) {
			map[nr][nc] = dice[6];
		}else {
			dice[6] = map[nr][nc];
			map[nr][nc] =0;
		}
	}

	//남쪽이동
	private static void moveDown() {
		int temp = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[6];
		dice[6] = dice[5];
		dice[5] = temp;
	}

	//북쪽이동
	private static void moveUp() {
		int temp = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[6];
		dice[6] = dice[2];
		dice[2] = temp;
	}

	//서쪽이동
	private static void moveLeft() {
		int temp = dice[1];
		dice[1] = dice[3];
		dice[3] = dice[6];
		dice[6] = dice[4];
		dice[4] = temp;
		
	}

	//동쪽이동
	private static void moveRight() {
		int temp = dice[1];
		dice[1] = dice[4];
		dice[4] = dice[6];
		dice[6] = dice[3];
		dice[3] = temp;
		 
	}

	private static boolean isIn(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M)
			return true;
		return false;
	}

}