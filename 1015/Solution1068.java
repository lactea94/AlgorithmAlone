import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/1068
public class Solution1068 {
	public static class Nod {
		int nodNum;
		List<Integer> children = new ArrayList<Integer>();
		
		Nod(int nodNum) {
			this.nodNum = nodNum;
		}
		void addChild(int child) {
			this.children.add(child);
		}
	}
	public static int n;
	public static int root;
	public static int deleted;
	public static Nod[] tree;
	public static boolean visit[];
	public static int cnt = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		tree = new Nod[n];
		visit = new boolean[n];
		for(int i = 0; i < n; i++) {
			tree[i] = new Nod(i);
		}
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == -1) {
				root = i; 
				continue;
			}
			tree[tmp].addChild(i);
		}
		st = new StringTokenizer(br.readLine());
		int deleted = Integer.parseInt(st.nextToken());
		if(deleted == root) {
			System.out.println(0);
		} else {
			visit[deleted] = true;
			dfs(root);
			System.out.println(cnt);
		}
	}
	public static void dfs(int now) {
		boolean flag = true;
		visit[now] = true;
		for(int next : tree[now].children) {
			if(visit[next]) continue;
			flag = false;
			dfs(next);
		}
		if(flag) cnt++;
	}
}
