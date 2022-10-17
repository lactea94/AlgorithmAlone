import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10828
public class Solution10828 {
	public static int n;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		String[] opers = {"push", "top", "size", "empty", "pop"};
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			for(int j = 0; j < 5; j++) {
				if(oper.equals(opers[j])) {
					switch (j){
						case 0:
							stack.add(Integer.parseInt(st.nextToken()));
							break;
						case 1:
							int result2 = stack.isEmpty() ? -1 : stack.peek();
							System.out.println(result2);
							break;
						case 2:
							System.out.println(stack.size());
							break;
						case 3:
							int result4 = stack.isEmpty() ? 1 : 0;
							System.out.println(result4);
							break;
						default:
							int def = stack.isEmpty() ? -1 : stack.pop();
							System.out.println(def);
							break;
					}
				}
			}
		}
	}
}
