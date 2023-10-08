import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N, nums[], numCount[];
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		nums = new int[N];
		numCount = new int[8001];
		
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(input.readLine());
			nums[i] = now;
			if(now == 0) {
				numCount[4000]++;
			}else {
				numCount[now+4000]++;
			}
		}
		
		//산술평균(소수점 이하 첫째자리에서 반올림)
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += nums[i];
		}
		output.append((int)Math.round((double)sum/N)).append("\n");
		
		Arrays.sort(nums);
		
		//중앙값
		int idx = N/2;
		output.append(nums[idx]).append("\n");
		
		//최빈값 (여러개일 경우 최빈값 중 두번째로 작은 값)
		int maxCnt = 0;
		for (int i = 0; i < 8001; i++) {
			maxCnt = Math.max(maxCnt, numCount[i]);
		}
		
		ArrayList<Integer> tmpCnt = new ArrayList<>();
		
		for (int i = 0; i < 8001; i++) {
			if(numCount[i] == maxCnt) {
				tmpCnt.add(i-4000);
			}
		}
		
		Collections.sort(tmpCnt);
		if(tmpCnt.size()==1) {
			output.append(tmpCnt.get(0)).append("\n");			
		}else {
			output.append(tmpCnt.get(1)).append("\n");
		}
		
		//범위
		Arrays.sort(nums);
		int arange = nums[0]*-1 + nums[N-1];
		output.append(arange);
		
		System.out.println(output);

	}

}