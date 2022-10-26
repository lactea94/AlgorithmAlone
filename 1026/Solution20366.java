package BOJ_1026;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/20366
public class Solution20366 {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] board = new int[n];
		for(int i = 0; i < n; i++) {
			board[i] = sc.nextInt();
		}
		Arrays.sort(board);
		int minValue = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int elsa = board[i] + board[j];
				int start = 0;
				int end = n - 1;
				while(start < end) {
					if(start == i || start == j) {
						start++;
						continue;
					}
					if(end == i || end == j) {
						end--;
						continue;
					}
					int anna = board[start] + board[end];
					minValue = Math.min(minValue, Math.abs(elsa - anna));
					if(elsa < anna) {
						end--;
					} else if(elsa > anna){
						start++;
					} else {
						System.out.println(0);
						return;
					}
				}
			}
		}
		System.out.println(minValue);
		
	}
	
}
