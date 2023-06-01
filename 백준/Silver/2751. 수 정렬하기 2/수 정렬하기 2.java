import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Array.sort(퀵정렬) 는 nlogn 이지만 최악의 경우 n^2이기 때문에 시간초과남
 * 
 * [해결방법]
 * 1. Collections.sort(TimSort)
 * 2. counting sort(계수정렬) O(n)으로 매우 빠른 방법
 * */

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N, numbers[];
	static ArrayList<Integer> nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		
		numbers = new int[N];
		nums = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(input.readLine());
			//numbers[i] = Integer.parseInt(input.readLine());
			nums.add(x);
		}
		
		/**
		 * 얜 안되는 코드
		 * Arrays.sort(numbers);
		*/
		
		//arraylist의 timsort
		Collections.sort(nums);
		
		for(int val : nums) {
			output.append(val).append("\n");
		}
		
		System.out.println(output);
		

	}

}