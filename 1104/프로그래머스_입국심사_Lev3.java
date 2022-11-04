import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long start = times[0];
        long end = (long)n * (long)times[times.length - 1];
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for(int time : times) {
                cnt += mid / time;
                if(cnt > n) break;
            }
            if(cnt >= n) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}