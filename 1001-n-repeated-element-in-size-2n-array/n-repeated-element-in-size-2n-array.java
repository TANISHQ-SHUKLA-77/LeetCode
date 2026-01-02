class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i:nums)
        {
            if(!s.add(i))
              return i;
        }
        return nums[nums.length-1];
    }
}