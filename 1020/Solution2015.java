import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2015 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long answer = 0L;
		int[] arr = new int[n + 1];
		Map<Integer, Long> map = new HashMap<>();

		for(int i = 1; i <= n; i++) {
			int tmp = sc.nextInt();
			arr[i] = tmp + arr[i - 1];
			if(arr[i] == k) {
				answer++;
			}
			if(map.containsKey(arr[i] - k)) {
				answer += map.get(arr[i] - k);
			}
			long now = map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1L;
			map.put(arr[i], now);
		}
		sc.close();
		System.out.println(Arrays.toString(arr));
		System.out.println(answer);
	}
}
