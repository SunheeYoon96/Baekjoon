
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayDeque<Integer> arrD = new ArrayDeque<Integer>();
		
		for(int i=1; i<=N; i++) {
			arrD.offer(i);
		}
		
		while(arrD.size()>1) {
			arrD.pollFirst();
			arrD.addLast(arrD.pollFirst());
		}
		
		System.out.println(arrD.pollFirst());

	}

}
