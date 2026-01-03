class Solution {
    private final int MOD = 1_000_000_000 + 7;
    public int numOfWays(int n) {
        long waysUsing3Color = 6l, waysUsing2Color = 6l;
        for(int index = 2; index <= n; index++) {
            long T_Ways_3Color = (2 * waysUsing2Color + 2 * waysUsing3Color) % MOD;
            long T_Ways_2Color = (3 * waysUsing2Color + 2 * waysUsing3Color) % MOD;
            waysUsing2Color = T_Ways_2Color;
            waysUsing3Color = T_Ways_3Color;
        }
        return ((int)((waysUsing3Color + waysUsing2Color) % MOD));
    }
}