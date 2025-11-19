class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        int val = 0;
        Arrays.sort(nums);
        int n = nums.length;


        for(int i=0; i<n; i++){

            if(nums[i] == original){ 
                val = original * 2;
                original = val;
            }

            else val = original;
        }
        return val;
    }
}