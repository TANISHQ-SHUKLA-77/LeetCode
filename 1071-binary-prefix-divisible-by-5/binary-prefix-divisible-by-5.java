class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
    Boolean[] result = new Boolean[nums.length];
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      xor = ((xor << 1) | nums[i]) % 5;
      result[i] = (xor % 5) == 0;
    }
    return Arrays.asList(result);
    }
}