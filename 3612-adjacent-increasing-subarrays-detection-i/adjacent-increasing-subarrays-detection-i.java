class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
       
        int n = nums.size();

        int x = 2 * k - 1;

        boolean flag = false;

        for(int i = 1; i < n; i++) {
           
            if(x == 0) return true;
            
            if(nums.get(i - 1) < nums.get(i)) x--;

            else if(x <= k && !flag) {
                x = k - 1;
                flag = true;
            } 
            else {
                x = 2 * k - 1;
                flag = false;
            }
        }

        return (x == 0);
    }
}