import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7569 {
	public static int[][][] tower;
	public static boolean[][][] visit;
	public static int N;
	public static int M;
	public static int H;
	public static int[] dr = new int[] {0, 1, 0, -1, 0, 0};
	public static int[] dc = new int[] {1, 0, -1, 0, 0, 0};
	public static int[] dh = new int[] {0, 0, 0, 0, -1, 1};
	public static Queue<Position> q = new LinkedList<Position>();
	
	public static class Position {
		int height;
		int row;
		int col;
		int time;
		
		Position() {}
		Position(int height, int row, int col, int time) {
			this.height = height;
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tower = new int[H][N][M];
		visit = new boolean[H][N][M];
		boolean flag = true;
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					tower[i][j][k] = Integer.parseInt(st.nextToken());
					if(tower[i][j][k] == 0) flag = false;
					if(tower[i][j][k] == 1) {
						Position posi = new Position(i, j, k, 0);
						q.add(posi);
					}
				}
			}
		}
		if(flag) {
			System.out.println(0);
		} else {
			int t = bfs();
			System.out.println(check() ? t : -1);
		}
	}
	public static int bfs() {
		int cnt = 0;
		while(!q.isEmpty()) {
			Position tmp = q.poll();
			int h = tmp.height;
			int r = tmp.row;
			int c = tmp.col;
			if(visit[h][r][c]) continue;
			visit[h][r][c] = true;
			tower[h][r][c] = 1;
			cnt = Math.max(cnt, tmp.time);
			for(int i = 0; i < 6; i++) {
				int nh = h + dh[i];
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(tower[nh][nr][nc] != 0) continue;
				if(visit[nh][nr][nc]) continue;
				q.add(new Position(nh, nr, nc, tmp.time + 1));
			}
		}
		return cnt;
	}
	public static boolean check() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(tower[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}
}
