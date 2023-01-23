import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	//백준 10951번 A+B - 4
	public static void main(String[] args) throws IOException {
		//EOF 사용법
		//EOF란? End of File : 더 이상 읽을 수 있는 데이터가 없음
		//입력값을 얼마나 받을지 명시하지 않는 경우 사용한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
 
		while(true){
			try {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				sb.append(a+b).append("\n");
			} catch(Exception e) {
				break;
			}
		}
		System.out.print(sb);
	}

}
