import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1022
public class Solution1022 {
	public static int r1;
	public static int c1;
	public static int r2;
	public static int c2;
	public static int rowLen;
	public static int colLen;
	public static int[][] board;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		rowLen = r2 - r1 + 1;
		colLen = c2 - c1 + 1;
		board = new int[rowLen][colLen];
		
		int originRow = -r1;
		int originCol = -c1;
		int maxData = makeCircle(originRow, originCol, rowLen * colLen);
		int cntBlank = Integer.toString(maxData).length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < rowLen; i++) {
			for(int j = 0; j < colLen; j++) {
				String now = Integer.toString(board[i][j]);
				int needBlank = now.length();
				for(int k = 0; k < cntBlank - needBlank; k++) {
					sb.append(" ");
				}
				sb.append(now);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	public static int makeCircle(int row, int col, int checkInt) {
		int cnt = 1;
		int[] dr = {0, -1, 0, 1};
		int[] dc = {1, 0, -1, 0};
		int dir = 0;
		int check = 0;
		if(row >= 0 && row < rowLen && col >= 0 && col < colLen) {
			board[row][col] = 1;
			check += 1;
		}
		
		while(check < checkInt) {
			int moveLen = dir / 2 + 1;
			for(int i = 0; i < moveLen; i++) {
				row += dr[dir % 4];
				col += dc[dir % 4];
				cnt += 1;
				if(row < 0 || row >= rowLen || col < 0 || col >= colLen) continue;
				board[row][col] = cnt;
				check += 1;
				if(check == checkInt) break;
			}
			dir += 1;
		}
		return cnt;
	}
}
