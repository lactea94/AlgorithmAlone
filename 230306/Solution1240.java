import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1240 {
	public static class Nod {
		int num;
		int dist;
		
		Nod(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Nod>[] tree = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			tree[i] = new ArrayList<Nod>();
		}
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int nod1 = Integer.parseInt(st.nextToken());
			int nod2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			tree[nod1 - 1].add(new Nod(nod2 - 1, dist));
			tree[nod2 - 1].add(new Nod(nod1 - 1, dist));
		}
		
		for(int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			start--;
			end--;
			
			int answer = 0;
			
			boolean[] visit = new boolean[n];
			
			Queue<Nod> q = new LinkedList<>();
			for(Nod item : tree[start]) {
				q.add(item);
			}
			
			visit[start] = true;
			
			while(!q.isEmpty()) {
				Nod now = q.poll();
				if(now.num == end) {
					answer = now.dist;
					break;
				}
				if(visit[now.num]) continue;
				visit[now.num] = true;
				for(Nod item : tree[now.num]) {
					Nod con = new Nod(item.num, now.dist + item.dist);
					q.add(con);
				}
			}
			System.out.println(answer);
		}
	}
}
