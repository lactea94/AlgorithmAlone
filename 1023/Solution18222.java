import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.acmicpc.net/problem/18222
public class Solution18222 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		int answer = recursion(n);
		
		System.out.println(answer);
	}
	public static int recursion(long num) {
		if(num == 1) return 0;
		else {
			long i = 1;
			while(i * 2 < num) {
				i *= 2;
			}
			return 1 - recursion(num - i);
		}
	}
}
