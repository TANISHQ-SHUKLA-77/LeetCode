class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] charFirst = new int[26];
        int[] posBit = new int[n];
        Arrays.fill(charFirst, -1);

        int bits = 0;
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            posBit[i] = bits |= 1 << idx;
            if (charFirst[idx] == -1) {
                charFirst[idx] = i;
                bits = 0;
            }
        }

        int res = 0;
        for (int i = n - 1; i >= 2; i--) {
            int idx = s.charAt(i) - 'a';
            if (charFirst[idx] <= -1 || charFirst[idx] == i) {
                continue;
            }
            res += Integer.bitCount(arrOr(charFirst[idx] + 1, i - 1, posBit));
            charFirst[idx] = -2;
        }
        return res;
    }

    private int arrOr(int start, int end, int[] arr) {
        int res = 0;
        for (int i=start; i<=end; i++) {
            res |= arr[i];
        }
        return res;
    }

}