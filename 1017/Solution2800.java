import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/2800
public class Solution2800 {
	public static String line;
	public static List<String> answer = new ArrayList<>();
	public static List<Pair> pair = new ArrayList<>();
	public static boolean[] visit;
	public static class Pair {
		int myNum;
		int paired;
		
		Pair(int myNum, int paired) {
			this.myNum = myNum;
			this.paired = paired;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		line = st.nextToken();
		visit = new boolean[line.length()];
		makePair(line);
		dfs(0, pair.size());
		Collections.sort(answer);
		List<String> r = answer.stream().distinct().collect(Collectors.toList());
		for(int i = 1; i < r.size(); i++) {
			System.out.println(r.get(i));
		}
		
	}
	public static void makePair(String line) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '(') {
				stack.add(i);
			} else if(line.charAt(i) == ')') {
				int tmp = stack.pop();
				Pair p = new Pair(tmp, i);
				pair.add(p);
			}
		}
	}
	public static void dfs(int s, int n) {
		if(s == n) {
			delete(line);
			return;
		}

		Pair tmp = pair.get(s);
		dfs(s + 1, n);
		visit[tmp.myNum] = true;
		visit[tmp.paired] = true;
		dfs(s + 1, n);
		visit[tmp.myNum] = false;
		visit[tmp.paired] = false;

	}
	public static void delete(String line) {
		Stack<String> stack = new Stack<>();
		List<String> result = new ArrayList<>();
		for(int i = 0; i < line.length(); i++) {
			if(visit[i]) {
				result.add(Character.toString(line.charAt(i)));
				continue;
			}
			if(line.charAt(i) == '(') {
				stack.add("(");
			} else if(line.charAt(i) == ')') {
				stack.pop();
			} else {
				result.add(Character.toString(line.charAt(i)));
			}
		}
		answer.add(String.join("", result));
	}
}
