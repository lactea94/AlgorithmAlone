import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public class Routine implements Comparable<Routine> {
        String start;
        String end;
        public Routine(String start, String end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Routine target) {
            if(this.end.charAt(0) == target.end.charAt(0)) {
                if(this.end.charAt(1) == target.end.charAt(1)) return this.end.charAt(2) <= target.end.charAt(2) ? -1 : 1;
                else return this.end.charAt(1) <= target.end.charAt(1) ? -1 : 1;
            } else {
                return this.end.charAt(0) <= target.end.charAt(0) ? -1 : 1;
            }
        }
    }
    public Routine[] root;
    public boolean[] visit;
    public boolean flag = false;
    public String[] route;
    public String[] solution(String[][] tickets) {
        root = new Routine[tickets.length];
        visit = new boolean[tickets.length];
        route = new String[tickets.length + 1];
        for(int i = 0; i < tickets.length; i++) {
            root[i] = new Routine(tickets[i][0], tickets[i][1]);
        }
        Arrays.sort(root);
        dfs("ICN", 0);
        return route;
    }
    public void dfs(String now, int s) {
        if(flag) return;
        if(s == root.length) {
            route[s] = now;
            flag = true;
            return;
        }
        for(int i = 0; i < root.length; i++) {
            if(!root[i].start.equals(now)) continue;
            if(visit[i]) continue;
            visit[i] = true;
            route[s] = now;
            dfs(root[i].end, s + 1);
            visit[i] = false;
        }
    }
    
}