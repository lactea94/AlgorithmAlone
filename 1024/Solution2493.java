import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/2493
public class Solution2493 {
	public static class Tower {
		int height;
		int idx;
		
		Tower(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}
	public static int[] answer;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		answer = new int[n];
		Stack<Tower> stack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		stack.add(new Tower(Integer.parseInt(st.nextToken()), 1));
	
		for(int i = 2; i < n + 1; i++) {
			int now = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(now < stack.peek().height) {
					answer[i - 1] = stack.peek().idx;
					break;
				}
				stack.pop();
			}
			stack.add(new Tower(now, i));
		}
		StringBuilder sb = new StringBuilder();
		sb.append(answer[0]);
		for(int i = 1; i < n; i++) {
			sb.append(" " + answer[i]);
		}
		System.out.println(sb.toString());
	}
}
