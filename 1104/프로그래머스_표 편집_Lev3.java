import java.util.Stack;

class Solution {
    public class Nod {
        int pre;
        int now;
        int next;
        public Nod(int pre, int now, int next) {
            this.pre = pre;
            this.now = now;
            this.next = next;
        }
    }
    public String solution(int n, int k, String[] cmd) {
        boolean[] isDeleted = new boolean[n];
        int[] pre = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        
        Stack<Nod> stack = new Stack<>();
        for(int i = 0; i < cmd.length; i++) {
            String tmp = cmd[i];
            if(tmp.charAt(0) == 'D') {
                String[] t = tmp.split(" ");
                int num = Integer.parseInt(t[1]);
                while(num > 0) {
                    k = next[k];
                    num--;
                }   
            } else if(tmp.charAt(0) == 'U') {
                String[] t = tmp.split(" ");
                int num = Integer.parseInt(t[1]);
                while(num > 0) {
                    k = pre[k];
                    num--;
                }
            } else if(tmp.charAt(0) == 'C') {
                isDeleted[k] = true;
                stack.add(new Nod(pre[k], k, next[k]));
                if(pre[k] != -1) next[pre[k]] = next[k];
                if(next[k] != -1) pre[next[k]] = pre[k];
                if(next[k] != -1) k = next[k];
                else k = pre[k];
            } else {
                Nod res = stack.pop();
                isDeleted[res.now] = false;
                if(res.pre != -1) next[res.pre] = res.now;
                if(res.next != -1) pre[res.next] = res.now;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(isDeleted[i]) sb.append('X');
            else sb.append('O');
        }
        return sb.toString();
    }
}