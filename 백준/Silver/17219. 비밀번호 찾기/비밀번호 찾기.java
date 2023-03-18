import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;


/**
 * [키워드]
 * 사이트와 비밀번호 -> key Value로 묶인데이터
 * 
 * [풀이과정]
 * 해시맵에 저장하고 반환하자.
 * 
 * [입력]
 * 사이트 주소의 수 N(1 ≤ N ≤ 100,000)
 * 비밀번호를 찾으려는 사이트 주소의 수 M(1 ≤ M ≤ 100,000)
 * 
 * [출력] 
 * 비밀번호를 차례대로 하나씩 출력
 * 
 * @since 
 * @see
 * @performance
 * @category #HashMap
 */

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static HashMap<String, String> hashmap;
	static int N, M;
	static String findSite[];

	public static void main(String[] args) throws IOException {
		//input = new BufferedReader(new StringReader(instr));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		hashmap = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			String site = tokens.nextToken();
			String password = tokens.nextToken();
			hashmap.put(site, password);
		}
		
		
		for(int i=0; i<M; i++) {
			String find = input.readLine();
			output.append(hashmap.get(find)).append("\n");
		}
		
		System.out.println(output);
			

	}
	
	private static String instr = "16 4\r\n" + 
			"noj.am IU\r\n" + 
			"acmicpc.net UAENA\r\n" + 
			"startlink.io THEKINGOD\r\n" + 
			"google.com ZEZE\r\n" + 
			"nate.com VOICEMAIL\r\n" + 
			"naver.com REDQUEEN\r\n" + 
			"daum.net MODERNTIMES\r\n" + 
			"utube.com BLACKOUT\r\n" + 
			"zum.com LASTFANTASY\r\n" + 
			"dreamwiz.com RAINDROP\r\n" + 
			"hanyang.ac.kr SOMEDAY\r\n" + 
			"dhlottery.co.kr BOO\r\n" + 
			"duksoo.hs.kr HAVANA\r\n" + 
			"hanyang-u.ms.kr OBLIVIATE\r\n" + 
			"yd.es.kr LOVEATTACK\r\n" + 
			"mcc.hanyang.ac.kr ADREAMER\r\n" + 
			"startlink.io\r\n" + 
			"acmicpc.net\r\n" + 
			"noj.am\r\n" + 
			"mcc.hanyang.ac.kr";
}