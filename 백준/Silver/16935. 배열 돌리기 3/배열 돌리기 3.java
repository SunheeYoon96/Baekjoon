import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N; //N행
	static int M; //M열
	static int rotateCnt; //연산(회전)횟수
	static int[][] map; //2차원 배열
	static int[] rotateList;

	//연산횟수*N*M < 2초 
	//1000*100*100 = 10,000,000

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));

		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		rotateCnt = Integer.parseInt(tokens.nextToken());

		//원본 배열 받기
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		String str = input.readLine();
		str = str.replaceAll("11", "").replaceAll("22", "").replaceAll("34", "").replaceAll("43", "").replaceAll("56", "").replaceAll("65", "");
		tokens = new StringTokenizer(str);
		rotateList = new int[rotateCnt];
		//연산정보 받기
		for (int i = 0; i < rotateCnt; i++) {
			rotateList[i] = Integer.parseInt(tokens.nextToken());
		}

		int nth = 0;
		//주어진 연산 수행
		for (int i = 0; i < rotateCnt; i++) {
			nth = rotateList[i];
			switch (nth) {
			case 1:
				topbottomReverse();
				break;
			case 2:
				leftrightReverse();
				break;
			case 3:
				right90Rotate();
				break;
			case 4:
				left90Rotate();
				break;
			case 5:
				separateRightRotate();
				break;
			case 6:
				separateLeftRotate();
				break;

			}

			//topbottomReverse();
			//right90Rotate();
			//left90Rotate();
			//leftrightReverse();
			//separateRightRotate();
			//separateLeftRotate();
		}

		//결과 출력
		for (int row[] : map) {
			for (int x : row) {
				//System.out.print(x + " ");
				output.append(x).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output);

	}

	//1.상하반전
	public static void topbottomReverse() {
		//임시로 한줄을 담을 1차원배열선언
		int n = map.length;
		int[] tempR = new int[n];

		for (int r = 0; r < n / 2; r++) {
			// 맨 윗줄과 마지막줄을 스왑
			tempR = map[r];
			map[r] = map[n - r - 1];
			map[n - r - 1] = tempR;
		}
	}

	//2.좌우반전
	public static void leftrightReverse() {
		right90Rotate();
		topbottomReverse();
		left90Rotate();
	}

	//3. 오른쪽으로 90도 회전
	public static int[][] right90Rotate() {
		int n = map.length;
		int m = map[0].length;
		int[][] map2 = new int[m][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				map2[c][n - r - 1] = map[r][c];
			}
		}
		map = map2;
		return map;
	}

	//4. 왼쪽으로 90도 회전
	public static int[][] left90Rotate() {
		int n = map.length;
		int m = map[0].length;
		int[][] map2 = new int[m][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				map2[m - c - 1][r] = map[r][c];
			}
		}
		map = map2;
		return map;
	}

	//5. 구역을 시계방향회전
	public static void separateRightRotate() {
		int n = map.length;
		int m = map[0].length;
		int[][] tmp2d_A = new int[n / 2][m / 2]; //구역을 나눈 배열 (0,0)
		int[][] tmp2d_B = new int[n / 2][m / 2]; //구역을 나눈 배열 (0,1)
		int[][] tmp2d_C = new int[n / 2][m / 2]; //구역을 나눈 배열 (1,1)
		int[][] tmp2d_D = new int[n / 2][m / 2]; //구역을 나눈 배열 (1,0)

		//tmp2d_A
		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp2d_A[r][c] = map[r][c];
			}
		}

		//tmp2d_B
		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp2d_B[r][c] = map[r][c + m / 2];
			}
		}

		//tmp2d_C
		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp2d_C[r][c] = map[r + n / 2][c + m / 2];
			}
		}

		//tmp2d_D
		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp2d_D[r][c] = map[r + n / 2][c];
			}
		}

		//구역을 회전시켜서 배열에 넣기
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (r < n / 2 && c < m / 2) {
					map[r][c] = tmp2d_D[r][c];
				}
				if (r < n / 2 && c >= m / 2) {
					map[r][c] = tmp2d_A[r][c - m / 2];
				}
				if (r >= n / 2 && c < m / 2) {
					map[r][c] = tmp2d_C[r - n / 2][c];
				}
				if (r >= n / 2 && c >= m / 2) {
					map[r][c] = tmp2d_B[r - n / 2][c - m / 2];
				}
			}
		}

	}

	//6. 구역을 반시계방향회전
	public static void separateLeftRotate() {
		int n = map.length;
		int m = map[0].length;
		int[][] tmp2d_A = new int[n / 2][m / 2]; //구역을 나눈 배열
		int[][] tmp2d_B = new int[n / 2][m / 2]; //구역을 나눈 배열
		int[][] tmp2d_C = new int[n / 2][m / 2]; //구역을 나눈 배열
		int[][] tmp2d_D = new int[n / 2][m / 2]; //구역을 나눈 배열

		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp2d_A[r][c] = map[r][c];
			}
		}

		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp2d_B[r][c] = map[r][c + m/2];
			}
		}

		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp2d_C[r][c] = map[r + n/2][c + m/2];
			}
		}

		for (int r = 0; r < n / 2; r++) {
			for (int c = 0; c < m / 2; c++) {
				tmp2d_D[r][c] = map[r + n / 2][c];
			}
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (r < n / 2 && c < m / 2) {
					map[r][c] = tmp2d_B[r][c];
				}
				if (r < n / 2 && c >= m / 2) {
					map[r][c] = tmp2d_C[r][c - m / 2];
				}
				if (r >= n / 2 && c < m / 2) {
					map[r][c] = tmp2d_A[r - n / 2][c];
				}
				if (r >= n / 2 && c >= m / 2) {
					map[r][c] = tmp2d_D[r - n / 2][c - m / 2];
				}
			}
		}
	}

	static String instr = "6 8 1\r\n" + "3 2 6 3 1 2 9 7\r\n" + "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n"
			+ "2 1 3 8 6 3 9 2\r\n" + "1 3 2 8 7 9 2 1\r\n" + "4 5 1 9 8 2 1 3\r\n" + "1";

}
