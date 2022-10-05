import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14503
public class RobotCleaner {
	public static int N;
	public static int M;
	public static int[][] board;
	public static boolean[][] visit;
	public static int[] dr = {0, -1, 0, 1};
	public static int[] dc = {-1, 0, 1, 0};
	public static int count = 0;
	public static class Robot {
		int row;
		int col;
		int dir;
		
		Robot(int row, int col, int dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		void setDir(int dir) {
			this.dir = dir;
		}
		int getDir() {
			return this.dir;
		}
		void setPosition(int row, int col) {
			this.row = row;
			this.col = col;
		}
		int getRow() {
			return this.row;
		}
		int getCol() {
			return this.col;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		Robot robot = new Robot(row, col, dir);
		board = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(cleaning(robot));
	}
	
	public static int cleaning(Robot r) {
		int cnt = 1;
		
		while(true) {
			int row = r.getRow();
			int col = r.getCol();
			int dir = r.getDir();
			visit[row][col] = true;
			boolean check = true;
			for(int i = 0; i < 4; i++) {
				int nd = (dir + 3 * i) % 4;
				int nr = row + dr[nd];
				int nc = col + dc[nd];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(board[nr][nc] == 1) continue;
				if(visit[nr][nc]) continue;
				check = false;
				cnt += 1;
				r.setPosition(nr, nc);
				r.setDir((nd + 3) % 4);
				break;
			}
			if(check) {
				int backRow = row + dr[(dir + 3) % 4];
				int backCol = col + dc[(dir + 3) % 4];
				if(backRow < 0 || backRow >= N || backCol < 0 || backCol >= M) {
					break;
				}
				if(board[backRow][backCol] == 1) {
					break;
				}
				
				r.setPosition(backRow, backCol);
			}
			
		}
		return cnt;
	}
}
