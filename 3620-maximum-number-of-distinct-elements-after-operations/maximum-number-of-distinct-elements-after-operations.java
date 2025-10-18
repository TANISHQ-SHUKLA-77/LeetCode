class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        
         Arrays.sort(nums);

        int prev = Integer.MIN_VALUE;
        int count = 0;

        for(int i: nums){
            int low = i-k;
            int high = i+k;
            if(prev<low){
                prev=low;
                count++;
            }
            else if(prev<high){
                prev = prev+1;
                count++;
            }
        }
        return count;
    }
}