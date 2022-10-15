import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/1967
public class Solution1967 {
	public static int n;
	public static class Info {
		int nod;
		int len;
		
		Info(int nod, int len) {
			this.nod = nod;
			this.len = len;
		}
	}
	public static class Nod {
		int nodNum;
		List<Info> neighbor = new ArrayList<>();
		
		Nod(int nodNum) {
			this.nodNum = nodNum;
		}
		void addNod(Info info) {
			this.neighbor.add(info);
		}
	}
	public static Nod[] tree;
	public static boolean[] visit; 
	public static int answer = 0;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		tree = new Nod[n + 1];
		visit = new boolean[n + 1];
		for(int i = 0; i <= n; i++) {
			tree[i] = new Nod(i);
		}
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int par = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			tree[par].addNod(new Info(child, len));
			tree[child].addNod(new Info(par, len));
		}
		
		for(int i = 2; i <= n; i++) {
			if(tree[i].neighbor.size() != 1) continue;
			dfs(i, 0);
		}
		System.out.println(answer);
	}
	public static void dfs(int now, int curNum) {
		boolean flag = true;
		visit[now] = true;
		for(Info tmp : tree[now].neighbor) {
			int next = tmp.nod;
			int add = tmp.len;
			if(visit[next]) continue;
			flag = false;
			dfs(next, curNum + add);
		}
		if(flag) {
			answer = Math.max(answer, curNum);
		}
		visit[now] = false;
	}
}
