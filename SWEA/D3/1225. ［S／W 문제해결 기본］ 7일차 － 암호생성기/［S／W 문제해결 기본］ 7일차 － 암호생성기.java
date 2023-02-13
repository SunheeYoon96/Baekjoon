import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder() ;
	static StringTokenizer tokens;
	static ArrayDeque<Integer> q;
	
	
	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		
		q = new ArrayDeque<Integer>();
		
		for(int t=1; ; t++) {
			q.clear();
			//이 문제는 테케의 갯수가 정해지지 않은 문제이다. 
			String line = input.readLine();
            if(line==null) {
                break;
            }
            //이부분은 추가해야지!!!!!!!!!!!!!!!!!!!
			//input.readLine(); //테케번호 버리기
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<8; i++) {
				q.offer(Integer.parseInt(tokens.nextToken()));
			}
			
			//각 칸의 번호 
			int num = 1;
			//각 프로세스마다 빼려는 값
			int x = 1;
			
			//번호가 0보다 작거나 같은 순간 프로그램이 멈춘다고 했으니까.....?
			while(num > 0) {
				//큐에서 맨앞 번호를 꺼내서 연산함
				num = q.poll();
				num -= x;
				x++; //연산하는 수를 하나씩 키운다.
				if(x==6) { //단 사이클이 5니까 6부터는 다시 1로
					x=1;
				}
				if(num<0) { //연산한 수가 0보다 작으면 0으로 
					num=0;
				}
				q.offer(num);
			}
			
			//System.out.println(q);
			output.append("#").append(t).append(" ");
			for(int i=0; i<8; i++) {
				output.append(q.pollFirst()).append(" ");
			}
			output.append("\n");
			
		}
		System.out.println(output);
		
		
		
		
		

	}
	
	static String instr = "1\r\n" + 
			"9550 9556 9550 9553 9558 9551 9551 9551 \r\n" + 
			"2\r\n" + 
			"2419 2418 2423 2415 2422 2419 2420 2415 \r\n" + 
			"3\r\n" + 
			"7834 7840 7840 7835 7841 7835 7835 7838 \r\n" + 
			"4\r\n" + 
			"4088 4087 4090 4089 4093 4085 4090 4084 \r\n" + 
			"5\r\n" + 
			"2945 2946 2950 2948 2942 2943 2948 2947 \r\n" + 
			"6\r\n" + 
			"670 667 669 671 670 670 668 671 \r\n" + 
			"7\r\n" + 
			"8869 8869 8873 8875 8870 8872 8871 8873 \r\n" + 
			"8\r\n" + 
			"1709 1707 1712 1712 1714 1710 1706 1712 \r\n" + 
			"9\r\n" + 
			"10239 10248 10242 10240 10242 10242 10245 10235 \r\n" + 
			"10\r\n" + 
			"6580 6579 6574 6580 6583 6580 6577 6581 \r\n" + 
			"";

}