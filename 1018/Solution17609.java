import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17609

public class Solution17609 {
	public static int n;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			String now = br.readLine();
			int end = now.length() - 1;
			int start = 0;
			boolean isPend = true;
			boolean isPseudo = false;
			while(start < end) {
				if(now.charAt(start) == now.charAt(end)) {
					start++;
					end--;
				} else {
					isPend = false;
					if(start + 1 < end) {
						isPseudo = true;
						int tmpStart = start + 1;
						int tmpEnd = end;
						while(tmpStart < tmpEnd) {
							if(now.charAt(tmpStart) != now.charAt(tmpEnd)) {
								isPseudo = false;
								break;
							}
							tmpStart++;
							tmpEnd--;
						}
					}
					
					if(isPseudo) break;

					if(start < end - 1) {
						isPseudo = true;
						int tmpStart = start;
						int tmpEnd = end - 1;
						while(tmpStart < tmpEnd) {
							if(now.charAt(tmpStart) != now.charAt(tmpEnd)) {
								isPseudo = false;
								break;
							}
							tmpStart++;
							tmpEnd--;
						}
					}
					
					if(isPseudo) break;
				}
				if(!isPend && !isPseudo) {
					System.out.println(2);
					break;
				}
			}
			if(isPend) {
				System.out.println(0);
				continue;
			}
			if(isPseudo) System.out.println(1);
			
		}
		
	}
}
