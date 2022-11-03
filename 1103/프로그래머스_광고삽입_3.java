class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        long[] dp = new long[toSec(play_time) + 1];
        for(int i = 0; i < logs.length; i++) {
            String[] tmp = logs[i].split("-");
            int[] se = new int[2];
            for(int j = 0; j < 2; j++) {
                se[j] = toSec(tmp[j]);
            }
            dp[se[0]] += 1;
            dp[se[1]] -= 1;
        }
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i] + dp[i - 1];
        }
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i] + dp[i - 1];
        }
        int playSec = toSec(adv_time);
        int startSec = 0;
        long maxCnt = dp[playSec - 1];
        for(int i = playSec; i < dp.length; i++) {
            if(maxCnt < (dp[i] - dp[i - playSec])) {
                startSec = i - playSec + 1;
                maxCnt = dp[i] - dp[i - playSec];
            }
        }
        answer = secToString(startSec);
        return answer;
    }
    public int toSec(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);
        int second = Integer.parseInt(t[2]);
        return hour * 3600 + minute * 60 + second;
    }
    public String secToString(int second) {
        String[] tmp = new String[3];
        for(int i = 2; i >= 1; i--) {
            int mod = second % 60;
            tmp[i] = mod >= 10 ? Integer.toString(mod) : "0" + Integer.toString(mod);
            second /= 60;
        }
        tmp[0] = second >= 10 ? Integer.toString(second) : "0" + Integer.toString(second);
        return String.join(":", tmp);
    }
}