import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
class Solution {
    public class Relation {
        int par;
        String mine;
        int idx;
        Relation(int par, String mine) {
            this.par = par;
            this.mine = mine;
        }
    }
    public Map<String, Integer> indexTable = new HashMap<>();
    public Relation[] tree;
    public int[] earning;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        earning = new int[enroll.length];
        // tree 생성
        indexTable.put("-", -1);
        for(int i = 0; i < enroll.length; i++) {
            indexTable.put(enroll[i], i);
        }
        tree = new Relation[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            int par = indexTable.get(referral[i]);
            String mine = enroll[i];
            tree[i] = new Relation(par, mine);
        }
        for(int i = 0; i < seller.length; i++) {
            dfs(indexTable.get(seller[i]), amount[i] * 100);
        }
        
        return earning;
    }
    
    public void dfs(int now, int earn) {
        if(now == -1) return;
        int nEarn;
        if((earn / 10) < 1) {
            earning[now] += earn;
            return;
        } else {
            earning[now] += earn - earn / 10;
            dfs(tree[now].par, earn / 10);
        }
    }
}