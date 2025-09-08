class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        
        int n = order.length;
        int m = friends.length;

        int idx = 0;
        int[] ans = new int[m];
        

        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if (friends[j] == order[i]) {
                    ans[idx] = order[i];
                    
                    idx++;
                }
            }
        }

        return ans;
    }
}