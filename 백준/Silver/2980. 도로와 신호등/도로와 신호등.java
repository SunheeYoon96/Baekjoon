import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int pos = 0; //현재 위치
		int cnt = 0; //시간
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken()); //신호등 위치
			int R = Integer.parseInt(st.nextToken()); //빨간색
			int G = Integer.parseInt(st.nextToken()); //초록색
			
			cnt += (D-pos);// 신호등위치 - 현재위치 (경과시간)
			pos = D;
			
			//시간이 사이클의 배수가 아니면 아직 빨간불 
			int interval = cnt % (R+G);  
			
			if(interval < R) {
				cnt += (R - interval); //-> 나머지 시간만큼 기다리자
			}
						
		}
		//전체길이 - 현재위치 만큼 시간이 흘러야 끝에 도착
		cnt += L - pos;
		
		System.out.println(cnt);
	}
	

}
