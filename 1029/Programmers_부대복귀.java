import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
class Solution {
    public List<Integer>[] board;
    public int[] dist;
    public final int maxNum = 1000000000;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        board = new ArrayList[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, maxNum);
        
        for(int i = 0; i <= n; i++) {
            board[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < roads.length; i++) {
            board[roads[i][0]].add(roads[i][1]);
            board[roads[i][1]].add(roads[i][0]);
        }
        dijkstra(destination);

        for(int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]] >= maxNum ? -1 : dist[sources[i]];
        }
        return answer;
    }
    
    public void dijkstra(int destination) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(destination);
        dist[destination] = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : board[now]) {
                if(dist[next] > dist[now] + 1) { 
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}