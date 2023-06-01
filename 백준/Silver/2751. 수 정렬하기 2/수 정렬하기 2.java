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
			numbers[i] = x;
			nums.add(x);
		}
		
		/**
		 * 얜 안되는 코드
		 * Arrays.sort(numbers);
		*/
		
		//1. arraylist의 timsort
		//Collections.sort(nums);
		
		//2. counting sort(계수 정렬)
		countingSort(numbers);
		
//		for(int val : nums) {
//			output.append(val).append("\n");
//		}
		
		System.out.println(output);
		

	}

	//카운팅 정렬
	private static void countingSort(int[] arr) {
		
		//수의 범위
		// -1,000,000 ~ 1,000,000
		//기준 0 의 인덱스를 1,000,000 로 잡는다.
		
		boolean[] counting = new boolean[2000001];
		
		for (int i = 0; i < N; i++) {
			int idx = arr[i] + 1000000;
			counting[idx] = true;
		}
		
		for (int i = 0; i < counting.length; i++) {
			if(counting[i]) {
				output.append(i-1000000).append("\n");
				
			}
		}
		
		
	}

}