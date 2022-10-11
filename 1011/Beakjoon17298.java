import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/17298
public class Beakjoon17298 {
	public static int N;
	public static int[] board;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[N];
		int[] answer = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.add(board[N - 1]);
		answer[N - 1] = -1;
		for(int i = N - 2; i >= 0; i--) {
			while(!stack.isEmpty() && stack.getLast() <= board[i]) {
				stack.pollLast();
			}
			answer[i] = stack.isEmpty() ? -1 : stack.getLast();
			stack.add(board[i]);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < N; i++) {
			bw.write(Integer.toString(answer[i]));
			bw.write(" ");
		}
		bw.flush();
		bw.close();
	}
}
