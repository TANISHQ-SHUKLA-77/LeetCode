class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length ;
        int pre = 1 ;
        int suff = 1 ;
        int ans = nums[0] ;
        for(int i = 0 ; i<n ; i++){
            if(pre == 0){
                pre = 1 ;
            }
            if(suff == 0){
                suff = 1 ;
            }
            pre = pre*nums[i] ;
            suff = suff*nums[n-1-i] ;

            ans = Math.max(ans,Math.max(pre , suff)) ;

        }
         return ans;
    }
}