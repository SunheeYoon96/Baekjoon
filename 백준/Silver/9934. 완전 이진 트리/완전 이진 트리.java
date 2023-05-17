import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int K, tree[],treeLen;
	static StringBuffer  binaryTree[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		K = Integer.parseInt(input.readLine());
		
		treeLen = (int) (Math.pow(2, K)-1);
		tree = new int[treeLen];
		
		tokens = new StringTokenizer(input.readLine());
		
		for (int i = 0; i < treeLen; i++) {
			tree[i] = Integer.parseInt(tokens.nextToken());
		}
		
		binaryTree = new StringBuffer[K];
		for (int i = 0; i < K; i++) {
			binaryTree[i] = new StringBuffer();
		}
		
		makeBinaryTree(0, treeLen-1, 0); //시작, 끝, 깊이
		
		//이진트리 출력하기
		for (int i = 0; i < K; i++) {
			output.append(binaryTree[i].toString()).append("\n");
		}
		
		System.out.println(output);
	}

	//완전 이진트리 만들기
	private static void makeBinaryTree(int start, int end, int depth) {
		if(depth==K) return;
		
		int mid = (start+end)/2;
		binaryTree[depth].append(tree[mid]).append(" ");
		
		makeBinaryTree(start, mid-1, depth+1); //왼쪽
		makeBinaryTree(mid+1, end, depth+1);   //오른쪽
	}

}