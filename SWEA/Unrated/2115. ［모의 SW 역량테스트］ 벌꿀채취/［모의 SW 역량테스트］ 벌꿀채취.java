import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

/**
 * [키워드]
 * 
 * [풀이과정] 
 * 1. 추출할 수 있는 벌통갯수를 겹치지 않게 2개 뽑는 조합을 구하기 
 * -- 겹치지 않는 2개를 구했을 때, 
 * -- 각 조합에서 부분집합을 구할꺼야 
 * -- 근데 부분집합의 합은 C를 넘지 않을꺼야 이것들의 수익 중 최대를 구해보아라
 * 
 * [입력] 
 * [출력]
 * 
 * @author 윤선희 
 * @see 
 * @performance 
 * @category
 */

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T, N, M, C;
	static int honeyMap[][]; // 꿀격자 냠냠
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());

		for (int t = 1; t <= T; t++) {
			output.append("#").append(t).append(" ");

			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());

			honeyMap = new int[N][N];
			for (int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for (int c = 0; c < N; c++) {
					honeyMap[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			// 입력완

			gethoney(0, M);
			output.append(answer).append("\n");

		}
		System.out.println(output);

	}

	private static void gethoney(int i, int m) {
		answer = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N - M + 1; c++) {
				// 첫번째 사각형: (r, c)에서 시작하는 사각형
				// 첫번째랑 같은 줄일때
				int rr = r;
				for (int cc = c + M; cc < N - M + 1; cc++) {
					// 나머지 연산 수행 -> 최댓값 갱신
					int benefit1 = extractHoney(r, c);
					int benefit2 = extractHoney(rr, cc);
					answer = Math.max(answer, benefit1 + benefit2);

				}

				// 첫번째랑 다른 줄일때
				for (rr = r + 1; rr < N; rr++) {
					for (int cc = 0; cc < N - M + 1; cc++) {
						// 나머지 연산 수행 -> 최댓값 갱신
						int benefit1 = extractHoney(r, c);
						int benefit2 = extractHoney(rr, cc);
						answer = Math.max(answer, benefit1 + benefit2);
					}
				}
			}
		}

	}

	private static int extractHoney(int startR, int startC) {
		int maxBenefit = -1;
		
		//부분집합 벌꿀통 구하기
        for(int selected = 1; selected < (1 << M); selected++) {
            int sum = 0;
            int benefit = 0;
            
            for(int c = 0; c < M; c++) {
                if(((1 << c) & selected) > 0) {
                	sum += honeyMap[startR][startC + c];
                    benefit += honeyMap[startR][startC + c] * honeyMap[startR][startC + c];
                }
            }
            
            if(sum > C) continue;
             
            //최대수익 갱신
            maxBenefit = Math.max(maxBenefit, benefit);
        }
		return maxBenefit;
	}


}