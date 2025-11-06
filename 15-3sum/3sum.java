class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        var res = new ArrayList<List<Integer>>();
        if (nums[0] > 0) return res; 
        for (int i = 0; i < n - 2; ++i) {
            if (nums[i] > 0) break; 
            if (i > 0 && nums[i] == nums[i - 1]) continue; 
            int target = - nums[i];
            twoSum(nums, i + 1, target, res);
        }
        return res;
    }

    private void twoSum(int[] nums, int i, int target, List<List<Integer>> res) {
        int j = nums.length -1;
        while (i < j) {
            int val = nums[i] + nums[j];
            if (val > target) {
                --j;
                continue;
            }
            if (val < target) {
                ++i;
                continue;
            }
            res.add(Arrays.asList(-target, nums[i], nums[j]));
            while (i < j && nums[i] == nums[i + 1]) ++i; 
            while (i < j && nums[j] == nums[j - 1]) --j; 
            ++i;
            --j;
        }
    }
}