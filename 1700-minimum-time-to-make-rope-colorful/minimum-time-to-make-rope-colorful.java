class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        int[] dp = new int[arr.length]; 
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (arr[i] == arr[i - 1]) {
                dp[i] = dp[i - 1] + Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}