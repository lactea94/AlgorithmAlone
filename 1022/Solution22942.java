import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution22942 {
	public static class Circle implements Comparable<Circle>{
		int x;
		boolean isOpen;
		int idx;
		Circle(int x, boolean isOpen, int idx) {
			this.x = x;
			this.isOpen = isOpen;
			this.idx = idx;
		}
		@Override
		public int compareTo(Circle target) {
			return this.x <= target.x ? -1 : 1;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Circle> heap = new PriorityQueue<>();
		int n = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			heap.add(new Circle(x - r, true, i));
			heap.add(new Circle(x + r, false, i));
		}
		
		Stack<Circle> stack = new Stack<>();
		boolean flag = false;
		while(!heap.isEmpty()) {
			Circle next = heap.poll();
			if(stack.isEmpty()) {
				stack.add(next);
			} else {
				Circle now = stack.peek();
				if(now.idx == next.idx) {
					stack.pop();
					continue;
				} 
				if(now.isOpen && !next.isOpen) {
					flag = true;
					break;
				}
				stack.add(next);
			}
		}
		
		if(flag) System.out.println("NO");
		else System.out.println("YES");
	}
}
