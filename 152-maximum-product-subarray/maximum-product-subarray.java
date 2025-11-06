class Solution {
    public int maxProduct(int[] nums) {
        int l =1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            l*=nums[i];
            ans =Math.max(l,ans);
            if(l==0){l=1;}
        }
        l=1;
        for(int i = nums.length-1;i>=0;i--){
            l*=nums[i];
            ans=Math.max(l,ans);
            if(l==0){l=1;}
        }
        return ans;
    }
}