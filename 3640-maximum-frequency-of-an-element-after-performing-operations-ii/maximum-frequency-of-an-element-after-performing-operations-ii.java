class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        List<Integer> unique = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if((i>0 && nums[i-1]!=nums[i]) || i==0){
                unique.add(nums[i]);
            }
        }
        Map<Integer, Integer> calc = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(calc.containsKey(nums[i])) continue;
            int left = 0, leftInd = i, right = i;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(nums[mid]>=nums[i]-k){
                    leftInd = mid;
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            int rightInd = i;
            right = nums.length-1;
            left = i;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(nums[mid]<=nums[i]+k){
                    rightInd = mid;
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            ans = Math.max(ans, map.get(nums[i])+Math.min(rightInd-leftInd+1-map.get(nums[i]), numOperations));
            calc.put(nums[i], ans);
        }
        int left = 0, right = 0;
        while(left<=right&&right<nums.length){
            if(nums[right]-nums[left]<=2*k){
                ans = Math.max(ans, Math.min(numOperations, right-left+1));
                right++;
            }
            else{
                left++;
            }
        }
        return ans;
    }
}