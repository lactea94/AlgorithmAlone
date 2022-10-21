import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution22942 {
	public static class Circle implements Comparable<Circle>{
		int x;
		int radius;
		Circle(int x, int radius) {
			this.x = x;
			this.radius = radius;
		}
		@Override
		public int compareTo(Circle target) {
			if(this.x == target.x) return this.radius <= target.radius ? -1 : 1;
			else return this.x <= target.x ? -1 : 1;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Circle[] info = new Circle[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			info[i] = new Circle(x, r);
		}
		Arrays.sort(info);
		Stack<Circle> swip = new Stack<>();
		swip.add(info[0]);
		boolean flag = false;
		for(int i = 1; i < n; i++) {
			Circle now = info[i];
			while(!swip.isEmpty()) {
				Circle tmp = swip.peek();
				int dist = now.x - tmp.x;
				if(tmp.radius + now.radius < dist) {
					swip.add(now);
					break;
				}
				if(Math.abs(tmp.radius - now.radius) > dist || dist == 0) {
					swip.pop();
					continue;
				}
				flag = true;
				break;
			}
			if(flag) break;
		}
		if(flag) System.out.println("NO");
		else System.out.println("YES");
	}
}
