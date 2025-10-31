class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int first = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]+1 == i){
                ans[0] = nums[i];
                first = i;
                break;
            }
        }

        for(int i= first; i<nums.length; i++){
            if(nums[i]+2 == i){
                ans[1] = nums[i];
                break;
            }

        }
        return ans;
    }
}