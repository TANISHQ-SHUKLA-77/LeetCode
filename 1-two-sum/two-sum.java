class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i=0;i<nums.length;i++){

            int complement=target-nums[i];
            if(freq.containsKey(complement)){
                return new int[]{freq.get(complement),i};
            }
            freq.put(nums[i],i);
        }
        return new int[0];

    }
}