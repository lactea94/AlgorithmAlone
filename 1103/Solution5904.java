package BOJ_1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5904 {
	public static char result;
	public static boolean flag = false;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dfs(0, 0, n);
		System.out.println(result);
	}
	public static void dfs(int k, int pre, int n) {
		if(flag) return;
		if(n <= 3) {
			result = n == 1 ? 'm' : 'o';
			flag = true;
			return;
		}
		int len = 2 * pre + k + 3;
		if(n > len) {
			dfs(k + 1, len, n);
		} else {
			if(n == pre + 1) {
				result = 'm';
				flag = true;
				return;
			} else if(n > pre + 1 && n <= pre + k + 2) {
				result = 'o';
				flag = true;
				return;
			} else {
				dfs(0, 0, n - pre - k - 3);
			}
		}
	}
}
