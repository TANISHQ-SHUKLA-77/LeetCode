class Solution {
    public int totalMoney(int n) {
       
        int ans = 0;
        int extraValue = 0;

        for(int i=1;i<=n;i++){

            ans += (i%7 == 0 ? 7 : i%7) + extraValue;

            if (i/7 > extraValue) extraValue++;
        }
    return ans;
    }
}