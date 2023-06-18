import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int TC, K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		TC = Integer.parseInt(input.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			K = Integer.parseInt(input.readLine());
			
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			
			for (int k = 0; k < K; k++) {
				tokens = new StringTokenizer(input.readLine());
				String cmd = tokens.nextToken();
				int val = Integer.parseInt(tokens.nextToken());
				
				Map.Entry<Integer, Integer> entry = null;
				
				if(cmd.equals("I")) {
					//트리에 동일한값이 있는지 없는지 확인해서 갯수를 val값으로 넣어줌
					treeMap.put(val, treeMap.getOrDefault(val, 0)+1);
				}else if(cmd.equals("D")) {
					if(treeMap.isEmpty()) continue;
					else {
						if(val==-1) {
							entry = treeMap.firstEntry();
							if(entry.getValue()==1) {
								treeMap.remove(entry.getKey());								
							}else {
								treeMap.put(entry.getKey(), entry.getValue()-1);
							}
						}else if(val==1) {
							entry = treeMap.lastEntry();
							if(entry.getValue()==1) {
								treeMap.remove(entry.getKey());								
							}else {
								treeMap.put(entry.getKey(), entry.getValue()-1);
							}
						}
					}
				}
				
			}
			
			if(treeMap.isEmpty()) {
				output.append("EMPTY").append("\n");
			}else {
				output.append(treeMap.lastEntry().getKey())
				.append(" ")
				.append(treeMap.firstEntry().getKey())
				.append("\n");				
			}
			
		}
		
		System.out.println(output);

	}

}