import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin {
	public static int n;
	public static int k;
	public static int[] info;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		info = new int[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			info[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[k + 1];
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = info[i]; j < k + 1; j++) {
				dp[j] += dp[j - info[i]];
			}
		}
		System.out.println(dp[k]);
	}
}
