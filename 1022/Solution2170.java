import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2170 {
	public static class Line implements Comparable<Line> {
		int start;
		int end;
		
		Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Line target) {
			if(this.start == target.start) return this.end <= target.end ? -1 : 1;
			else return this.start <= target.start ? -1 : 1;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<Line> heap = new PriorityQueue<>();
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			heap.add(new Line(start, end));
		}
		
		int start =-Integer.MAX_VALUE;
		int end = -Integer.MAX_VALUE;
		while(!heap.isEmpty()) {
			Line now = heap.poll();
			if(end < now.start) {
				answer += end - start;
				start = now.start;
				end = now.end;
			} else {
				end = Math.max(now.end, end);
			}
		}
		answer += end - start;
		System.out.println(answer);
	}
}
