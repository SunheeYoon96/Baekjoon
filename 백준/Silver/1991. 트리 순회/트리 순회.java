import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static Node HEAD; 
	
	static class Node{
		char root;
		Node left, right;

		public Node(char root, Node left, Node right) {
			super();
			this.root = root;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		
		//항상 트리는 A를 루트로 시작
		HEAD = new Node('A', null, null);
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			char main = tokens.nextToken().charAt(0);
			char left = tokens.nextToken().charAt(0);
			char right = tokens.nextToken().charAt(0);
			//트리노드 생성
			connectNode(HEAD, main, left, right);
		}
		
		//전위순회
		preOrder(HEAD);
		output.append("\n");
		//중위순회
		inOrder(HEAD);
		output.append("\n");
		//후위순회
		PostOrder(HEAD);
		
		System.out.println(output);

	}

	private static void PostOrder(Node node) {//후위순회
		if(node ==null) return;
		PostOrder(node.left);
		PostOrder(node.right);
		output.append(node.root);
	}

	private static void inOrder(Node node) { //중위순회
		if(node ==null) return;
		inOrder(node.left);
		output.append(node.root);
		inOrder(node.right);
	}

	private static void preOrder(Node node) { //전위순회
		if(node ==null) return;
		output.append(node.root);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void connectNode(Node head, char main, char left, char right) {
		//연결할 부모노드를 찾으면
		if(head.root == main) {
			//왼쪽노드 확인
			if(left == '.') {
				head.left = null;
			}else {
				head.left = new Node(left, null, null);
			}
			//오른쪽노드 확인
			if(right=='.') {
				head.right = null;
			}else {
				head.right = new Node(right, null, null);
			}
		}
		//연결할 부모노드를 찾으러 가기
		else {
			if(head.left!=null) connectNode(head.left, main, left, right);
			if(head.right!=null) connectNode(head.right, main, left, right);
		}
		
	}

}