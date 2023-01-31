import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //설탕배달
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		int cnt = 0;
		
		while(true) {
			if(N%5==0) {
				cnt += N/5;
				break;
			}else if(N==4 || N==7) {
				cnt = -1;
				break;
			}
			N -= 3; //5의 배수가 아니면 3을 뺀 뒤에 3키로 가방에 넣었다고 생각하고 가방 갯수를 ++ 해준다. 
			cnt++;
		}
		System.out.println(cnt);
		
	}

}
