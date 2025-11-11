class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        final int rows = m+1, cols = n+1;
        int[][] dp = new int[m+1][n+1];
        for (String s : strs) {
            int zeros = 0;
            for(char c : s.toCharArray()) if (c == '0') ++zeros;
            int ones = s.length() - zeros;

            for (int z = m; z >= zeros; --z) {
                for (int o = n; o >= ones; --o) {
                   
                    int added = 1 + dp[z-zeros][o-ones];
                    if (added > dp[z][o]) dp[z][o] = added;
                }
            }
        }
        return dp[m][n];
    }
}