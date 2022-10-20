import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new int[n];
        for(int i = 0; i < n; i++) {
            if(visit[i] != 0) continue;
            answer++;
            bfs(i, n, answer, computers);
        }
        return answer;
    }
    public void bfs(int s, int n, int cnt, int[][] computers) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        while (!q.isEmpty()) {
            int now = q.poll();
            if(visit[now] != 0) continue;
            System.out.println(now);
            visit[now] = cnt;
            for(int i = 0; i < n; i++) {
                System.out.print(i);
                if(now == i) continue;
                if(computers[now][i] == 0) continue;
                if(visit[i] != 0) continue;
                q.add(i);
            }
        }
    }
}