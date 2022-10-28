package BOJ_1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/4256
public class Solution4256 {
	public static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] preorder = new int[n];
			int[] inorder = new int[n];
			for(int k = 0; k < 2; k++) {
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < n; i++) {
					if(k == 0) {
						preorder[i] = Integer.parseInt(st.nextToken());
					} else { 
						inorder[i] = Integer.parseInt(st.nextToken());
					}
				}
			}
			sb = new StringBuilder();
			convert(0, n, 0, preorder, inorder);
			System.out.println(sb.toString());
		}
	}
	public static void convert(int s, int e, int pos, int[] preorder, int[] inorder) {
		for(int i = s; i < e; i++) {
			if(inorder[i] == preorder[pos]) {
				convert(s, i, pos + 1, preorder, inorder);
				convert(i + 1, e, pos + i + 1 - s, preorder, inorder);
				sb.append(preorder[pos]);
				sb.append(" ");
			}
		}
		
	}
}
