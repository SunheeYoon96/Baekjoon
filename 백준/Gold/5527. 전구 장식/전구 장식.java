import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, arr[], answer;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		list = new ArrayList<>();
		answer = 0;
		
		tokens = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int cnt=1;
		
		for (int i = 0; i < N-1; i++) {
			int now = arr[i];
			int next = arr[i+1];
			
			//이전 값과 다르면 카운팅
			if(now!=next) {
				cnt+=1;
				if(i==N-2) { //마지막 비교는 예외로 넣어주기
					list.add(cnt);					
				}
			}else {
				if(i==N-2) { //마지막 비교는 예외로 넣어주기
					list.add(cnt);	
					list.add(1);	
				}else {
					list.add(cnt);	
				}
				cnt=1;
			}
		}//
		
		//System.out.println(list);
		
		if(list.size()<3) {
			for (int i = 0; i < list.size(); i++) {
				answer += list.get(i);
			}
		}else {
			for (int i = 0; i < list.size()-3+1; i++) {
				answer = Math.max(answer, list.get(i)+list.get(i+1)+list.get(i+2));
			}			
		}
		
		System.out.println(answer);
		
	}

}