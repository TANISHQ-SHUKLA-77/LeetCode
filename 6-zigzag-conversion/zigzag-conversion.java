class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows <= 1 || numRows >= n) return s;

        int cycle = 2 * numRows - 2;
        char[] out = new char[n];
        int p = 0;

        for (int r = 0; r < numRows; r++) {
            for (int j = r; j < n; j += cycle) {
                out[p++] = s.charAt(j);
                int k = j + cycle - 2 * r;
                if (r != 0 && r != numRows - 1 && k < n) {
                    out[p++] = s.charAt(k);
                }
            }
        }
        return new String(out);
    }

}