class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        int prev = 0;

        List<Boolean> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++){

            int mod = ((prev << 1) | nums[i]) % 5;
            
            if(mod == 0) res.add(true);
             
            else res.add(false);
            
            prev = mod;
        }

        return res;
    }
}