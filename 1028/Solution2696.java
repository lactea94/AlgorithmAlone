package BOJ_1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/2696
public class Solution2696 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			int m = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> heap = new PriorityQueue<>();
			int[] board = new int[m];
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();	
			int count = 0;
			int idx = 0;
			for(int i = 0; i < (m / 10) + 1; i++) {
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					board[idx] = Integer.parseInt(st.nextToken());
					idx++;
				}
			}
			sb.append((m + 1) / 2);
			sb.append("\n");
			for(int i = 0; i < m; i++) {
				int num = board[i];
				heap.add(num);
				if(i == 0) {
					sb.append(num);
					sb.append(" ");
					count++;
					continue;
				}
				if(i % 2 == 0) {
					Stack<Integer> s = new Stack<>();
					int cnt = i / 2;
					while(cnt > 0) {
						s.add(heap.poll());
						cnt--;
					}
					sb.append(heap.peek());
					sb.append(" ");
					count++;
					while(!s.isEmpty()) {
						heap.add(s.pop());
					}
				}
				if(count == 10) {
					sb.append("\n");
					count = 0;
				}
			}
			System.out.println(sb.toString());
		}
	}
}
