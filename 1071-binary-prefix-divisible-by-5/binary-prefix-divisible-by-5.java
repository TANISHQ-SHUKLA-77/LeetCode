import java.util.*;

class Solution {

  public static final int MIN_LENGTH = 1;
  public static final int MAX_LENGTH = 100_000;


  public List<Boolean> prefixesDivBy5(int[] nums) {
    List<Boolean> list = null;
    if(nums != null) {
      list = new LinkedList<>();
      final int length = nums.length;
      int binary = 0;
      for(int i = 0; i < length; ++i) {
        int bit = nums[i];
        binary <<= 1;
        binary += bit;

        binary %= 5;
        list.add(binary == 0 ? Boolean.TRUE : Boolean.FALSE);
      }
    }
    return list;
  }

  static {
    Solution s = new Solution();
    for(int i = 0; i < 1000; ++i) {
      s.prefixesDivBy5(new int[]{1, 0, 1});
    }
  }
}