import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static double dist, answer;
	static int X, Y, D, T, jumpCnt; //시작좌표 x,y , 1번 점프당 거리 , 점프하려면 걸리는시간

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		X = Integer.parseInt(tokens.nextToken());
		Y = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		
		dist = Math.sqrt(X*X + Y*Y);
		jumpCnt = (int)(dist/D);
		answer = 0;
		
		//1. 그냥 걸어가거나, 점프 하고 남은 거리만 걸어갈 때
		answer = Math.min(dist, (dist-jumpCnt*D)+jumpCnt*T);
		
		//2. 원점을 지나서 한번더 점프를 하고 걸어서 원점으로 돌아올 때 
		answer = Math.min(answer, (jumpCnt+1)*D - dist +(jumpCnt+1)*T);
		
		//3. 원점을 다이렉트로 가지 않고 꺽어서 가야하는 경우
		if(jumpCnt<=0) {
			//길이가 점프보다 작아서 두번 꺽어서 점프해서 갈때
			if(dist < D) {
				answer = Math.min(answer, (double)2*T);
			}
			
		}else { //최대점프수 + 1 한번더 꺽어서 가는거
			answer = Math.min(answer, (double)(jumpCnt+1)*T);
		}
		
		
		
		System.out.println(answer);
				

	}

}