class Solution {
    static final int MAX_WSZ = 5;
    static int[][] weight = new int[MAX_WSZ][MAX_WSZ];
    static {
        weight[0][0] = 1;
        for (int i = 0; i < MAX_WSZ; ++i) {
            weight[i][0] = weight[i][i] = 1;
            for (int j = 1; j < i; ++j)
                weight[i][j] = (weight[i-1][j-1] + weight[i-1][j]) % MAX_WSZ;
        }
    };

    private int combMod5(int n, int k) {
        int res = 1;
        while (n > 0 || k > 0) {
            int ni = n % 5, ki = k % 5;
            if (ki > ni) return 0;
            res = (res * weight[ni][ki]) % 5;
            n /= 5;
            k /= 5;
        }
        return res;
    }

    private int combMod2(int n, int k) {
        return ((k & (n-k)) == 0) ? 1 : 0;
    }

    private int cRemainderTheorem(int rem2, int rem5) {
        if ((rem5 & 1) != rem2) rem5 += 5;
        return rem5;
    }

    public int triangularSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int coeff = cRemainderTheorem(combMod2(n-1, i), combMod5(n-1, i));
            res = (res + nums[i] * coeff) % 10;
        }
        return res;
    }
}