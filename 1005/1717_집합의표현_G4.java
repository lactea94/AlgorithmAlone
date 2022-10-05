import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1717
public class ExpressSet {
	public static int n;
	public static int m;
	public static int[] board;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			board[i] = i;
		}
		for(int j = 0; j < m; j++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(oper == 0) {
				joint(a, b);
			} else {
				System.out.println(checkWith(a, b));
			}
			
		}
		System.out.println(Arrays.toString(board));
	}
	public static String checkWith(int a, int b) {
		String answer = (board[findSet(a)] == board[findSet(b)]) ? "YES" : "NO";
		return answer;
	}
	public static void joint(int a, int b) {
		if(a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		board[findSet(b)] = findSet(a);
	}
	public static int findSet(int x) {
		if(x != board[x]) {
			board[x] = findSet(board[x]);
		}
		return board[x];
	}
}
