package BOJ_1025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/7662
public class Solution7662 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[]) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			System.out.println(dualPriorityQueue(k));
		}
	}
	public static class Info implements Comparable<Info> {
		long value;
		int idx;
		
		Info(long value, int idx) {
			this.value = value;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Info target) {
			if(this.value == target.value) return this.idx <= target.idx ? -1 : 1;
			else return this.value <= target.value ? -1 : 1;
		}
	}
	public static String dualPriorityQueue(int k) throws IOException {
		PriorityQueue<Info> maxHeap = new PriorityQueue<>();
		PriorityQueue<Info> minHeap = new PriorityQueue<>();
		StringTokenizer st;
		boolean[] deleted = new boolean[k];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			long num = Long.parseLong(st.nextToken());
			if(oper.equals("I")) {
				maxHeap.add(new Info(num * -1, i));
				minHeap.add(new Info(num, i));
			} else {
				if(num == 1) {
					while(!maxHeap.isEmpty()) {
						Info tmp = maxHeap.poll();
						if(deleted[tmp.idx]) continue;
						deleted[tmp.idx] = true;
						break;
					}
				} else {
					while(!minHeap.isEmpty()) {
						Info tmp = minHeap.poll();
						if(deleted[tmp.idx]) continue;
						deleted[tmp.idx] = true;
						break;
					}
				}
			}
		}
		while(!maxHeap.isEmpty()) {
			Info tmp = maxHeap.peek();
			if(deleted[tmp.idx]) {
				maxHeap.poll();
				continue;
			}
			break;
		}
		while(!minHeap.isEmpty()) {
			Info tmp = minHeap.peek();
			if(deleted[tmp.idx]) {
				minHeap.poll();
				continue;
			}
			break;
		}
		StringBuilder sb= new StringBuilder();
		if(minHeap.isEmpty() && maxHeap.isEmpty()) sb.append("EMPTY");
		else {
			sb.append(maxHeap.peek().value * -1);
			sb.append(" ");
			sb.append(minHeap.peek().value);
		}
		return sb.toString();
	}
}
