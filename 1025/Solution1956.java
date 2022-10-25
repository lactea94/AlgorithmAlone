package BOJ_1025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/1956
public class Solution1956 {
	public static int[][] dist;
	public static final int max_num = 30000;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		dist = new int[v + 1][v + 1];
		for(int i = 1; i <= v; i++) {
			for(int j = i + 1; j <= v; j++) {
				dist[i][j] = max_num;
				dist[j][i] = max_num;
			}
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			dist[start][end] = r;
		}
		
		floyd(v);
		int answer = Integer.MAX_VALUE;
		for(int i = 1; i <= v; i++) {
			answer = Math.min(answer, bfs(v, i));
		}
		if(answer == Integer.MAX_VALUE - 1) System.out.println(-1);
		else System.out.println(answer);
	}
	public static void floyd(int v) {
		for(int k = 1; k <= v; k++) {
			for(int i = 1; i <= v; i++) {
				for(int j = 1; j <= v; j++) {
					if(i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
	public static class Info implements Comparable<Info>{
		int nod;
		int distance;
		Info(int nod, int distance) {
			this.nod = nod;
			this.distance = distance;
		}
		@Override
		public int compareTo(Info target) {
			return this.distance <= target.distance ? -1 : 1;
		}
	}
	public static int bfs(int v, int start) {
		PriorityQueue<Info> q = new PriorityQueue<>();
		boolean[] visit = new boolean[v + 1];
		for(int i = 1; i <= v; i++) {
			if(start == i) continue;
			if(dist[start][i] == max_num) continue;
			q.add(new Info(i, dist[start][i]));
		}
		while(!q.isEmpty()) {
			Info now = q.poll();
			if(now.nod == start) {
				return now.distance;
			}
			if(visit[now.nod]) continue;
			visit[now.nod] = true;
			for(int i = 1; i <= v; i++) {
				if(now.nod == i) continue;
				if(visit[i]) continue;
				if(dist[now.nod][i] == max_num) continue;
				q.add(new Info(i, now.distance + dist[now.nod][i]));
			}
		}
		return Integer.MAX_VALUE - 1;
	}
}
