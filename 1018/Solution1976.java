import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1976

public class Solution1976 {
	public static int n;
	public static int m;
	public static int[] set;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		set = new int[n + 1];
		for(int i = 1; i < n + 1; i++) {
			set[i] = i;
		}

		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());

		for(int i = 1; i < m; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(findSet(start) != findSet(now)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

		
	}
	public static int findSet(int n) {
		if(n == set[n]) return n;
		else return set[n] = findSet(set[n]);
	}
	
	public static boolean check(int a, int b) {
		if (findSet(a) == findSet(b)) return true;
		else return false;
	}
	
	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		
		if(a != b) {
			if(a < b) {
				set[b] = a;
			} else {
				set[a] = b;
			}
		}
	}
}
