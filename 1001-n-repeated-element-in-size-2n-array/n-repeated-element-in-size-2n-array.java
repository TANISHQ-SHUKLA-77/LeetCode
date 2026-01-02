class Solution {
    public int repeatedNTimes(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count == 2) {
                return num;
            }
            map.put(num, count);
        }

        return -1; 
    }
}