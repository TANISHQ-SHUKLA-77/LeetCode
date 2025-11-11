class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l=strs.length;
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=l;i++){
            int one=0,zero=0;
            String x=strs[i-1];
            for(char c:x.toCharArray())if(c=='0')zero++;
            one=x.length()-zero;
            for(int j=m;j>=zero;j--){
                for(int k=n;k>=one;k--){
                    if(dp[j-zero][k-one]>0){
                        dp[j][k]=Math.max(dp[j][k],1 + dp[j-zero][k-one]);
                    }
                }
            }
        }
        int ans=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans-1;
    }
}