
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        
        int n = spells.length;
        int m = potions.length;

        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {

            long spell = spells[i];

            double required = (double) success / spell;
            
            int idx = search(potions, required);
            
            ans[i] = m - idx;
        }
        return ans;
    }

    private int search(int[] arr, double target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < target) low = mid + 1;
            
            else high = mid;

        }
        return low;
    }
}