import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, cnt, board[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(input.readLine());
		board = new int[N];
		
		nqueen(0);
		System.out.println(cnt);
	}

	private static void nqueen(int idx) {
		if(idx>=N) {
			cnt++;
			return;
		}
		//해당위치에 놓을 수 있을 경우, 다음 가지를 생각해보자.
		for (int i = 0; i < N; i++) {
			board[idx] = i;
			if(possibleNQueen(idx)) {
				nqueen(idx+1);
			}
		}
	}

	private static boolean possibleNQueen(int col) {
		for (int i = 0; i < col; i++) {
			//같은 열에 배치될 경우
			if(board[col]==board[i]) return false; 
			//대각선에 위치할 경우 (열의 차와 행의 차가 같을 때)
			else if(Math.abs(col-i) == Math.abs(board[col]-board[i])) return false;
		}
		return true;
	}

}