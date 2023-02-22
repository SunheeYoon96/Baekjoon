import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, H, W, N, sc, sr;
	static char map[][], cmd[];
	static String cmds, line;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		T = Integer.parseInt(tokens.nextToken());

		for (int t = 1; t <= T; t++) {
			tokens = new StringTokenizer(input.readLine());
			H = Integer.parseInt(tokens.nextToken()); //행
			W = Integer.parseInt(tokens.nextToken()); //열

			map = new char[H][W];
			line = "";

			// 격자데이터 입력
			for (int r = 0; r < H; r++) {
				line = input.readLine();
				for (int c = 0; c < W; c++) {
					char nowc = line.charAt(c);
					map[r][c] = nowc;

					if ("<>^v".contains(nowc + "")) {
						// 전차 시작위치 저장
						sr = r;
						sc = c;
					}
				}
			}

			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			// 명령데이터 입력
			cmd = new char[N];
			cmds = input.readLine();
			for (int i = 0; i < N; i++) {
				cmd[i] = cmds.charAt(i);
			}

			//게임시작!!!
			for (int i = 0; i < N; i++) {
				play(sr, sc, cmd[i]);
			}
			
			//결과 출력
			output.append("#").append(t).append(" ");
			for(char row[] : map) {
				for(char c : row) {
					output.append(c);
				}
				output.append("\n");
			}
		} // end testcase
		
		System.out.println(output);
	}
	

	private static void play(int r, int c, char cmd) {
		int currentR = r; //현재 x좌표
		int currentC = c; //현재 y좌표
		
		switch (cmd) {
		case 'U': //up
			//1. 방향변경
			map[currentR][currentC] = '^';
			
			//2. 범위내에 존재하고 움직이려는 다음칸이 평지이면
			if(isIn(currentR-1, currentC) && map[currentR-1][currentC]=='.') {
				
				//3. 현재 전차위치를 평지로 바꾸고 이동하려는 칸으로 전차이동
				map[currentR][currentC] = '.';
				map[currentR-1][currentC] = '^';
				
				//4. 현재 좌표변경
				currentR -= 1;
			}
			sr = currentR; 
			sc = currentC;
			break;
			
		case 'D'://down
			map[currentR][currentC] = 'v';
			
			if(isIn(currentR+1, currentC) && map[currentR+1][currentC]=='.') {
				map[currentR][currentC] = '.';
				map[currentR+1][currentC] = 'v';
				currentR += 1;
			}
			sr = currentR; 
			sc = currentC;
			break;
			
		case 'L': //left
			map[currentR][currentC] = '<';
			
			if(isIn(currentR, currentC-1) && map[currentR][currentC-1]=='.') {
				map[currentR][currentC] = '.';
				map[currentR][currentC-1] = '<';
				currentC -=1;
			}
			sr = currentR; 
			sc = currentC;
			break;
			
		case 'R': //right
			map[currentR][currentC] = '>';
			
			if(isIn(currentR, currentC+1) && map[currentR][currentC+1]=='.') {
				map[currentR][currentC] = '.';
				map[currentR][currentC+1] = '>';
				currentC +=1;
			}
			sr = currentR; 
			sc = currentC;
			break;
			
		case 'S': //shoot
			char nowstatus = map[currentR][currentC];
			//1. 현재상태 확인
			if(nowstatus == '^') {
				//2. 범위 내에 존재할 때까지 반복
				while(isIn(currentR-1, currentC)) {
					//3-1. 다음칸이 벽돌일 경우 부신다.
					if(map[currentR-1][currentC]=='*') {
						map[currentR-1][currentC]='.';
						break;
					//3-2. 다음칸이 강철이면 암껏도 안함
					}else if(map[currentR-1][currentC]=='#') {
						break;
					//3-3. 그외 상태이면 그 다음칸을 확인하기 위해 좌표변경
					}else {
						currentR -= 1;
					}
				}
				
			}else if(nowstatus == 'v') {
				while(isIn(currentR+1, currentC)) {
					if(map[currentR+1][currentC]=='*') {
						map[currentR+1][currentC]='.';
						break;
					}else if(map[currentR+1][currentC]=='#') {
						break;
					}else {
						currentR += 1;
					}
				}
				
			}else if(nowstatus == '<') {
				while(isIn(currentR, currentC-1)) {
					if(map[currentR][currentC-1]=='*') {
						map[currentR][currentC-1]='.';
						break;
					}else if(map[currentR][currentC-1]=='#') {
						break;
					}else {
						currentC -= 1;
					}
				}
				
			}else if(nowstatus == '>') {
				while(isIn(currentR, currentC+1)) {
					if(map[currentR][currentC+1]=='*') {
						map[currentR][currentC+1]='.';
						break;
					}else if(map[currentR][currentC+1]=='#') {
						break;
					}else {
						currentC += 1;
					}
				}
			}
			
			break;

		}

	}
	
	public static boolean isIn(int r, int c) {
		if(r<0 || r>=map.length || c<0 || c>=map[0].length ) return false;
		return true;
	}

}
