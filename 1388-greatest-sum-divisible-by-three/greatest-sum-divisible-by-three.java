class Solution {
    public int maxSumDivThree(int[] nums) {
        int d0 = 0, d1 = 0, d2 = 0;
        int p0 = 0, p1 = Integer.MIN_VALUE, p2 = Integer.MIN_VALUE;
        for (int num : nums) {
            int r = num % 3;
            if (r == 0) {
                d0 = p0 + num;
                d1 = p1 + num;
                d2 = p2 + num;
            } else if (r == 1) {
                d0 = Math.max(p0, p2 + num);
                d1 = Math.max(p1, p0 + num);
                d2 = Math.max(p2, p1 + num);
            } else {
                d0 = Math.max(p0, p1 + num);
                d1 = Math.max(p1, p2 + num);
                d2 = Math.max(p2, p0 + num);
            }
            p0 = d0;
            p1 = d1;
            p2 = d2;
        }

        return d0;
    }
}