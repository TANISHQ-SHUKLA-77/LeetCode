class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        int n = nums.length;

        for(int i=0; i<n; i++){

            if(nums[i] == original) return findFinalValue(nums, original * 2);

        }
        return original;
    }
}