package BOJ_1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3020 {
	public static int n;
	public static int h;
	public static int[] natural;
	public static int[] opposite;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		natural = new int[h + 1];
		opposite = new int[h + 1];
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(i % 2 == 0) {
				natural[tmp]++;
			} else {
				opposite[tmp]++;
			}
		}
		for(int i = h - 1; i >= 0; i--) {
			natural[i] = natural[i] + natural[i + 1];
			opposite[i] = opposite[i] + opposite[i + 1];
		}
		int ans = 0;
		int minVal = Integer.MAX_VALUE;
		for(int i = 1; i <= h; i++) {
			int tmp = natural[i] + opposite[h - i + 1];
			if(minVal > tmp) {
				ans = 1;
				minVal = tmp;
			} else if(minVal == tmp){
				ans++;
			}
		}
		System.out.print(minVal + " ");
		System.out.println(ans);
	}

}
