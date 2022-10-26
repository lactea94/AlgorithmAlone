package BOJ_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
// https://www.acmicpc.net/problem/1918
public class Solution1918 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eqn = br.readLine();
		StringBuilder converting = new StringBuilder();
		converting.append('(');
		converting.append(eqn);
		converting.append(')');
		eqn = converting.toString();
		
		Map<Character, Integer> comingRank = new HashMap<>();
		Map<Character, Integer> stackRank = new HashMap<>();
		comingRank.put('(', 3);
		comingRank.put('*', 2);
		comingRank.put('/', 2);
		comingRank.put('+', 1);
		comingRank.put('-', 1);
		comingRank.put(')', -1);
		stackRank.put('(', 0);
		stackRank.put('*', 2);
		stackRank.put('/', 2);
		stackRank.put('+', 1);
		stackRank.put('-', 1);
		
		Stack<Character> stack = new Stack<>();
		stack.add(eqn.charAt(0));
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < eqn.length(); i++) {
			char now = eqn.charAt(i);
			if(!comingRank.containsKey(now)) {
				sb.append(now);
			} else {
				if(now == ')') {
					while(stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop();
				} else if(comingRank.get(now) > stackRank.get(stack.peek())) {
					stack.add(now);
				} else {
					while(comingRank.get(now) <= stackRank.get(stack.peek())) {
						sb.append(stack.pop());
					}
					stack.add(now);
				}
			}
		}
		System.out.println(sb.toString());
	}
}
