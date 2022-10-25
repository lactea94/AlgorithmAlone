import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/13023
public class Solution13023 {
	public static int n;
	public static int m;
	public static List<Integer> relations[];
	public static boolean[] visit;
	public static boolean flag = false;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		relations = new ArrayList[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++) {
			relations[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			relations[tmp1].add(tmp2);
			relations[tmp2].add(tmp1);
		}
		for(int i = 0; i < n; i++) {
			dfs(0, i);
		}
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	public static void dfs(int s, int now) {
		if(s == 4) {
			flag = true;
			return;
		}
		if(flag) return;
		visit[now] = true;
		for(int next : relations[now]) {
			if(visit[next]) continue;
			dfs(s + 1, next);
		}
		visit[now] = false;
	}
}
