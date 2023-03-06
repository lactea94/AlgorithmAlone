import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<Integer>[] nods;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        nods = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            nods[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edge.length; i++) {
            nods[edge[i][0]].add(edge[i][1]);
            nods[edge[i][1]].add(edge[i][0]);
        }
        answer = dijkstra(n);
        return answer;
    }
    public class Nod implements Comparable<Nod>{
        int now;
        int cnt;
        public Nod(int now, int cnt) {
            this.now = now;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Nod target) {
            return this.cnt <= target.cnt ? -1 : 1;
        }
    }
    public int dijkstra(int n) {
        int[] visit = new int[n + 1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        PriorityQueue<Nod> q = new PriorityQueue<>();
        q.add(new Nod(1, 0));
        visit[1] = 0;
        while(!q.isEmpty()) {
            Nod now = q.poll();
            if(now.cnt > visit[now.now]) continue;
            for(int i = 0; i < nods[now.now].size(); i++) {
                int next = nods[now.now].get(i);
                if(visit[next] > now.cnt + 1) {
                    visit[next] = now.cnt + 1;
                    q.add(new Nod(next, now.cnt + 1));
                }
            }
        }
        int maxValue = 0;
        int cnt = 0;
        System.out.println(Arrays.toString(visit));
        for(int i = 1; i < n + 1; i++) {
            if(maxValue < visit[i]){
                maxValue = visit[i];
                cnt = 1;
            } else if(maxValue == visit[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}