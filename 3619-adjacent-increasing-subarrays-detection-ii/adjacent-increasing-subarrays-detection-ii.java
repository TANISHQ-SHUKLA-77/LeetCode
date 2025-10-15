class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
       
       Integer[] arr = nums.toArray(Integer[]::new);

        int n = arr.length;
        int i = 0;
        int ans = 0;
        int prev = 0;

        while (i < n) {
            int start = i;

            while (i + 1 < n && arr[i] < arr[i+1]) i++;
            
            int curr = i - start + 1;
            ans = Math.max(ans, Math.max(curr >> 1, Math.min(curr, prev)));
            
            prev = curr;
            i++;
        }
        
        return ans;
    }
}