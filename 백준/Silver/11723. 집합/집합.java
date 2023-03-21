import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N,S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// bitmasking!
		//input = new BufferedReader(new StringReader(instr));
		N = Integer.parseInt(input.readLine());
		S=0;

		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			String cmd = tokens.nextToken();

			switch (cmd) {
				case "all":
					//전체를 다 1로 표시
					S = (1<<21)-1;
					break;
				case "empty":
					//전체를 공집합으로 만듬
					S=0;
					break;
				 default:
					 int x = Integer.parseInt(tokens.nextToken());
						switch (cmd) {
							case "add":
								//추가할 때는 비트를 움직이면서 OR연산을 통해 1을 표시함
								S |= (1 << x);
								break;
							case "remove":
								//제거할 때는 비트를 움직이면서 ~(not)과 AND연산을 통해 0으로 바꾼다.
								S &= ~(1<<x);
								
								break;
							case "check":
								//해당 위치에 1이 있는지 확인하는 것은
								//그 위치에 해당하는 숫자가 있는지 체크하는 것과 동일
								//그 숫자가 있다면 1이상의 값을 반환할 것 
								if( (S & (1<<x)) >0 ) {
									output.append(1).append("\n");
								}else {
									output.append(0).append("\n");
								}
								break;
							case "toggle":
								S ^= (1<<x);
								break;
						}

			}

		}
		System.out.println(output);
		

	}

	private static String instr = "26\r\n" + "add 1\r\n" + "add 2\r\n" + "check 1\r\n" + "check 2\r\n" + "check 3\r\n"
			+ "remove 2\r\n" + "check 1\r\n" + "check 2\r\n" + "toggle 3\r\n" + "check 1\r\n" + "check 2\r\n"
			+ "check 3\r\n" + "check 4\r\n" + "all\r\n" + "check 10\r\n" + "check 20\r\n" + "toggle 10\r\n"
			+ "remove 20\r\n" + "check 10\r\n" + "check 20\r\n" + "empty\r\n" + "check 1\r\n" + "toggle 1\r\n"
			+ "check 1\r\n" + "toggle 1\r\n" + "check 1";

}