class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] next = dp.clone();

            for (int r = 0; r < 3; r++) {
                if (dp[r] != Integer.MIN_VALUE) {  
                    int newSum = dp[r] + num;
                    int newR = newSum % 3;
                    if (newR < 0){
                        newR += 3;
                    }       
                    next[newR] = Math.max(next[newR], newSum);
                }
            }

            dp = next;
        }

        return dp[0];
    }
}