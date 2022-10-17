import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution16234 {
	public static int n;
	public static int l;
	public static int r;
	public static int[][] map;
	public static int[][] visit;
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	
	public static class Location {
		int row;
		int col;
		
		Location(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
//	public static class UnionInfo {
//		int num;
//		int aver;
//		UnionInfo(int num, int aver) {
//			this.num = num;
//			this.aver = aver;
//		}
//	}
	
//	public static List<Integer> unionInfo = new ArrayList<>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while (true) {
			if(check()) break;
			
			time++;
			List<Integer> info = new ArrayList<>();
			visit = new int[n][n];
			int areaNum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(visit[i][j] != 0) continue;
					areaNum++;
					info.add(union(i, j, areaNum));
				}
			}
			// move
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int div = info.get(visit[i][j] - 1);
					map[i][j] = div;
				}
			}
		}
		System.out.println(time);
		
	}
	
	public static int union(int row, int col, int areaNum) {
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(row, col));
		int summation = 0;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Location now = q.poll();
			if(visit[now.row][now.col] != 0) continue;
			visit[now.row][now.col] = areaNum;
			cnt++;
			summation += map[now.row][now.col];
			for(int i = 0; i < 4; i++) {
				int nr = now.row + dr[i];
				int nc = now.col + dc[i];
				if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if(visit[nr][nc] != 0) continue;
				int diff = Math.abs(map[now.row][now.col] - map[nr][nc]);
				if(diff < l || diff > r) continue;
				q.add(new Location(nr, nc));
 			}
		}
		int div = summation / cnt;
		return div;
	}
	public static boolean check() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
					int diff = Math.abs(map[nr][nc] - map[i][j]);
					if(diff >= l && diff <= r) return false;
				}
			}
		}
		return true;
	}

}
