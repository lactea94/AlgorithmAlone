import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(String begin, String target, String[] words) {
        if(dataCheck(target, words)) return 0;
        return transform(begin, target, words);
    }
    public class Pair {
        String str_;
        int idx;
        int cnt;
        
        Pair(String str_, int idx, int cnt) {
            this.str_ = str_;
            this.idx = idx;
            this.cnt = cnt;
        }
        
    }
    public int transform(String begin, String target, String[] words) {
        QueuePair q = new LinkedListPair();
        q.add(new Pair(begin, words.length, 0));
        boolean[] visit = new boolean[words.length + 1];
        while(!q.isEmpty()) {
            Pair now = q.poll();
            if(visit[now.idx]) continue;
            if(now.str_.equals(target)) {
                return now.cnt;
            }
            visit[now.idx] = true;
            for(int i = 0; i  words.length; i++) {
                if(visit[i]) continue;
                if(compareString(now.str_, words[i]) != 1) continue;
                q.add(new Pair(words[i], i, now.cnt + 1));
            }
        }
        return 0;
    }
    public int compareString(String exist, String target) {
        int len = exist.length();
        int result = 0;
        for(int i = 0; i  len; i++) {
            if(exist.charAt(i) != target.charAt(i)) result++;
        }
        return result;
    }
    public boolean dataCheck(String target, String[] words) {
        boolean flag = true;
        for(int i = 0; i  words.length; i++) {
            if(target.equals(words[i])) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}